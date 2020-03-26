package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Drinks {
 
    protected static final String FILENAME = "drinks.txt";
    
    protected int id;
    protected String name;
    protected String quantity;
    protected String supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    public static List<String> getAll(){
        List<String> lst = null;
        try {
            lst = Files.readAllLines(Paths.get(FILENAME));
        } catch (IOException ex) {
            Logger.getLogger(Drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;
    }
    
    public void addNew(){
        String line = String.join("|", Integer.toString(this.getId()), this.getName(), this.getQuantity(), this.getSupplier());
        line += System.lineSeparator();
        writeTo(line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
    public void edit(){
        String newline = String.join("|", Integer.toString(this.getId()), this.getName(), this.getQuantity(), this.getSupplier());
        //newline += System.lineSeparator();
        update(Integer.toString(this.getId()), newline);
    }
    protected void writeTo(String line, StandardOpenOption... mode){
        try {
            Files.write(Paths.get(FILENAME), line.getBytes(), mode);
            System.out.println("Done!");
        } catch (IOException ex) {
            Logger.getLogger(Drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void update(String id, String newRecord){
        //getall records
        List<String> lstAll = Drinks.getAll();
        //newList
        List<String> newLst = new ArrayList();
        //find the target to update
        for (String oldLine : lstAll) {
            if (oldLine.startsWith( id )) {
                newLst.add(newRecord);
            }else{
                newLst.add(oldLine);
            }
        }
        //write back to the file with new content from newLst
        if (newLst.size() > 0) {
//            System.out.println( newLst );
            this.writeTo(newLst.get(0)+System.lineSeparator(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
            for (int i = 1; i < newLst.size(); i++) {
                this.writeTo(newLst.get(i)+System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println( new Drinks().getAll() );
        Drinks newDrinks = new Drinks();
        newDrinks.setId(4);
        newDrinks.setName("Kopi-O-Kaw");
        newDrinks.setQuantity("200");
        newDrinks.setSupplier("XYZCompany");
//        newDrinks.addNew();
//        newDrinks.edit();
    }
    
}
