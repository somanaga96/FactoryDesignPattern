package utils;

import java.io.File;
import java.nio.file.Files;
import java.util.Properties;

public class Utils {
    public static String getPropValue(Properties properties, String key) {
        return properties.getProperty(key);
    }

    public static Properties getProps(final String FILE_PATH, final String FILE_NAME) {
        Properties properties = new Properties();
        try {
            File file = new File(FILE_PATH, FILE_NAME + ".properties");
            System.out.println("Properties path :" + FILE_PATH + FILE_NAME);
            properties.load(Files.newInputStream(file.toPath()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return properties;
    }
}
