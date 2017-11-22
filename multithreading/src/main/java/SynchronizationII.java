import java.io.IOException;
import java.util.Map;

public class SynchronizationII {

    Map<String, String> map;

    Map<String, String> getInstance(String s) throws IOException {
        if (map == null)
            synchronized (SynchronizationII.class) {
                if (map == null)
                    map = new PropertiesToMap(s).propertiesToMap();
            }
        return map;
    }
}