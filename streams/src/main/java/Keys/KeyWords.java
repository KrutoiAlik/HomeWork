package Keys;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyWords {

    public TreeMap<String, Integer> list = new TreeMap<>();

    public KeyWords() throws IOException {
        split(read());
    }

    void split(byte[] text) {
        String[] splitKeyWords = new String(text).split("\\s*\\W+");
        for (String splitKeyWord : splitKeyWords) list.put(splitKeyWord, 0);
    }

    byte[] read() throws IOException {
        try (FileInputStream fis = new FileInputStream("streams/src/main/java/Keys/keywords.txt")) {
            byte[] text = new byte[fis.available()]; fis.read(text);
            return text;
        }
    }

    public void checkKeyWords(String[] strings) {
        for (Map.Entry<String, Integer> entry : this.list.entrySet())
            for (String s : strings) if (s.equals(entry.getKey())) entry.setValue(entry.getValue() + 1);
    }

    public void writeToAnotherFile(String s) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(s)) {
            for (Map.Entry<String, Integer> entry : this.list.entrySet())
                if (entry.getValue() != 0) fos.write((entry.getKey() + " " + entry.getValue() + "\r\n").getBytes());
        }
    }
}