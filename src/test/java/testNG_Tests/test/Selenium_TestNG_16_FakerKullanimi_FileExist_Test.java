package testNG_Tests.test;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_16_Faker_FileExist_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.Driver;
import testNG_Tests.utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;


public class Selenium_TestNG_16_FakerKullanimi_FileExist_Test {

    Selenium_TestNG_16_Faker_FileExist_Page page=new Selenium_TestNG_16_Faker_FileExist_Page();


    @Test(priority = -1)
    public void faker() {
        Faker faker=new Faker();

        getDriver().get(ConfigReader.getProperty("phpTravels"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String firstName= faker.name().firstName();
        page.firstName.sendKeys(firstName);

        String lastName= faker.name().lastName();
        page.lastName.sendKeys(lastName);

        page.country.click();
        page.albania.click();

        String phone= faker.phoneNumber().phoneNumber(); //faker.numerify("###-###-####") istenen formata gore sekillendirir
        page.phone.sendKeys(phone);

        String email= faker.internet().emailAddress();
        page.userEmail.sendKeys(email);

        String password= faker.internet().password();
        page.password.sendKeys(password);

        getDriver().switchTo().frame(0);
        page.reCaptcha.click();
        ReusableMethods.wait(15);
        getDriver().switchTo().defaultContent();
        //css tag (.) ve id value
       // WebElement signup= getDriver().findElement(By.cssSelector("button#submitBTN"));
        page.signUpButton.click();

        Driver.closeDriver();

    }
    @Test
    public void kocTas() {

        Faker faker = new Faker();


        getDriver().get(ConfigReader.getProperty("koctas"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String firstName= faker.name().firstName();
        page.ad.sendKeys(firstName);

        String lastName= faker.name().lastName();
        page.soyad.sendKeys(lastName);

        String eposta= faker.internet().emailAddress();
        page.userEmail.sendKeys(eposta);

        String fake= faker.numerify("(5##) ### ## ##");
        System.out.println("fake = " + fake);
        sendAttributeJS(page.cepTelefonu,fake);
        //page.cepTelefonu.sendKeys("(541) 552 47 89");

        String sifre= faker.internet().password();
        page.sifre.sendKeys(sifre);
        ReusableMethods.wait(5);
        closeDriver();
    }

    @Test(priority = -2)
    public void existFile() {
        boolean isExist= Files.exists(Paths.get("C:\\Users\\Hakan\\Desktop\\deneme.docx")); //hard code

// kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        String userHome= System.getProperty("user.home");
        System.out.println("userHome = " + userHome); //C:\Users\Hakan

        boolean yol=Files.exists(Paths.get("C:\\deneme.docx"));

        //"C:\Users\Hakan\Desktop\deneme.docx"
        boolean path= Files.exists(Paths.get(userHome+"/Desktop/deneme.docx"));
        System.out.println("path = " + path);
        if (path==true){
            try {
                page.dosyaSec.click();
            }catch (Exception e) {
                page.dosyaSec.sendKeys(System.getProperty("user.home")+ "/Desktop/deneme.docx");


            }
        }
        ReusableMethods.wait(5);

        closeDriver();

    }
    @Test(priority = -2)
    public void existFile2() {
        /*
        testNGTest altinda resources olusturduk. deneme.docx icine ekledik.
         */
        String userDirectory= System.getProperty("user.dir"); //ayni projede calisan ekibin bir dosyayi dogrulamasi icin hepsinde ayni proje yolu verir
        //C:\Users\Hakan\IdeaProjects\Java_Selenium_TestNG_Lessons
        System.out.println("userDir = " + userDirectory);

        //1.yol
        String userDir= System.getProperty("user.dir");
        System.out.println("userDir = " + userDir);
        boolean yol= Files.exists(Paths.get("C:\\Users\\Hakan\\IdeaProjects\\Java_Selenium_TestNG_Lessons\\src\\test\\java\\testNGTests\\resources\\deneme.docx"));
        System.out.println("yol = " + yol);

        //2.yol
        String str= String.valueOf(Paths.get(userDir + "\\src\\test\\java\\testNGTests\\resources\\deneme.docx"));
        System.out.println("str = " + str);
        boolean isExist= Files.exists(Paths.get(userDir + "\\src\\test\\java\\testNGTests\\resources\\deneme.docx"));
        System.out.println("isExist = " + isExist);


        // kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUrl"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        if (isExist==true){
            try {
                page.dosyaSec.click();
            }catch (Exception e) {
                page.dosyaSec.sendKeys(str);


            }
        }
        ReusableMethods.wait(5);
        closeDriver();
    }

    @Test(priority = -3)
    public void existFile3() throws InterruptedException {

        //kullanici https://demoqa.com/upload-download sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqa_Download"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //download butonuna basar
        page.download.click();
        ReusableMethods.wait(2); //fail olursa bu bekleme dosyanin inmesi icin gerekli

        //dosyanin indigini dogrular
        String dosyaYolu=System.getProperty("user.home") +"/Downloads/sampleFile.jpeg";
        boolean isExist= Files.exists(Paths.get(dosyaYolu));
        System.out.println("isExist = " + isExist);

        //2.yol
        String dosyaYolu2="C:/Users/Hakan/Downloads/sampleFile.jpeg";
        boolean isExist2= Files.exists(Path.of(dosyaYolu2));
        System.out.println("isExist = " + isExist2);


        Driver.closeDriver();
    }

    /**
     * bu metot ile javascript kullanarak bir elemente sendKey yapılır
     * @param element sendKey yapılacak elementin locate verilmeli
     * @param text elemente gönderilecek değer verilmeli
     */
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);

    }

    /**
     * bu metot ile bir elementin value'suna deger atanir.
     * @param element deger atanacak elementin locate verilmeli
     * @param text elemente gönderilecek value verilmeli
     */
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }
}
