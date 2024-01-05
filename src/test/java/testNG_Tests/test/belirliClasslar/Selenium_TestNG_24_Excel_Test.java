package testNG_Tests.test.belirliClasslar;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_24_Excel_Pages;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.ExcelUtils;
import testNG_Tests.utilities.ReusableMethods;

import java.io.IOException;
import java.time.Duration;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_24_Excel_Test {
    Selenium_TestNG_24_Excel_Pages page=new Selenium_TestNG_24_Excel_Pages();


    @Test (groups = "SelectedTests")
    public void positive() {
        getDriver().manage().deleteAllCookies();

        //1- Data okunacak dosyanın yolu vereceğiz
        String path="src/test/resources/userData.xlsx";

        //2- Data okunacak dosyadaki sheet name vereceğiz
        String sheetNamePositive= "positive";

        //kullanici https://practice.automationtesting.in/my-account/ sitesine gider
        getDriver().get(ConfigReader.getProperty("autoExcercise"));

        //3- ExcelUtils classtan metotları kullanabilmek için obje oluştururuz
        ExcelUtils excelUtils=new ExcelUtils(path,sheetNamePositive);

        for (int i = 1; i <=excelUtils.rowCount(); i++) {
            String email= excelUtils.getCellData(i, 0);
            String password= excelUtils.getCellData(i, 1);

            page.email.sendKeys(email);
            page.password.sendKeys(password);
            ReusableMethods.wait(2);
            getDriver().get(ConfigReader.getProperty("autoExcercise"));


        }

        closeDriver();

    }

    @Test
    public void negative() {
        getDriver().manage().deleteAllCookies();

        //1- Data okunacak dosyanın yolu vereceğiz
        String path="src/test/resources/userData.xlsx";

        //2- Data okunacak dosyadaki sheet name vereceğiz
        String sheetNamePositive= "negative";

        //kullanici https://practice.automationtesting.in/my-account/ sitesine gider
        getDriver().get(ConfigReader.getProperty("autoExcercise"));

        //3- ExcelUtils classtan metotları kullanabilmek için obje oluştururuz
        ExcelUtils excelUtils=new ExcelUtils(path,sheetNamePositive);

        for (int i = 1; i <=excelUtils.rowCount(); i++) {
            String email= excelUtils.getCellData(i, 0);
            String password= excelUtils.getCellData(i, 1);

            page.email.sendKeys(email);
            page.password.sendKeys(password);
            ReusableMethods.wait(2);
            getDriver().get(ConfigReader.getProperty("autoExcercise"));


        }

        closeDriver();

    }

    @Test
    public void writeToExcel() throws IOException {
        //1- ExcelUtils classtan metotları kullanabilmek için obje oluştururuz
        ExcelUtils excelUtils = null;

        //2- yazdırılacak dosyanın yolunu belirlerim
        String path="src/test/resources/Book.xlsx";

        //3- yazdırılacak sheet name belirle
        String sheetNameNegative="sayfa1";

        //kullanici https://www.kitapyurdu.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("kitapYurdu"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //kullanici cok satan kitaplar menusu ustune gelir
        ReusableMethods.moveToElement(page.cokSatanKitaplar);
        ReusableMethods.wait(2);

        //kullanıcı çok satan edebiyat kitapları linkine klik yapar
        page.cokSatanEdebiyatKitaplar.click();

        //excelutils objesine dosyayolu ve sayfa adi verilir
        ExcelUtils.excellSayfaAdiVerme(path,sheetNameNegative);

        //kullanici yayinevlerini sirayla açar

        int yayinevi= getDriver().findElements(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])")).size();
        System.out.println("yayinevi = " + yayinevi);

        for (int i = 1; i < yayinevi; i++) {
            //yayınevlerini sıra ile clikleme yapar
            getDriver().findElement(By.xpath("(//div[@id='faceted-search-group-2']//div[@class='row'])["+i+"]")).click();


            //yayınevinin ismi alınıp excele sayfa ismi olarak verilecek
            String sayfaAdi=  getDriver().findElement(By.id("publisher-filters-div")).findElement(By.className("facet-name")).getText();
            System.out.println("sayfaAdi = " + sayfaAdi);
            ExcelUtils.excellSayfaAdiVerme(path, sayfaAdi);

            //açılan sayfadan kitap isimlerini alır

            for (int j = 0; j < page.kitapIsimleri.size(); j++) {
              try {
                  excelUtils = new ExcelUtils(path, sayfaAdi);
                  excelUtils.setCellData(page.kitapIsimleri.get(j).getText(),j, 0);
              }catch (Exception e) {
                  e.printStackTrace();
              }

            }
            getDriver().navigate().back();


        }

        closeDriver();
    }
}
