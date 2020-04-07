
public class Find {

    public Find() {
        // TODO Auto-generated constructor stub
    }
    public int[] numlst = {11, 22, 33, 44, 55, 66, 77, 88, 99};

    /**
     *
     * @return the sum of all elements of array object, numlst
     */
    int sum() {
        int total = 0;

        for (int i = 0; i < numlst.length; i++) {
            total = +numlst[i];
        }
        return total;
    }

    /**
     *
     * @return the average of all elements of array object, numlst
     */
    int avg() {
        int total = 0;
        int avg = 0 ;
        for (int i = 0; i < numlst.length; i++) {
            total += numlst[i];
        }
        avg = total / numlst.length;
        return avg;
    }

    public static void main(String[] args) {
        System.out.println(new Find().sum());
        System.out.println(new Find().avg());
    }

}
