package MyLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Logger
 */
public class MyLogger {
    protected static final String LOGGERFILENAME = "log.txt";
    protected static final Path LOGGERPATH = Paths.get(LOGGERFILENAME);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    protected final String TIME = LocalDateTime.now().atZone(ZoneId.systemDefault()).format(formatter);
    protected int status = 0;
    protected String body;
    protected String head;
    protected String line;

    public void setHead(String head) {
        this.head = "[" + head + "]";
    }

    public String getHead() {
        return head;
    }

    public void addHeadIndent(int num) {
        if (num == 1) {
            head += "\t";
        } else if (num == 2) {
            head += "\t\t";
        }
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    protected void combineLine() {
        line = head + " - " + "[" + TIME + "]" + " - " + body + "\n";
    }

    public void log() {
        combineLine();
        try {
            Files.write(LOGGERPATH, line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            status = 1;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}