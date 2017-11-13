package ByteStream;

import Keys.KeyWords;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamsTask {

    static KeyWords keyWords;

    public static void main(String[] args) throws IOException {
        keyWords = new KeyWords();
        keyWords.checkKeyWords(readWordsFromJavaFileByByteStream("streams/src/main/java/ByteStream/ByteStreamsTask.java"));
        keyWords.writeToAnotherFile("streams/src/main/java/ByteStream/result.txt");
    }

    static String[] readWordsFromJavaFileByByteStream(String s) throws IOException {
        FileInputStream stream = new FileInputStream(s);
        byte[] text = new byte[stream.available()];
        stream.read(text);
        return new String(text).split("\\s*\\W+");
    }
}
