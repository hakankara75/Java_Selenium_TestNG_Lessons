package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

public class Selenium_TestNG_15_FileUpload_Waits_Exceptions_Page {

    public Selenium_TestNG_15_FileUpload_Waits_Exceptions_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="uploadFile")
        public WebElement dosyaSec;
    @FindBy(id="visibleAfter")
    public WebElement visibleAfter;
    @FindBy(id="acceptttttttt")
    public WebElement accept;

}
