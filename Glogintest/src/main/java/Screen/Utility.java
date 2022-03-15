package Screen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties loadProperties(String name) {

        Properties pro = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("properties/"+ name +".properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pro.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }
}
