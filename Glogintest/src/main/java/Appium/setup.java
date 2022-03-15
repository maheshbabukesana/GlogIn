package Appium;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class setup {

       private static AndroidDriver driver;

      public static void setCapabilities(){

          DesiredCapabilities caps = new DesiredCapabilities();

          String path = System.getProperty("user.dir")+"/src/main/resources/app/myApp.apk";

          caps.setCapability("platformName", "android");
          caps.setCapability("deviceName", "emulator-5554");
          caps.setCapability("newCommandTimeout", "5000");
          caps.setCapability("app", path);

          try {
              driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
          } catch (MalformedURLException e) {
              e.printStackTrace();
          }
      }



}
