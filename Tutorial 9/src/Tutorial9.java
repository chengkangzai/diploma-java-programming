

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tutorial9 {

    public static void main(String[] args) {
        //String[] data = collectWithArray("nums.txt");
        //for (int i = 0; i < data.length; i++) {
        //    System.out.println(Integer.parseInt(data[i]));
        //}
        ArrayList<String> data = collectWithArrayList("nums.txt");
        for (int i = 0; i < data.size(); i++) {
            System.out.print(data.get(i)+"\n");
        }
        
    }

    static String[] collectWithArray(String fn) {
        String[] nums = null;
        try {
            List<String> lst = Files.readAllLines(Paths.get(fn));
            //Convert the List of String into String[]
            nums = new String[lst.size()]; // Need to Set Array Size
            for (int i = 0; i < lst.size(); i++) {
                nums[i] = lst.get(i);// Array Index is needed
            }
        } catch (IOException ex) {
            String message = ex.getMessage();
            System.out.println(message);
        }

        return nums;
    }

    static ArrayList<String> collectWithArrayList(String fn) {
        ArrayList<String> list = null;

        try {
            list = new ArrayList(Files.readAllLines(Paths.get(fn)));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }

}
