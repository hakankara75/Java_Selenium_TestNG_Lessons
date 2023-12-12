package testNG_Tests.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_19_JavaScriptExecuters_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.Driver;
import testNG_Tests.utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;
import static testNG_Tests.utilities.ReusableMethods.*;

public class Selenium_TestNG_19_JavaScriptExecuters_Test {

    Selenium_TestNG_19_JavaScriptExecuters_Page page= new Selenium_TestNG_19_JavaScriptExecuters_Page();
    JavascriptExecutor javascriptExecutor= (JavascriptExecutor) getDriver();

    @Test
    public void javaScript() {


        //kullanici https://www.opencart.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("open"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //register butonuna javascript ile click yapildi
        javascriptExecutor.executeScript("arguments[0].click();", page.register);
        closeDriver();
    }

    @Test
    public void sendKey() {
        //kullanici https://demo.applitools.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("applitools"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //mail ve password sendkey yapildi
        javascriptExecutor.executeScript("arguments[0].value= 'hakan';", page.mail);
        javascriptExecutor.executeScript("arguments[0].value= 'hakan123';", page.password);
        javascriptExecutor.executeScript("arguments[0].click();", page.sign);
        ReusableMethods.wait(2);
        closeDriver();
    }

    @Test
    public void scroll() {
        /*
https://ibb.istanbul/ sitesine git
Yayınlar linki gorunene kadar scroll yap, ekran goruntusu al
153 çözüm merkezi gorunene kadar scroll yap, ekran goruntusu al
sayfayi en alta kaydir
sayfayi en uste kaydir


 */
        // https://ibb.istanbul/ sitesine git
        getDriver().get(ConfigReader.getProperty("ibb"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Yayınlar linki gorunene kadar scroll yap, ekran goruntusu al
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", page.yayinlar);
        tumSayfaResmi("yayinlar");
        ReusableMethods.wait(2);


        //153 çözüm merkezi gorunene kadar scroll yap, ekran goruntusu al
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", page.yuzelliuc);
        tumSayfaResmi("yuzelliuc");
        ReusableMethods.wait(2);

        //sayfayi en alta kaydir
        scrollEndByJavascript();
        ReusableMethods.wait(2);

        //sayfayi en uste kaydir
        scrollTopByJavascript();
        ReusableMethods.wait(2);

        closeDriver();

    }

    @Test
    public void type() {

        /*
https://www.ankara.bel.tr/ sitesine git
arama cubuguna "trafik durumu" textini gonderip arama yap
 */
        // https://www.ankara.bel.tr/ sitesine git
        getDriver().get(ConfigReader.getProperty("abb"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //arama cubuguna "trafik durumu" textini gonderip arama yap
        page.aramaButonu.click();
        sendKeyByJavascript("trafik durumu", page.aramaKutusu);

        page.aramaButonu2.click();

    }


    @Test
    public void getValue() {

        /*
kullanici http://www.automationpractice.pl/index.php sitesine gider
Altta newsletter kismindaki mail girme kutusunun degerini alir

 */

        //kullanici http://www.automationpractice.pl/index.php sitesine gider
        getDriver().get(ConfigReader.getProperty("auto"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Altta newsletter kismindaki mail girme kutusunun degerini alir
        String idText= "newsletter-input";
        //String attribute= "hakan";
        scrollToElementWithActions(getDriver(),page.newsletter);
        //page.newsletter.sendKeys(attribute);
        String getAttribute= javascriptExecutor.executeScript("return document.getElementById('"+idText+"')."+"value").toString();
        System.out.println("getAttribute = " + getAttribute);
        ReusableMethods.wait(2);
        closeDriver();

    }

    /**
     * bu metot ile javascript kullanarak bir elementin degeri okunur ve string olarak bize doner
     * @param idText bunun yerine degeri okunacak elementin id degeri text olarak verilir
     * @param value yerine okunacak attribute verilir
     * @return
     */
    public static String getValueByJavascript(String idText, String value){
        JavascriptExecutor javascriptExecutor= (JavascriptExecutor) getDriver();
        String getAttribute= javascriptExecutor.executeScript("return document.getElementById('"+idText+"')."+value).toString();
       return getAttribute;
    }

}
