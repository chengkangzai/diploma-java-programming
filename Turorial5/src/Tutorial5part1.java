import java.util.Scanner;

/**
 * Tutorial5part1
 */
public class Tutorial5part1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double entryFee;
        int age;
        System.out.println("Can i have your age please?");
        age = scan.nextInt();
        if (age <= 5) {
            entryFee=0;
        }else if(age >= 65){
            entryFee=1.5;
        }else{
            entryFee=2.5;
        }
        System.out.println("Your Fee is " + entryFee);
        scan.close();
    }
}