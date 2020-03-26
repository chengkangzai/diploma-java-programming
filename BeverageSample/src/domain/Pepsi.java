package domain;

import java.util.ArrayList;
import java.util.List;

public class Pepsi extends CanDrinks{
    
    public static List<String> getAll() {
        List<String> lstAll = Drinks.getAll();
        
        List<String> pepsiLst = new ArrayList();
        for (String elem : lstAll) {
            //filter the coke records
            String[] split = elem.split("\\|");
            if ( split[1].equalsIgnoreCase("pepsi") ) {
                pepsiLst.add(elem);
            }
        }
        return pepsiLst;
    }
    public static void main(String[] args) {
        System.out.println( new Pepsi().getAll() );
    }
}
