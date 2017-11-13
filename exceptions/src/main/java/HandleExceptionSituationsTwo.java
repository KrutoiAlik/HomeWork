import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class HandleExceptionSituationsTwo {

    final static Logger log = Logger.getLogger(HandleExceptionSituations.class);

    static Map<String, String> propertiesToMap(File file) {

        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                log.fatal(e.getMessage(), e);
            }

        Map<String, String> map = new HashMap<>();
        Properties properties = new Properties();

        try (FileInputStream stream = new FileInputStream(file)) {
            properties.load(stream);
        } catch (IOException e) {
            log.fatal(e.getMessage());
        }

        for (String name : properties.stringPropertyNames()) {
            if (name.equals(""))
                log.error(properties.getProperty(name) + " has an empty key");
            map.put(name, properties.getProperty(name));
        }
        return map;
    }
}
