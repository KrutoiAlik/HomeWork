import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CrazyLogger {

    File file = new File("strings/src/main/java/log.txt");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY:hh-mm");
    ArrayList<StringBuilder> log = new ArrayList<>();

    void log(String message){
        log.add(new StringBuilder(String.format("%s%n", dateFormat.format(new Date()) + " - " + message)));
        if (log.size() > 9) try {
            writeInFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    Object[] search(String s) {
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (StringBuilder sb : log) if (sb.toString().contains(s)) stringBuilders.add(sb);
        return stringBuilders.toArray();
    }

    void writeInFile() throws IOException {
        FileWriter fw = new FileWriter(file);
        if (!file.exists()) file.createNewFile();
        for (StringBuilder s : log) fw.write(s.toString());
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        CrazyLogger cl = new CrazyLogger();
        cl.log("Hello");
        cl.log("Hell");
        cl.log("Helo");
        cl.log("Helo");
        cl.log("Hllo");
        cl.writeInFile();
    }
}
