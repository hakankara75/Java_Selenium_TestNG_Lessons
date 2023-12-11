package testNG_Tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testNG_Tests.utilities.Driver;

import java.util.List;

public class Selenium_TestNG_17_WebTables_Page {


    public Selenium_TestNG_17_WebTables_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="table1")
    public WebElement example1;
    @FindBy(xpath="//table[@id='table1']//tbody//tr")
    public List<WebElement> example1List;
    @FindBy(xpath="//table[@id='table1']//tbody//tr//td[4]")
    public List<WebElement> dueColumn;
}
