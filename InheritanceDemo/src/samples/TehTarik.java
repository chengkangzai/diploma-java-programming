/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jinhern
 */
public class TehTarik extends Drinks{
    
    @Override
    protected List<String> getAll() {
        List<String> lstAll = super.getAll();
        
        List<String> tehTarikLst = new ArrayList();
        for (String elem : lstAll) {
            //filter the teh tarik records
            String[] split = elem.split("\\|");
            if ( split[1].equalsIgnoreCase("tehtarik") ) {
                tehTarikLst.add(elem);
            }
        }
        return tehTarikLst;
    }
    public static void main(String[] args) {
        System.out.println( new TehTarik().getAll() );
    }
}
