package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_16_Faker_FileExist_Page {
    public Selenium_TestNG_16_Faker_FileExist_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="uploadFile")
    public WebElement dosyaSec;

}
