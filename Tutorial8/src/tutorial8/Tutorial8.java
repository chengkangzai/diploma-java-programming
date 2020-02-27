package tutorial8;

public class Tutorial8 {

    public static void main(String[] args) {
        String[] usrList = User.getAll();

        for (int i = 1; i < usrList.length; i++) {
            System.out.println(usrList[i]);

            String[] split = usrList[i].split("\\|");
            for (int j = 0; j < split.length; j++) {
                System.out.println(split[j]);

            }

        }

    }

}
