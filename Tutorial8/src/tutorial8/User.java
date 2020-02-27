package tutorial8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class User {
//get All data from the file

    public static final String FILENAME = "users.txt";

    /**
     *
     * @return
     */
    public static String[] getAll() {
        List<String> data = null;
        try {
            data = Files.readAllLines(Paths.get(FILENAME));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //populate the data from list into String[]
        String[] container = new String[data.size()];
        container = data.toArray(container);
        return container;
    }

}
