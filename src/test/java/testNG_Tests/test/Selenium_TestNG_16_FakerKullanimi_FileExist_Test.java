package testNG_Tests.test;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_16_Faker_FileExist_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;
import static testNG_Tests.utilities.ReusableMethods.sendAttributeJS;


public class Selenium_TestNG_16_FakerKullanimi_FileExist_Test {

    Selenium_TestNG_16_Faker_FileExist_Page page = new Selenium_TestNG_16_Faker_FileExist_Page();

    @Test
    public void faker() {
        Faker faker = new Faker();

        //kullanici https://www.phptravels.net/signup sitesine gider
        getDriver().get(ConfigReader.getProperty("php"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String firstName = faker.name().firstName();
        page.firstName.sendKeys(firstName);

        String lastName = faker.name().lastName();
        page.lastName.sendKeys(lastName);

        page.country.click();
        page.albania.click();

        String phone = faker.phoneNumber().phoneNumber();
        page.phone.sendKeys(phone);

        String email = faker.internet().emailAddress();
        page.userEmail.sendKeys(email);

        String password = faker.internet().password();
        page.password.sendKeys(password);

        getDriver().switchTo().frame(0);
        page.captcha.click();
        ReusableMethods.wait(15);
        getDriver().switchTo().defaultContent();

        page.signUp.click();
        closeDriver();

    }

    @Test
    public void faker2() {
        Faker faker = new Faker();
//kullanici https://www.koctas.com.tr/sregister/register sitesine gider
        getDriver().get(ConfigReader.getProperty("koctas"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String ad = faker.name().firstName();
        page.ad.sendKeys(ad);

        String soyad = faker.name().lastName();
        page.soyad.sendKeys(soyad);

        String eposta = faker.internet().emailAddress();
        page.email.sendKeys(eposta);

        String cepTelefonu = faker.numerify("(5##) ### ## ##");
        System.out.println("cepTelefonu = " + cepTelefonu);
        sendAttributeJS(cepTelefonu, page.cepTelefonu);
        //page.cepTelefonu.sendKeys(eposta);

        String sifre = faker.internet().password();
        page.sifre.sendKeys(sifre);
        ReusableMethods.wait(3);
        closeDriver();

    }

    @Test
    public void existFile() {
        //1.yol
        boolean isExist = Files.exists(Paths.get("C:/Users/Hakan/Desktop/deneme.docx")); //hard code
        System.out.println("isExist = " + isExist);

        // kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUpload"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2.yol
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome); //C:\Users\Hakan

        boolean path = Files.exists(Paths.get(userHome + "/Desktop/deneme.docx"));
        System.out.println("path = " + path);
        if (path == true) {
            try {
                page.dosyaSec.click();
            } catch (Exception e) {
                page.dosyaSec.sendKeys(System.getProperty("user.home") + "/Desktop/deneme.docx");
            }

        }
        ReusableMethods.wait(2);
        closeDriver();
    }

    @Test
    public void existFile2() {
        String userDirectory = System.getProperty("user.dir");
        System.out.println("userDirectory = " + userDirectory); // C:\Users\Hakan\IdeaProjects\Java_Selenium_TestNG_Lesson

        // kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUpload"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1.yol
        String userDir = System.getProperty("user.dir");
        boolean yol = Files.exists(Paths.get("C:\\Users\\Hakan\\IdeaProjects\\Java_Selenium_TestNG_Lesson\\src\\test\\java\\testNG_Tests\\resources\\deneme.docx"));
        System.out.println("yol = " + yol);

        //2.yol
        String str = String.valueOf(Paths.get((userDirectory + "/src/test/java/testNG_Tests/resources/deneme.docx")));
        System.out.println("str = " + str);
        boolean isExist = Files.exists(Paths.get(userDir + "\\src\\test\\java\\testNG_Tests\\resources\\deneme.docx"));
        System.out.println("isExist = " + isExist);

        if (isExist == true) {
            try {
                page.dosyaSec.click();
            } catch (Exception e) {
                page.dosyaSec.sendKeys(System.getProperty("user.home") + "/Desktop/deneme.docx");
            }

        }
        ReusableMethods.wait(2);
        closeDriver();

    }

    @Test
    public void existFile3() {
        // kullanici "https://demoqa.com/upload-download" sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUpload"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //download butonuna basar
        page.download.click();
        ReusableMethods.wait(3);

        //dosyanin indigini dogrula
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/sampleFile.jpeg";
        System.out.println("dosyaYolu = " + dosyaYolu);

        //1.yol
        String dosyaYolu1= "C:/Users/Hakan/Downloads/sampleFile.jpeg";
        boolean dosyaVarMi= Files.exists((Paths.get(dosyaYolu1)));
        System.out.println("dosyaVarMi = " + dosyaVarMi);


        //2.yol
        boolean isExist= Files.exists((Paths.get(dosyaYolu)));
        System.out.println("isExist = " + isExist);

        closeDriver();

    }
}
