package testNG_Tests.test.paraleltests;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNG_Tests.pages.Selenium_TestNG_16_Faker_FileExist_Page;
import testNG_Tests.utilities.ConfigReader;

import java.time.Duration;


public class ParalelTest_01 {

    @Test(groups = "faileTest")
    public void kitapYurdu() throws InterruptedException {

        WebDriver drivers = new EdgeDriver();
        //kullanici https://www.kitapyurdu.com/ sitesine gider
        drivers.get("https://www.kitapyurdu.com/");
        drivers.manage().window().maximize();
        drivers.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- soft assertion objesi olustur
        SoftAssert softAssert=new SoftAssert();

//         2- soft assertion yap
        String expectedTitle="Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle= drivers.getTitle();
        softAssert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(2000);

        WebElement blueRentalCarsBrand= drivers.findElement(By.cssSelector("li[class='book has-menu active']"));
        softAssert.assertTrue(blueRentalCarsBrand.isDisplayed());

        softAssert.assertTrue(blueRentalCarsBrand.isEnabled());


//        3- assertAll metodu calistir. tum kodlar burada dogrulanir.
        softAssert.assertAll();
        drivers.close();

    }
    Selenium_TestNG_16_Faker_FileExist_Page page=new Selenium_TestNG_16_Faker_FileExist_Page();


    @Test (groups = "RegressionGroup1")
    public void faker() {
        Faker faker=new Faker();

        WebDriver driverx=new EdgeDriver();
        driverx.get(ConfigReader.getProperty("phpTravels"));
        driverx.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

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

        driverx.close();

    }
}
