/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;

public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //String[] ss = DB.returnAll();
        //for (int i = 1; i < ss.length; i++) {
        //    String ii = String.valueOf(i);
        //    System.out.println(DB.getStockNameByID(ii));
        //    System.out.println(DB.getStockPriceByID(ii));
        //    System.out.println(DB.getStockByID(ii));
        //    System.out.println(DB.getStockAvailabilityByID(ii));
        //    System.out.println(DB.getStockImageByID(ii));
        //}
        //DB.addLine();

        //ArrayList<String> ss = DB.returnAllStockPrice();
        //for (int i = 0; i < ss.size(); i++) {
        //    System.out.println(i + " is = " + ss.get(i));
        //}
        GUI gui = new GUI();
        gui.setVisible(true);
        //1. Define UI Class --> GUI
        //2. Calculation Logic with proper method --> Stock 
        //3. Text Editing(db) w method --> DB
        //4. Admin Page --> GUI 
        //5. Stock Management --> Stock
    }

}
