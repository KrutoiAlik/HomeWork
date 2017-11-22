import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesToMap {

    String path;

    public PropertiesToMap(String path) {
        this.path = path;
    }

    public Map<String, String> propertiesToMap() throws IOException {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(this.path)) {
            properties.load(fis);

            Map<String, String> map = new HashMap<>();
            for (String name : properties.stringPropertyNames())
                map.put(name, properties.getProperty(name));
            return map;
        }
    }
}
