/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import adapter.DrinksAdapter;
import java.util.List;

/**
 *
 * @author jinhern
 */
public class MainTester {
    
    //private static DrinksAdapter da = new DrinksAdapter();
    
    public static void main(String[] args) {
        
        List<Drinks> all = DrinksAdapter.getDrinks();
        System.out.println("Total of drinks: " + all.size());
        for (Drinks d : all) {
            System.out.println( d.getId() );
            System.out.println( d.getName() );
            System.out.println( d.getQuantity() );
            System.out.println( d.getSupplier() );
        }
        System.out.println("\n\n");
        
        List<Coke> allCoke = DrinksAdapter.getCoke();
        System.out.println("Total of Cokes: " + allCoke.size());
        for (Coke d : allCoke) {
            System.out.println( d.getId() );
            System.out.println( d.getName() );
            System.out.println( d.getQuantity() );
            System.out.println( d.getSupplier() );
            System.out.println( d.getSlogan() );
        }
        
        
//        TehTarik tehr = new TehTarik();
//        System.out.println( tehr.getAll() );
        
    }
    
}
