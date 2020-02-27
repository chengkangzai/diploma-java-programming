package turorial5;


public class tutorial5 {

    public static void main(String[] args) {
        double d1 = 30;
        double d2 = 30;
        double d3 = 10;

        if (d1 > d2) {
            System.out.println("Largest number is " + d1);
        } else if (d2 > d3) {
            System.out.println("Largest number is " + d2);
        } else if (d3 > d2) {
            System.out.println("Largest number is " + d3);
        }
        int month = 2;
        switch (month) {
        case 1:
            System.out.println("One");
            break;
        case 2:
            System.out.println("Two");
            break;
        case 3:
            System.out.println("Three");
            break;
        case 4:
            System.out.println("Four");
            break;
        default:
            break;
        }
    }
}