package project7;

//nio = new File IO 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project7 {

    public static void main(final String[] args) {
        // demoCode();
        // Get Current time
        final LocalDateTime date = LocalDateTime.now();
        final String now = date.toString() + System.lineSeparator();
        // String now = date.toString() + "\n";

        // write to file
        final String fileName = "now.txt";

        // Aware ! Path !== Paths
        final Path path = Paths.get(fileName);
        try {
            Files.write(path, now.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (final IOException e) {
            System.out.println(e);
        }
        System.out.println("Done !");

        System.out.println("Loading data from files ");

        try {
            Thread.sleep(3000);
            final List<String> container = Files.readAllLines(path);
            container.forEach((line) -> {
                System.out.println(line);
            });
            System.out.println("Smart Ass");
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    /*
     * Demo: Write Todays timestamp to the file File name : now.txt
     */
    static void demoCode() {
        // API: LocalDateTime
        // LocalDateTime now = LocalDateTime.now();
        // System.out.println(now.toString());
        for (int i = 0; i < 10; i++) {
            try {
                // Thread is Process
                Thread.sleep(2000);
                System.out.println(LocalDateTime.now().toString());
            } catch (final InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Done");
    }
}
