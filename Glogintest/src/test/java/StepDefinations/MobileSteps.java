package StepDefinations;

import Screen.AppScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class MobileSteps {

    private AndroidDriver driver;
    private Properties prop;

    @Given("open App")
    public void open_app() {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("newCommandTimeout", "5000");
        caps.setCapability("app",  System.getProperty("user.dir")+"/src/main/resources/app/myApp.apk");

        driver = AppScreen.startDriver(caps);
        prop = AppScreen.loadProperties("app");

    }

    @When("Enter username")
    public void enter_username() {
       driver.findElement(By.id(prop.getProperty("usernameId"))).sendKeys("admin");
    }
    @When("Enter password")
    public void enter_password() {
        driver.findElement(By.id(prop.getProperty("pswId"))).sendKeys("admin");
    }
    @Then("press Login button")
    public void press_login_button() {
        driver.findElement(By.id(prop.getProperty("loginButtonId")) ).click();
    }

    @And("press add the button")
    public void press_add_the_button() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id(prop.getProperty("aggiungiButtonId"))).click();
    }

    @When("Enter  new username")
    public void enter_new_username() {
        driver.findElement(By.id(prop.getProperty("newUserId"))).sendKeys("Mahesh");
    }
    @Then("press the add new user button")
    public void press_the_add_new_user_button() {
        driver.findElement(By.id(prop.getProperty("addUserPopup"))).click();
    }



}
