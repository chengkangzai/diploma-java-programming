package assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {


    public static final String FILENAME = "stock.csv";
    final static Path dbPath = Paths.get(FILENAME);

    public static String[] returnAll() {
        List<String> data = null;
        try {
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

    public static Object[] returnSplitedHeader() {
        String[] data = returnAll();
        List<String> head = null;
        for (int i = 0; i < 1; i++) {
            String[] header = data[i].split("\\,");
            head = Arrays.asList(header);
        }
        return head.toArray();
    }

    public static ArrayList<String> returnAllPicUrl() {
        @SuppressWarnings("unchecked")
        ArrayList<String> picUrl = new ArrayList<String>();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 5; j < split.length; j++) {
                // Add to an array
                picUrl.add(split[j]);
            }
        }
        return picUrl;
    }

    public static ArrayList<String> returnAllStockName() {
        @SuppressWarnings("unchecked")
        ArrayList<String> stockName = new ArrayList<String>();
        for (int i = 1; i < DB.returnAll().length; i++) {
            String id = String.valueOf(i);
            String e = getStockNameByID(id);
            stockName.add(e);
        }
        return stockName;
    }

    public static ArrayList<String> returnAllStockPrice() {
        @SuppressWarnings("unchecked")
        ArrayList<String> stockPrice = new ArrayList<String>();
        for (int i = 1; i < DB.returnAll().length; i++) {
            String id = String.valueOf(i);
            String e = getStockPriceByID(id);
            if (!(e.contains("."))) {
                e += ".00";
            }
            stockPrice.add(e);
        }
        return stockPrice;
    }

    public static ArrayList<String> returnAllStock() {
        @SuppressWarnings("unchecked")
        ArrayList<String> stock = new ArrayList<String>();
        for (int i = 1; i < DB.returnAll().length; i++) {
            String id = String.valueOf(i);
            String e = getStockByID(id);
            stock.add(e);
        }
        return stock;
    }

    public static void echoAll() {
        System.out.println(Arrays.toString(returnAll()) + "\n");
    }

    public static void echoSplited() {
        String[] data = returnAll();
        Object[] header = returnSplitedHeader();
        int x = 0;
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < split.length; j++) {
                System.out.print(header[x] + " : " + split[j] + "\n");
                if (x < header.length - 1) {
                    // Add counter
                    x++;
                } else {
                    // Reset counter
                    System.out.println("--------------------------");
                    x = 0;
                }
            }
        }
    }

    public static void addLine() {
        // TODO :
        // No Negative number for price, stock
        // NO word beside T/F for Avail
        Scanner read = new Scanner(System.in);
        Object[] header = returnSplitedHeader();
        String addLine = returnAll().length + ",";
        for (int i = 1; i < header.length - 1; i++) {
            System.out.println("Please enter value of " + header[i]);
            String line = read.nextLine();
            addLine += line + ",";
        }
        System.out.println("Please enter value of Picture Number");
        String line = read.nextLine();
        addLine += "src/assignment/asset/pic/temp/" + line + ".jpg";

        try {
            System.out.println("adding to database");
            Files.write(dbPath, addLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<String> getAllStockByID(String id) {
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 1; j < 2; j++) {
                // Get ID only
                if (id.equals(split[j])) {
                    System.out.println("Gotcha");
                    String stockName = split[j + 1];
                    String stockPrice = split[j + 2];
                    String stockStock = split[j + 3];
                    String stockAvail = split[j + 4];
                }
            }
        }
        return s;
        // find the line with appriate id
    }

    public static String getStockNameByID(String id) {
        String stockName = null;
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < 1; j++) {
                if (id.equals(split[j])) {
                    stockName = split[j + 1];
                }
            }
        }
        return stockName;
    }

    public static String getStockPriceByID(String id) {
        String price = null;
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < 1; j++) {
                if (id.equals(split[j])) {
                    price = split[j + 2];
                }
            }
        }
        return price;
    }

    public static String getStockByID(String id) {
        String stock = null;
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < 1; j++) {
                if (id.equals(split[j])) {
                    stock = split[j + 3];
                }
            }
        }
        return stock;
    }

    public static String getStockAvailabilityByID(String id) {
        String availability = null;
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < 1; j++) {
                if (id.equals(split[j])) {
                    availability = split[j + 4];
                }
            }
        }
        return availability;
    }

    public static String getStockImageByID(String id) {
        String img = null;
        String[] data = returnAll();
        @SuppressWarnings("unchecked")
        ArrayList<String> s = new ArrayList<String>();
        for (int i = 1; i < data.length; i++) {
            // Spilit the data by ,
            String[] split = data[i].split("\\,");
            for (int j = 0; j < 1; j++) {
                if (id.equals(split[j])) {
                    img = split[j + 5];
                }
            }
        }
        return img;
    }

    public static void reduceStock(String id) {
        String[] data = returnAll();
        int idd = Integer.valueOf(id);
        String line = data[idd];
        String[] splited = line.split("\\,");
        String stock = splited[3];
        int newStock = (Integer.valueOf(stock) - 1);

        data[idd] = splited[0] + "," + splited[1] + "," + splited[2] + "," + String.valueOf(newStock) + "," + splited[4]
                + "," + splited[5];

        String info = data[0] + "\n";
        for (int i = 1; i < data.length; i++) {
            info += data[i] + "\n";
        }

        int status = deleteAndWriteAgain(info);
        if (status == 0) {
            System.out.println("Modifies success ");
        }
        // Read All line
        // If ID match, find the stock
        // Reduce one
        // Delete and write again
    }

    public static int deleteAndWriteAgain(String data) {
        int status= 0;
        try {
            Files.write(dbPath, data.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    // DB Stucter
    // ID , Name , Price , Stock , Image , Available V
    // TODO
    // 1.Read the file V
    // 1.1 Read all record V
    // 1.2 Read by line V
    // 1.3 Read without headling (table) V
    // 1.4 Read with vertain ID given V
    // 2. Data Validation
    // 2.1 Not Negative number for price, Stock
    // 2.2 All fill are required
    // 3. Write / Modify the file
    // 3.1 Write New Line
    // 3.1.1 Upload Picture ...
    // 3.2 Change certain value with ID given
}
