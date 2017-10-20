import java.text.SimpleDateFormat;
import java.util.Date;

public class E {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY:hh-mm");
        System.out.println(dateFormat.format(new Date()));
    }
}
