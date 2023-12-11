package testNG_Tests.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_17_WebTables_Page;
import testNG_Tests.utilities.ConfigReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static testNG_Tests.utilities.Driver.closeDriver;
import static testNG_Tests.utilities.Driver.getDriver;
import static testNG_Tests.utilities.ReusableMethods.giveSpecificCell;

public class Selenium_TestNG_17_WebTables_Test {

    Selenium_TestNG_17_WebTables_Page page= new Selenium_TestNG_17_WebTables_Page();

    @Test
    public void webTable() {

                /*
    kullanici https://the-internet.herokuapp.com/tables sitesine gider
    kullanici example 1 tablosunu satir satir yazdirir
     */

        // kullanici https://the-internet.herokuapp.com/tables sitesine gider
        getDriver().get(ConfigReader.getProperty("webTables"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //kullanici example 1 tablosunu satir satir yazdirir
        String example1Text=page.example1.getText();
        System.out.println("example1Text = " + example1Text);

        closeDriver();

    }

    @Test
    public void webTables1() {
        /*
            kullanici https://the-internet.herokuapp.com/tables sitesine gider
            kullanici example 1 tablosundaki her bir satiri ayri ayri yazdirir
         */

        // kullanici https://the-internet.herokuapp.com/tables sitesine gider
        getDriver().get(ConfigReader.getProperty("webTables"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // kullanici example 1 tablosundaki her bir satiri ayri ayri yazdirir
        for (WebElement element: page.example1List){
            System.out.println("element.getText() = " + element.getText());
        }
        closeDriver();

    }

    @Test
    public void getSpecialColumn() {

        /*
           kullanici https://the-internet.herokuapp.com/tables sitesine gider
             Kullanici example 1 tablosunda $101'dan fazla ucret olmadigini dogrular
         */

        // kullanici https://the-internet.herokuapp.com/tables sitesine gider
        getDriver().get(ConfigReader.getProperty("webTables"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Kullanici example 1 tablosunda $101'dan fazla ucret olmadigini dogrular
        //1. basamak
        List<Integer> elementsDue=new ArrayList<Integer>();

        for (int i = 0; i < page.dueColumn.size(); i++) {
            String elementText= page.dueColumn.get(i).getText();
            elementText= elementText.replace("$", "");
            elementText= elementText.replace(".00", "");
            int due= Integer.parseInt(elementText);
            System.out.println("due = " + due);
            elementsDue.add(due);

        }
        System.out.println("elementsDue = " + elementsDue);

        for (Integer element : elementsDue) {
            if(element>99){
                System.out.println("element = " + element);
                assertTrue(element<102);
            }



        }

        closeDriver();

    }


    @Test
    public void test2() {
        /*
  kullanici https://the-internet.herokuapp.com/tables sitesine gider
      bir tablonun istenen satir ve sutun bilgisine ulasip dogrular
 */
        // kullanici https://the-internet.herokuapp.com/tables sitesine gider
        getDriver().get(ConfigReader.getProperty("webTables"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //bir tablonun istenen satir ve sutun bilgisine ulasip dogrular
        String cellData= giveSpecificCell(2,3);
        System.out.println("cellData = " + cellData);
        assertTrue(cellData.contains("fbach@"));

        closeDriver();
    }


}
