package common;

import drivers.Chrome;
import org.openqa.selenium.*;

import java.util.logging.Logger;

public class Library extends Chrome {

    protected static final Logger log = Logger.getLogger(Library.class.getName());
    JavascriptExecutor jse = (JavascriptExecutor) driver;


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        byte[] bytes = new byte[]{};
        try {
            bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            log.warning("Error takeScreenshot:" + e.getMessage());
        }
        return bytes;
    }

    @Step("{stepDescription}")
    public void clickJs(WebElement element, String stepDescription) {
        jse.executeScript("arguments[0].click();", element);
    }


    public void clickJs(WebElement element) {
        jse.executeScript("arguments[0].click();", element);
    }

}
