package assignment;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    public static final void testing() {
        System.out.println("Testing");
        System.out.println("You are opening DB class");
    }
    public static final String FILENAME = "stock.csv";
    final static Path dbPath = Paths.get(FILENAME);

    public static String[] returnAll() {
        //System.out.println("--------------Retun All Start--------------");
        List<String> data = null;
        try {
            //System.out.println("--------------Reading All Line from " + FILENAME + "--------------");
            data = Files.readAllLines(dbPath);
        } catch (IOException ex) {
            System.out.println("Error!");
            System.out.println(ex.getMessage());
        }
        // populate the data from list into String[]
        String[] container = new String[data.size()];
        container = data.toArray(container);
        return container;
    }

    public static Object[] returnHeader() {
        String[] data = returnAll();
        List<String> head = null;
        for (int i = 0; i < 1; i++) {
            String[] header = data[i].split("\\,");
            head = Arrays.asList(header);
        }
        return head.toArray();

    }

    public static void echoAll() {
        String[] data = returnAll();
        System.out.print(Arrays.toString(data));
        System.out.println("\n");
    }

    public static void echoSplited() {
        String[] data = returnAll();
        Object[] header = returnHeader();
        int x = 0;
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split("\\,");
            for (int j = 0; j < split.length; j++) {
                System.out.print(header[x] + " : " + split[j] + "\n");
                if (x < header.length - 1) {
                    //Add counter
                    x++;
                } else {
                    //Reset counter
                    System.out.println("--------------------------");
                    x = 0;
                }
            }
        }
    }

    public static void addLine() {
        Scanner read = new Scanner(System.in);
        Object[] header = returnHeader();
        String addline = returnAll().length + "|";
        for (int i = 1; i < header.length; i++) {
            System.out.println("Please enter value of " + header[i]);
            String line = read.next();
            addline += line + " |";
        }
        try {
            System.out.println("adding to database");
            Files.write(dbPath, addline.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //DB Stucter
    // ID , Name , Price , Stock , Image , Available 
    //TODO 
    //1.Read the file 
    //1.1 Read all record
    //1.2 Read by line
    //1.3 Read without headling (table)
    //1.4 Read with vertain ID given
    //2. Data Validation 
    //2.1 Not Negative number for price, Stock
    //2.2 All fill are required 
    //3. Write / Modify the file
    //3.1 Write New Line
    //3.1.1 Upload Picture ...
    //3.2 Change certain value with ID given
}
