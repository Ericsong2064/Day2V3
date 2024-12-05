


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> fileData = getFileData("src/file");
        int count = 0;
        int total=0;
        for(int i = 0; i<fileData.size();i++){
            int e =0;
            ArrayList<String>temp = fileData;
            while(e<temp.get(i).length()){
                if(temp.get(i).contains(" ")){
                    nums.add(Integer.parseInt(fileData.get(i).substring(e,temp.get(i).indexOf(" "))));
                    temp.set(i,temp.get(i).substring(temp.get(i).indexOf(" ")+1));
                }else{
                    nums.add(Integer.parseInt(temp.get(i)));
                    e=Integer.MAX_VALUE;
                }
            }
            System.out.println(nums);
            int times1=0;
            int times2=0;
            int times3=0;
            boolean equal=false;
            boolean inc=false;
            boolean dec=false;
            for(int g=0; g<nums.size()-1;g++){
                if(nums.get(g)<nums.get(g+1)){
                    times2++;
                }else if(nums.get(g)>nums.get(g+1)){
                    times1++;
                }else{
                    times3++;
                }
            }
            if(times2>times1 && times2>times3){
                inc=true;
            }else if(times2<times1 && times1>times3){
                dec=true;
            }else{
                equal=true;
            }
            times1=0;
            times2=0;
            times3=0;
            if(!equal) {
                for (int h = 0; h < nums.size() - 1; h++) {
                    if (Math.abs(nums.get(h + 1) - nums.get(h)) < 4 && Math.abs(nums.get(h + 1) - nums.get(h)) > 0) {
                        count++;
                        if (nums.get(h + 1).equals(nums.get(h))) {
                            times3++;
                        }
                    }
                    if (nums.get(h) - nums.get(h + 1) < 0 && dec) {
                        times1++;
                    } else if (nums.get(h) - nums.get(h + 1) > 0 && inc) {
                        times2++;
                    }
                }
            }
            if (times2 > 1) {
                inc = false;
            }
            if (times1 > 1) {
                dec = false;
            }
            if(count == nums.size()-1 && times3<=1 && (inc||dec)){
                total++;
            }
            count=0;
            nums=new ArrayList<>();
        }
        System.out.println(total);
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
