package common;

import data.User.User;
import pages.Login.LoginPage;

public class BaseTest extends Library {


    @Step("Login")
    public void loginChrome(User user) {
    openChrome();
    new LoginPage()
    .login(user.getEmail(), user.getPassword());
    }

    @Step("Test  : {testid} {status} ")
    public void testStatus(String testid, String status) {
    }

}
