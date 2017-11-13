import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HandleExceptionSituations {

    Logger log = Logger.getLogger(HandleExceptionSituations.class);

    void readTextFile(File file) {
        if (file != null)
            if (file.exists())
                try {
                    Files.lines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8).forEach(s -> System.out.println(s));
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
    }

    void writeToTxtFile(String s, File file, boolean fromEnd) {

        createFileIfHeWasNot(file);

        try (FileWriter outputStream = new FileWriter(file, fromEnd)) {
            outputStream.write(s + "\n");
        } catch (IOException e) {
            log.error(e.getMessage(), new RuntimeException(e));
        }
    }

    void viewFiles(String root) {
        try {
            for (File file : new File(root).listFiles())
                if (!file.isDirectory()) System.out.println(file.getName());
        } catch (Exception e) {
            log.fatal(e.getMessage(), new RuntimeException(e));
        }
    }

    void viewDirectories(String root) {
        try {
            for (File file : new File(root).listFiles())
                if (file.isDirectory()) System.out.println(file.getName());
        } catch (Exception e) {
            log.fatal(e.getMessage(), new RuntimeException(e));
        }
    }

    void createFileIfHeWasNot(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error(e.getMessage(), new RuntimeException(e));
        }
    }

    void removeFile(File file) {
        if (file == null){
            log.fatal("removeFile", new NullPointerException());
            return;
        }
        if (!file.delete())
            log.error("File not found");
    }
}
