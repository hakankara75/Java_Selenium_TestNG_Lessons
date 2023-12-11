package testNG_Tests.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static testNG_Tests.utilities.Driver.getDriver;

public class ReusableMethods {

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().quit();

    }

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * bu metot ile bir alert gorunene kadar kodlar bekletilir
     * @param saniye yerine beklenicek sure int degeri olarak atanmali
     */
    public static void alertWait(int saniye) {
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * alertten gelen texti dogrulamak icin kullanilir
     * @param str expected metindir
     * @param atr actual metindir
     */
    public static void assertTextContainsAssertTrue(String str, String atr){
        assertTrue(str.contains(atr));
        //assertEquals(str,atr);
    }

    /**
     * alerte text gondermek icin kullanilir
     * @param str alertin icine gonderilecek metindir
     */
    public static void sendKeyToAlert(String str){
        getDriver().switchTo().alert().sendKeys(str);

    }

    /**
     * alerti kabul edecek metot
     */
    public static void acceptAlert(){
        getDriver().switchTo().alert().accept();
    }

    /**
     * alerti reddedecek metot
     */
    public static void dismissAlert(){
        getDriver().switchTo().alert().dismiss();
    }

    /**
     * bu metot ile açık olan pencerelerden indexi verilene geçiş yapılır
     * @param window geçilmek istenen pencerenin indexi
     */
    public static void switchToWindow(int window){
        List<String> allWindowHandles = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(allWindowHandles.get(window));

    }

    /**
     * tum sayfanin screenshoot alinmasini saglar
     */
    public static void tumSayfaScreenShoot(){
        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/screenshot"+ tarih+ ".png";

        TakesScreenshot ts= (TakesScreenshot) getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    /** Bir web elementin screenshoot alinmasini saglar
     * @param element screenshoot alinacak olan elementin locate verilir
     */
    public  static void webElementScreenShoot(WebElement element){

        String tarih= new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "TestOutput/screenshot"+ tarih+ ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void scrollToElementWithActions(WebDriver driver, WebElement element){
        Actions actions= new Actions(driver);
        actions.scrollToElement(element).perform();
    }

    /**
     * herokuapp sitesindeki webtable dan istenen hucredeki datayi dondurur
     * @param satir istenen satirin int cinsinden degeri girilir
     * @param sutun istenen sutun un int cinsinden degeri girilir
     * @return
     */
    public static String giveSpecificCell(int satir, int sutun){
        WebElement specificCell= getDriver().findElement(By.xpath("//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]"));
        String data= specificCell.getText();
        return data;
    }
}
