import java.util.Scanner;

/**
 * Tutorial2
 */
public class Tutorial2 {
    // Write program that convert a fahrenheit to celsius
    // Prompt user to input fahrenheit and display the celsius
    static Scanner scan = new Scanner(System.in);

    public static void main(final String[] args) {
        // Prompt the user for the fahrenheit
        System.out.println("Type a Fahrenheit: ");
        int f = scan.nextInt();

        System.out.println("Getting i for: " + f);
        // Compute Celsius
        double cel= f * -17.22;

        // Display Celsius
        System.out.printf("Celsius for "+f+" is :"+cel);

    }
}