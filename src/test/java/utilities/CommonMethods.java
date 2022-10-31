package utilities;

/*
Sık kullanılan methodlar okunulabilirliğin artırılması ve herhangi bir değişiklik yapılabilmesine esneklik sağlayabilmesi
için bu sınıf içerisinde tanımlanmıştır.
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class CommonMethods {


    /* Bu metot ile sayfanin ekran görüntüsünü alınır */
    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    /* Bu metot ile sayfanin webelementinin ekran görüntüsü alınır */
    public static String getScreenshotWebElement(String name, WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return wElementSS;
    }

    /* Bu metot ile mouse webelementinin üzerinde bekler */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /* Bu metot ile sayfalar arası geçiş yapılır */
    public static void switchWindow(int i) {
        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(i));
        CommonMethods.waitFor(3);
    }

    //İşlemler devam etsin diye kodları bekletmek icin kullanilir
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* Web elementin görünür olmasını bekler */
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /* Web elementin görünür olmasını bekler */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /* Web elementin görünür olmasını bekler */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* Web elementin görünür olmasını bekler */
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    /* Bu metot ile mouse ve klavye kullanılır */
    static Actions actions;

    public static Actions getActions() {
        return actions = new Actions(Driver.getDriver());
    }

    /* Bu metot ile sayfanin,webelementinin olduğu yere gidip tıklanması için kullanılır  */
    public static void jsScrollClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
            waitFor(1);
        }
    }

    /* Bu metot ile webelementinin tıklanmasını sağlar  */
    public static void jsclick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }


    /*  Bu metot ile doğru web elemetinin görünürlüğü doğrulanır  */
    public static String dogrulamaMethodu(WebElement actual) {
        String sonuc = "";
        try {
            assertTrue(actual.isDisplayed());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return sonuc;
    }

    /* Bu metot ile webelemetine tiklanmasi sağlanir */
    public static void webElementClick(WebElement element) {
        CommonMethods.waitFor(5);
        CommonMethods.jsScrollClick(element);
        CommonMethods.waitFor(3);

    }


}
