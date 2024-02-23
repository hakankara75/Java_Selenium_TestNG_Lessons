package testNG_Tests.test.xmlFile_Group_Loop;

import org.testng.TestNG;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_24_Excel_Pages;
import testNG_Tests.utilities.ExcelUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static testNG_Tests.utilities.Driver.getDriver;
import static testNG_Tests.utilities.Driver.quiteDriver;

public class Group {
    Selenium_TestNG_24_Excel_Pages page=new Selenium_TestNG_24_Excel_Pages();
    String path="src/test/resources/userData.xlsx";
    String sheetName="positive";
    ExcelUtils excelUtils=new ExcelUtils(path,sheetName);
    private static int counter=1;
    @Test
    public void loopMethod() {
    int totalRow=excelUtils.rowCount(); //excelldeki dolu olan satır sayisini verir
        System.out.println("totalRow = " + totalRow);

        for (int i = 0; i < totalRow; i++) {
            System.out.println("Bu loop icine kac defa girildi = " + i);
            TestNG testNG=new TestNG();
            List<String> file= new ArrayList<String>();
            file.add("xml_Group_Loop.xml");
            testNG.setTestSuites(file);
            testNG.run();

        }

    }

    @Test(groups = "group1")
    public void testName1() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        for (int i = counter; i <=counter; i++) {
            String email= excelUtils.getCellData(i,0);
            String password= excelUtils.getCellData(i,1);
            page.emailLambda.sendKeys(email);
            page.passwordLambda.sendKeys(password);
            page.loginLambda.click();

        }



    }
    @Test(groups = "group2")
    public void testName2() {
        System.out.println("Test 2 çalıştı");
    }
    @Test(groups = "group3")
    public void testName3() {
        System.out.println("Test 3 çalıştı");
        quiteDriver();
        counter++;
    }
}
