package commonLibs;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties props;

    static {
        try {
            props = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(props.getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(props.getProperty(key));
    }

}
