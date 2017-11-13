package ByteAndStringStreams;

import java.io.*;

public class ByteStringStream {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("streams/src/main/java/text.txt"), "UTF-8"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("streams/rc/main/java/ByteAndStringStreams/text.txt"), "UTF-16"));

        while (bufferedReader.ready()) bw.write(bufferedReader.read());

        bufferedReader.close();
        bw.close();
    }

}
