package testNG_Tests.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import testNG_Tests.utilities.ConfigReader;
import testNG_Tests.utilities.Driver;

import java.time.Duration;
import static testNG_Tests.utilities.Driver.getDriver;

public class Selenium_TestNG_14_Annotations_Test {



    /*
    @BeforeSuite  ==> her bir projeden once 1 kez calisir
    @BeforeTest   ==> her bir testten once 1 kez calisir
    @BeforeGroups ==> her bir gruptan once 1 kez calisir  @Test (groups = "regression-test") seklinde grup yapilir
    @BeforeClass  ==> her bir classdan once 1 kez calisir
    @BeforeMethod ==> her bir metotdan once 1 kez calisir JUnit'deki @Before annotation gibi

    @AfterSuite   ==> her bir projeden sonra 1 kez calisir
    @AfterTest    ==> her bir testten sonra 1 kez calisir
    @AfterGroups  ==> her bir gruptan sonra 1 kez calisir @Test (groups = "regression-test") seklinde grup yapilir
    @AfterClass   ==> her bir classdan sonra 1 kez calisir
    @AfterMethod  ==> her bir metotdan sonra 1 kez calisir JUnit'deki @After annotation gibi
    */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("suitden once BeforeSuite calisti ");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("testten once BeforeTest calisti ");
    }
    @BeforeGroups (groups = "group testi")
    public void beforeGroups(){
        System.out.println("groupdan once BeforeGroups calisti ");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("class dan once BeforeClass calisti ");
    }
    @BeforeMethod
    public void beforeMethon(){
        System.out.println("method dan once BeforeMethod calisti ");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("suitden sonra AfterSuite calisti ");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("testten sonra AfterTest calisti ");
    }
    @AfterGroups (groups = "group testi")
    public void afterGroups(){
        System.out.println("groupdan sonra AfterGroups calisti ");
    }
    @AfterSuite
    public void afterClass(){
        System.out.println("class dan sonra AfterClass calisti ");
    }
    @AfterMethod
    public void afterMethon(){
        System.out.println("method dan sonra AfterMethod calisti ");
    }

    @Test (groups = "group testi")
    public void test1() {
        System.out.println("Test1 calisti");
    }
    @Test (groups = "group testi")
    public void test2() {
        System.out.println("Test2 calisti");
    }


}
