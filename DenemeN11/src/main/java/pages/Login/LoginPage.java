package pages.Login;

import common.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {


    @Step("\"{username}\" kullanıcı ile giriş yap")
    public LoginPage login(String email, String password) {
        n11GirisYap();
        driver.findElement(By.cssSelector("[id='loginForm'] input[id='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("[id='loginForm'] input[id='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("[id='loginForm'] div[id='loginButton']"));
        clickJs(driver.findElement(By.cssSelector("[id='loginForm'] div[id='loginButton']")));
        return this;
    }

    @Step("n11 ana ekranında giriş yap butonu tıklanır")
    public LoginPage n11GirisYap() {
        driver.findElement(By.cssSelector("[class='loginStatus clearfix'] a[class='btnSignIn']")).click();
        return this;
    }
}
