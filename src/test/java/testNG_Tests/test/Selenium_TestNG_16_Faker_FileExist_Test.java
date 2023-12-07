package testNG_Tests.test;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_16_Faker_FileExist_Page;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_16_Faker_FileExist_Test {

    Selenium_TestNG_16_Faker_FileExist_Page page = new Selenium_TestNG_16_Faker_FileExist_Page();

    @Test
    public void faker() {
        Faker faker = new Faker();

        //https://www.phptravels.net/signup sitesine gidilir
        getDriver().get(ConfigReader.getProperty("php"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String name=faker.name().firstName();
        page.firstName.sendKeys(name);

        String lastname=faker.name().lastName();
        page.lastName.sendKeys(lastname);

        //css tag (.) ve class value
        //WebElement country= getDriver().findElement(By.cssSelector("div.filter-option-inner"));
        page.country.click();

        page.albania.click();

        String phone=faker.phoneNumber().cellPhone();
        //faker.numerify("###-###-###-#####"); istenen formtta yazabilirsiniz.
        page.phone.sendKeys(phone);

        String mail=faker.internet().emailAddress();
        page.email.sendKeys(mail);

        String pass=faker.internet().password();
        page.password.sendKeys(pass);

        getDriver().switchTo().frame(0);

        //css tag (.) ve class value
//        WebElement captcha= getDriver().findElement(By.cssSelector("div.recaptcha-checkbox-border"));
        page.captcha.click();
        ReusableMethods.wait(10);

        getDriver().switchTo().defaultContent(); //ana pencereye geri doner
        //css tag (.) ve id value
        //WebElement signup= getDriver().findElement(By.cssSelector("button#submitBTN"));
        page.signUp.click();

        closeDriver();

    }

    @Test
    public void fileExist1() {

        String userHome= System.getProperty("user.home");
        System.out.println("userHome = " + userHome); //C:\Users\Hakan

        boolean yol=Files.exists(Paths.get("C:\\deneme.docx"));

        //"C:\Users\Hakan\Desktop\deneme.docx"
        boolean path= Files.exists(Paths.get(userHome+"Desktop/deneme.docx"));

        closeDriver();

    }

    @Test
    public void fileExist2() {
        //kullanici https://demoqa.com/upload-download sitesine gider
        getDriver().get(ConfigReader.getProperty("demoqaUpload"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //download butonuna basti
        page.download.click();
        ReusableMethods.wait(2);

        //"C:\Users\Hakan\Downloads\sampleFile.jpeg"
        String dosyaYolu1= System.getProperty("user.home")+ "/Downloads/sampleFile.jpeg";
        boolean isExist= Files.exists(Paths.get(dosyaYolu1));
        System.out.println("isExist = " + isExist);

        //2.yolu
        String dosyaYolu2= "C:/Users/Hakan/Downloads/sampleFile.jpeg";
        boolean isExist2= Files.exists(Paths.get(dosyaYolu2));
        System.out.println("isExist2 = " + isExist2);

        closeDriver();

    }
}
