package domain;

import java.util.ArrayList;
import java.util.List;

public class Coke extends CanDrinks {
    
   public static List<String> getAll() {
        List<String> lstAll = Drinks.getAll();
        
        List<String> cokeLst = new ArrayList();
        for (String elem : lstAll) {
            //filter the coke records
            String[] split = elem.split("\\|");
            if ( split[1].equalsIgnoreCase("coke") ) {
                cokeLst.add(elem);
            }
        }
        return cokeLst;
    }
    
    public static void main(String[] args) {
        System.out.println( new Coke().getAll() );
        Coke newDrinks = new Coke();
//        newDrinks.setId(4);
//        newDrinks.setName("Kopi-O");
//        newDrinks.setQuantity("20");
//        newDrinks.setSupplier("XYZCompany");
//        newDrinks.setSlogan("Im loving it.");
//        newDrinks.addNew();

        newDrinks.setId(1);
        newDrinks.setName("Coke");
        newDrinks.setQuantity("20000");
        newDrinks.setSupplier("XYZCompany");
        newDrinks.setSlogan("Im loving it123.");
        newDrinks.edit();

        
    }
    
}
