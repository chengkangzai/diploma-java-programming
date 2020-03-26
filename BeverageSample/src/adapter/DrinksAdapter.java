package adapter;

import domain.Coke;
import domain.Drinks;
import domain.Pepsi;
import domain.TehTarik;
import java.util.*;

public class DrinksAdapter {
    
    public static List<Drinks> getDrinks(){
        List<String> drks = Drinks.getAll();
        
        //temp collection
        List<Drinks> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            Drinks newDrinks = new Drinks();
            newDrinks.setId( Integer.parseInt(split[0]) );
            newDrinks.setName( split[1] ); 
            newDrinks.setQuantity( split[2] );
            newDrinks.setSupplier( split[3] );
            temp.add(newDrinks);
        }
        return temp;
    }
    
    public static List<Coke> getCoke(){
        List<String> drks = Coke.getAll();
        
        //temp collection
        List<Coke> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            Coke newCoke = new Coke();
            newCoke.setId( Integer.parseInt(split[0]) );
            newCoke.setName( split[1] );
            newCoke.setQuantity( split[2] );
            newCoke.setSupplier( split[3] );
            newCoke.setSlogan(split[4]);
            temp.add(newCoke);
        }
        return temp;
    }
    
    public static List<Pepsi> getPepsi(){
        List<String> drks = Pepsi.getAll();
        
        //temp collection
        List<Pepsi> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            Pepsi newPepsi = new Pepsi();
            newPepsi.setId( Integer.parseInt(split[0]) );
            newPepsi.setName( split[1] );
            newPepsi.setQuantity( split[2] );
            newPepsi.setSupplier( split[3] );
            newPepsi.setSlogan(split[4]);
            temp.add(newPepsi);
        }
        return temp;
    }
    
    public static List<TehTarik> getTehTarik(){
        TehTarik teht = new TehTarik();
        List<String> drks = teht.getAll();
        
        //temp collection
        List<TehTarik> temp = new ArrayList();
        
        for (String line : drks) {
            String[] split = line.split("\\|");
            TehTarik newTeht = new TehTarik();
            newTeht.setId( Integer.parseInt(split[0]) );
            newTeht.setName( split[1] );
            newTeht.setQuantity( split[2] );
            newTeht.setSupplier( split[3] );
            temp.add(newTeht);
        }
        return temp;
    }
    
}
