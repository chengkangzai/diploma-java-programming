


package samples;


public class MainTester {
    public static void main(String[] args) {
        
        Drinks dk = new Drinks();
        System.out.println(dk.getAll());
        
        Coke coke = new Coke();
        System.out.println( coke.getAll());
        
        TehTarik teh = new TehTarik();
        System.out.println(teh.getAll());
    }
}
