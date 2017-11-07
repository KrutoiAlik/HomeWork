import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParserForTask03 {

    static Pattern p = Pattern.compile("<img[^>]* src=\\\"([^\\\"]*)\\\"[^>]*>");
    static boolean isMoreThanOne;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("strings/src/main/resources/Java.SE.03.Information handling_task_attachment.html"), "cp1251"));
        for (String s : getImgRef(bufferedReader)) System.out.println(s);
        System.out.println("\r\nПоследовательные ссылки на изображение: " + isMoreThanOne);
    }

    static ArrayList<String> getImgRef(BufferedReader bufferedReader) throws IOException {
        ArrayList<String> regExps = new ArrayList<>();
        int check = 0;
        while (bufferedReader.ready()) {
            String s = bufferedReader.readLine();
            Matcher m = p.matcher(s);
            if (m.find()) {
                check++;
                if(check > 1)
                    isMoreThanOne = true;
                regExps.add(s.substring(m.start(), m.end()));
            } else
                check = 0;
        }
        return regExps;
    }
}