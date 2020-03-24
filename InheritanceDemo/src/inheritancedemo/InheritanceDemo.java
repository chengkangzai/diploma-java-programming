package inheritancedemo;

import model.Coke;
import model.Pepsi;

public class InheritanceDemo {

    
    /**
     * Assume that we have a few classes for objects
     *  //Object: Drinks, Pepsi, Coke, Cookies, ChocholateCookie
     *
     * Which one is the general/parent class? 
     */
    
    public static void main(String[] args) {
        
        Coke coke = new Coke();//coke is an object
        //data properties from the parent which are inherited
        coke.setId(101);
        coke.setName("Coca cola");
        coke.setQuantity(100);
        coke.setSupplier("ABC Supplier");
        
        //data properties from the child class
        coke.setLabel( "MY Coke" );
        
        //invoke the method/operation
        coke.addNew();
        
        Pepsi pepsi = new Pepsi();
        pepsi.setName("Pepsi");
        pepsi.addNew();
        
    }
    
}
