package testNG_Tests.test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_16_Faker_FileExist_Page;
import testNG_Tests.pages.Selenium_TestNG_19_JavaScriptExecuters_Page;
import testNG_Tests.pages.Selenium_TestNG_25_DataProvider_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.DataProviderUtils;
import testNG_Tests.utilities.ReusableMethods;

import java.time.Duration;

import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_25_DataProvider_Test {
    Selenium_TestNG_25_DataProvider_Page page= new Selenium_TestNG_25_DataProvider_Page();

    //3- datayı oluşturmak için {} içine girilip data yazılır
   /* @DataProvider
    public static Object[][] search() {
        return new Object[][]{{"ardahan"}, {"gazyağı"}, {"semaver"}};
    }
*/
    //1- test anatosyonundan sonra (dataProvider = "search") şeklinde bir tanımlama yapılır.
    //2- yazılan "search" üstüne gidilir ve create seçilerek multi dimensional Object array oluşturulur.
    //5- DataProvider classa götürdüğümüz dataprovider metodunu burada okumak için (dataProvider = "search") içine dataProviderClass yazıp
    // yeni açtığım class ismi olan DataProviderUtils.class girerim.
    @Test (dataProvider = "search", dataProviderClass = DataProviderUtils.class)
    public void google(String string) {
        //kullanici https://www.google.com/ sitesin gider
        getDriver().get(ConfigReader.getProperty("google"));

        //kullanıcı dataprovider dan searchbox a data gönderip arama yapar
        page.searchBox.sendKeys(string, Keys.ENTER);
        //4- sendKeys(string) yapacağım yere data tipi ve objesini yazarım.

        ReusableMethods.wait(2);
    }

    //daha önce hazırlanan bir datapriver a test metodunu bağlamak için DataProvider classtaki kullanacağım metot ismini (dataProvider = "search") şeklinde girerim
    @Test(dataProvider = "search", dataProviderClass = DataProviderUtils.class)
    public void n11(String string) {
        //kullanici https://www.n11.com/ sitesin gider
        getDriver().get(ConfigReader.getProperty("n11"));

        //kullanıcı dataprovider dan searchbox a data gönderip arama yapar
        page.n11SearchBox.sendKeys(string, Keys.ENTER);
        //4- sendKeys(string) yapacağım yere data tipi ve objesini yazarım.

        ReusableMethods.wait(2);

    }

    @Test(dataProvider = "login", dataProviderClass = DataProviderUtils.class)
    public void testDataProvider(String string, String string1) {

        //kullanici https://practice.automationtesting.in/my-account/ sitesine gider
        getDriver().get(ConfigReader.getProperty("autoExcercise"));

        //kullanici invalid datayı dataprovider dan alarak gönderir ve giriş yapamadığını görür
        page.email.sendKeys(string);
        page.password.sendKeys(string1);
        page.login.click();
        ReusableMethods.wait(2);

    }
    /*
     @DataProvider
    public static Object[][] login() {
        return new Object[][]{{"hakan", "123423423"}, {"sevcan", "3243DFGdfg"}, {"erbil", "dfg345DF."}};
    }

     */

    @Test(dataProvider = "loginPhp", dataProviderClass = DataProviderUtils.class)
    public void multiDimensionalArray(String firstName, String lastName, String phone, String email, String password ) {
        Selenium_TestNG_16_Faker_FileExist_Page page = new Selenium_TestNG_16_Faker_FileExist_Page();

        //kullanici https://www.phptravels.net/signup sitesine gider
        getDriver().get(ConfigReader.getProperty("php"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        page.firstName.sendKeys(firstName);

        page.lastName.sendKeys(lastName);

        page.country.click();
        page.albania.click();

        page.phone.sendKeys(phone);

        page.userEmail.sendKeys(email);

        page.password.sendKeys(password);

//        getDriver().switchTo().frame(0);
//        page.captcha.click();
//        ReusableMethods.wait(15);
//        getDriver().switchTo().defaultContent();
//
//        page.signUp.click();
    }
    /*
    @DataProvider

    public static Object[][] loginPhp() {
        return new Object[][]{{"hakan", "kara", "5555555555", "hakan@gmial.com","34kdfg" },
                                {"ayşe", "kara", "5555555555", "aaaaa@gmial.com","A34kdfg" },
                                {"hatice", "kara", "5555555555", "hatce@gmial.com","ADFGdfkgdlı9g" }};
    }
    */

    @Test (dataProvider = "excel", dataProviderClass = DataProviderUtils.class)
    public void pullDataFromExcel(String mail, String password) {
        Selenium_TestNG_19_JavaScriptExecuters_Page page=new Selenium_TestNG_19_JavaScriptExecuters_Page();

        //kullanici https://demo.applitools.com/ sitesine gider
        getDriver().get(ConfigReader.getProperty("applitools"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //mail ve password sendkey yapildi
        page.mail.sendKeys(mail);
        page.password.sendKeys(password);

        ReusableMethods.wait(2);

    }

   /* @DataProvider
    public static Object[][] excel() {
        //excel dosya yolunu veririm
        String path= "src/test/resources/userData.xlsx";

        //okunacak excel deki sheet ismini veririm
        String sheet= "positive";

        //ExcelUtils classtan obje oluştur
        ExcelUtils excelUtils=new ExcelUtils(path,sheet);

        //return için excelUtils.getDataArrayWithoutFirstRow() metodu kullanılır.
        return excelUtils.getDataArrayWithoutFirstRow();

    }

    */
}
