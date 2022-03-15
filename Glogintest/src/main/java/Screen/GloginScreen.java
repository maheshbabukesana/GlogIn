package Screen;


import Contracts.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static Locators.GloginLocators.*;


public class GloginScreen implements Login {

    WebDriver driver = null;

    private Properties properties;
    private String propertyFilePath= "properties/glogin.properties";


    private  static WebElement AcceptCookies,AccediButton,AccediDisplay,EnterMailId,EnterPassword,AvatarDisplay,SearchKeyword;

    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void navigateGooglePage() {
        driver.navigate().to(NavigateUrl);
    }

    public void clickAccedi() {
        AccediButton = driver.findElement(By.xpath(AccediButtonXpath));
        AccediButton.click();
    }

    public boolean isAccedipageDisplayed() {
        AccediDisplay =    driver.findElement(By.id(AccediPageViewId));
        return AccediDisplay.isDisplayed();
    }

    public void enterValidId() {
        try {
            driver.findElement(By.xpath(MailXpath))
                    .sendKeys(EnterMail);
            driver.findElement(By.xpath(AvantiMailXpath)).click();
        }catch (Exception ex) {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(ScreenshotPath);
            //Copy file at destination

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void enterPassword() {
        try{
            driver.findElement(By.xpath(PasswordXpath))
                    .sendKeys(TypePassword);
            driver.findElement(By.xpath(AvantiPasswordXpath)).click();
        }catch (Exception ex){
            TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(ScreenshotPath);

            //Copy file at destination

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean isMailAvatarDisplayed() {
        AvatarDisplay =driver.findElement(By.className(MailAvatarClassId));
        return AvatarDisplay.isDisplayed();
    }


    public void acceptCookies() {
        AcceptCookies = driver.findElement(By.id(AcceptCookiesButtonId));
        AcceptCookies.click();
    }

    public void searchKeyword() {
       SearchKeyword = driver.findElement(By.name(SeachfieldId));
        SearchKeyword.sendKeys(TypeSearchKeyword, Keys.ENTER);
    }

    public void printLinks() {
        List<WebElement> SearchKeywordLinks = driver.findElements(By.tagName(PrnitLinksTagId));
        for (WebElement el : SearchKeywordLinks) {
            System.out.println(el.getText());
        }
    }

    }

