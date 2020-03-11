
import java.util.ArrayList;
import java.util.Arrays;

public class Excercise {

    public static void main(String[] args) {
        // int[] s = addToArray();
        ArrayList<String> ss = addToArrayList();

        // System.out.println(Arrays.toString(s));
        for (int i = 0; i < ss.size(); i++) {
            System.out.println(ss.get(i));
        }

    }

    public static int[] addToArray() {
        int[] s = new int[11];
        s[1] = 12;
        s[2] = 32;
        s[3] = 34;
        s[4] = 45;
        s[5] = 56;
        s[6] = 67;
        s[7] = 78;
        s[8] = 89;
        s[9] = 90;
        return s;
    }

    public static ArrayList<String> addToArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("12");
        list.add("32");
        list.add("34");
        list.add("45");
        list.add("56");
        list.add("67");
        list.add("78");
        list.add("89");
        list.add("90");

        return list;
    }

    public static void ansAddToArrayList() {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(12, 32, 34, 45, 56, 67, 78, 89, 90));
        list.add(66);
        list.add(88);
        System.out.println(list);
    }

    public static void ansAddToArray() {
        int[] nums ={12, 32, 34, 45, 56, 67, 78, 89, 90};
        nums[9] = 66;
        nums[10] = 88;
    }

}
