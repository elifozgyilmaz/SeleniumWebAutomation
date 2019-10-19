package tests;

import common.BaseTest;
import data.User.User;
import org.testng.annotations.Test;
import pages.SearchPage;
import static data.TestData.*;

public class AutomationN11 extends BaseTest {

    //User
    User n11TestUser = new User(email, pass);

    //Test data
    String aramaData = "Bilgisayar";

    @Test(enabled = true, description = "N11 sistem üzerinde gerekli koşullar yerine getirilerek yapılan işlemler")
    public void testChromeN11() throws InterruptedException {
        testStatus("Chrome N11 Sistem ", "Test Başlangıcı");
        loginChrome(n11TestUser);
        Thread.sleep(6000);
        new SearchPage()
                .aramaAlanıDoldur(aramaData)
                .aramaYapBtn()
                .listeKontrol()
                .digerSayfaGec()
                .listeKontrolPage()
                .UrunDetay()
                .favorilerimMenuOpen(menu)
                .favorilerimUrunKontrol(true)
                .urunSil()
                .favorilerimUrunKontrol(false);
    }
}
