package drivers;

import common.Library;
import data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static data.TestData.*;


public class Chrome  {

    public static WebDriver driver;

    @Step("Chrome Tarayıcısı ile N11 sistemine giriş yapılır ve giriş yapılabildiği görülür")
    public Chrome openChrome() {
        System.setProperty(path, chromeDriverPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get(n11URL);
        driver.manage().window().maximize();
        Allure.addAttachment(n11URL, "Giriş yapılabildiği görülür");
        new Library().takeScreenshot();
        return this;
    }
}
