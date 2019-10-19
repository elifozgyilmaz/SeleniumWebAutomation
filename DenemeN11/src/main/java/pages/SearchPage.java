package pages;

import common.Library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class SearchPage extends Library {

    @Step(" Arama alanÄ±nda {arama} doldurulur")
    public SearchPage aramaAlanÄ±Doldur(String arama) {
        driver.findElement(By.cssSelector("[class='container'] [class='logo']")).click();
        WebElement search = driver.findElement(By.id("searchData"));
        search.sendKeys(arama);
        return this;
    }

    @Step("Arama Yap butonu tÄ±klanÄ±r")
    public SearchPage aramaYapBtn() {
        clickJs(driver.findElement(By.cssSelector("span[class$='iconSearch']")));
        return this;
    }

    @Step("Aranan sonuÃ§larÄ±n listelendiÄŸi  gÃ¶rÃ¼lÃ¼r")
    public SearchPage listeKontrol() {
        String ekran = driver.findElement(By.cssSelector("[id='breadCrumb'] a span")).getText();
        Allure.addAttachment(ekran + "ListelendiÄŸi gÃ¶rÃ¼lÃ¼r", "");
        takeScreenshot();
        return this;
    }

    @Step("Aranan sonuÃ§larÄ±n listelendiÄŸi  gÃ¶rÃ¼lÃ¼r")
    public SearchPage listeKontrolPage() {
        String ekran = driver.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a.active")).getText();
        Allure.addAttachment(ekran + " SayfanÄ±n AÃ§Ä±ldÄ±ÄŸÄ± gÃ¶rÃ¼lÃ¼r", "");
        takeScreenshot();
        return this;
    }

    @Step("Listelenme alanÄ±nda 2 sayfaya geÃ§iÅŸ yapÄ±lÄ±r")
    public SearchPage digerSayfaGec() {
        clickJs(driver.findElement(By.cssSelector("#contentListing > div > div > div.productArea > div.pagination > a:nth-child(2)")));
        return this;
    }


    @Step("Listeleme alanında ürünün üzerine tıklanır")
    public SearchPage UrunDetay() {
        clickJs(driver.findElement(By.cssSelector("#p-370372613 > div.proDetail > span")));
        return this;
    }
    
    
    @Step("Ãœst menÃ¼de hesabÄ±m iÅŸlemlerinde {menu} ekranÄ±na giriÅŸ yapÄ±lÄ±r")
    public SearchPage SepetimOpen(String menu) throws InterruptedException {
        WebElement sepet = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a"));
        Actions act = new Actions(driver);
        act.moveToElement(favori).build().perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText(menu)).click();
        return this;
    }
}
