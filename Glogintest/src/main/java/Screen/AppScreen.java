package Screen;

import Contracts.MobileApp;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AppScreen  {

    private static AndroidDriver driver;

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

    public static void stopDriver() {

        driver.quit();
    }

    public static AndroidDriver startDriver(DesiredCapabilities caps) {

        AndroidDriver driver = null;

        try {
             driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

}
