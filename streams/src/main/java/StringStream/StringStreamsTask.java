package StringStream;

import Keys.KeyWords;

import java.io.FileReader;
import java.io.IOException;

public class StringStreamsTask {

    static KeyWords keyWords;

    public static void main(String[] args) throws IOException {
        keyWords = new KeyWords();
        keyWords.checkKeyWords(readWordsFromJavaFileByStringStream("streams/src/main/java/StringStream/StringStreamsTask.java"));
        keyWords.writeToAnotherFile("streams/src/main/java/StringStream/result.txt");
    }

    static String[] readWordsFromJavaFileByStringStream(String s) throws IOException {
        FileReader fw = new FileReader(s);
        StringBuilder string = new StringBuilder("");
        while (fw.ready()) string.append((char) fw.read());
        return string.toString().split("\\s*\\W+");
    }
}
