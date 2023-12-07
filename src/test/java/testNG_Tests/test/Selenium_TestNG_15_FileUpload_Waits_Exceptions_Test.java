package testNG_Tests.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_15_FileUpload_Waits_Exceptions_Page;
import testNG_Tests.utilities.ConfigReader;

import java.time.Duration;

import static testNG_Tests.utilities.Driver.*;

public class Selenium_TestNG_15_FileUpload_Waits_Exceptions_Test {

    Selenium_TestNG_15_FileUpload_Waits_Exceptions_Page page=new Selenium_TestNG_15_FileUpload_Waits_Exceptions_Page();

    @Test
    public void fileUpload() {
        // kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


try {
    page.dosyaSec.click();
}catch (Exception e) {
    page.dosyaSec.sendKeys(System.getProperty("user.home", "/Desktop/deneme.docx"));


}
    }

    @Test
    public void waits() {
        /*
        Thread.sleep(2000); Java'dan gelir , butun kodlari durdurur. Selenium-Java
        impicitlyWait(); sayfadaki butun elementleri beklemeye yarar
        explicitlyWait(); sayfadaki locate verilen BİR elementi bekleme yapar
         */

        //kullanici "https://demoqa.com/dynamic-properties" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaDynamic"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); //sureyi az tuttugum icin asagidaki hatayi aldim

        boolean isTrue= page.visibleAfter.isEnabled(); //NoSuchElementException aldim.
        closeDriver();
    }

    @Test
    public void wait2() { //explicitlyWait
        //kullanici "https://demoqa.com/dynamic-properties" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaDynamic"));

        //TimeoutException alirim asagidaki koddan
        WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfterXXXXX"))); //yalnis locate verdim.
        closeDriver();
    }

    WebDriver driver;
    @Test
    public void nullPointerException() { //
        driver.get(ConfigReader.getProperty("demoqaDynamic"));
        closeDriver();
    }

    @Test
    public void timeOut() { //TimeoutException
        //kullanici https://www.obilet.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("obilet"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //cerezleri kabul eder
        WebDriverWait wait= new WebDriverWait(getDriver(), Duration.ofSeconds(7));

        //gorunur olana kadar bekleme komutu
        wait.until(ExpectedConditions.visibilityOf(page.accept)); //yalnis locate verdim.
        closeDriver();

    }

    @Test
    public void staleElement() {//StaleElementReferenceException
        //kullanici https://www.obilet.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("obilet"));

        //cerezleri kabul eder
        WebElement accept= getDriver().findElement(By.id("accept"));

        //refresh yaptim
        getDriver().navigate().refresh();
        accept.click();

        closeDriver();

    }
}
