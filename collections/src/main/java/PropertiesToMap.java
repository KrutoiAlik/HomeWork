import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesToMap {

    @SneakyThrows
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream("collections/src/main/resources/e.properties")) {
            properties.load(fis);
        }
        System.out.println(propertiesToMap(properties).toString());
    }

    static Map<String, String> propertiesToMap(Properties properties) {
        Map<String, String> map = new HashMap<>();
        for (String name : properties.stringPropertyNames())
            map.put(name, properties.getProperty(name));
        return map;
    }
}
