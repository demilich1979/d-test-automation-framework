package diaceutics.selenium.utilities;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {

    @SneakyThrows
    public static String getProperty(String key, String fileName) {
        Properties property = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(ResourceUtil.getResourcePath(fileName))) {
            property.load(fileInputStream);
        }
        return property.getProperty(key);
    }

}
