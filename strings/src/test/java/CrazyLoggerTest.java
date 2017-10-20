import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

class CrazyLoggerTest {

    CrazyLogger cl = new CrazyLogger();
    SimpleDateFormat sdf = cl.dateFormat;

    @Test
    void log() {
        cl.log("");
        assertEquals(String.format("%s%n", sdf.format(new Date()) + " - " + "").toString(), cl.log.get(0).toString() );
    }

    @Test
    void search() {
        cl.log("Test");
        cl.log("Hello");
        cl.log("Search");
        cl.log("Logging");

        System.out.println(Arrays.toString(cl.search("e")));
    }

    @Test
    void writeInFile() {
    }

}