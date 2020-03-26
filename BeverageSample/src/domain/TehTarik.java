package domain;

import java.util.ArrayList;
import java.util.List;

public class TehTarik extends Drinks{
    
    public static List<String> getAll() {
        List<String> lstAll = Drinks.getAll();
        
        List<String> tehtarikLst = new ArrayList();
        for (String elem : lstAll) {
            //filter the coke records
            String[] split = elem.split("\\|");
            if ( split[1].equalsIgnoreCase("tehtarik") ) {
                tehtarikLst.add(elem);
            }
        }
        return tehtarikLst;
    }
    public static void main(String[] args) {
        System.out.println( new TehTarik().getAll() );
    }
}
