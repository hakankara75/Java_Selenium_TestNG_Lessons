package testNG_Tests.test.xmlFile_Group;

import org.testng.TestNG;
import org.testng.annotations.Test;
import testNG_Tests.pages.Selenium_TestNG_24_Excel_Pages;
import testNG_Tests.utilities.ExcelUtils;

import java.util.ArrayList;
import java.util.List;

import static testNG_Tests.utilities.Driver.getDriver;

public class xmlFile_Group {
    Selenium_TestNG_24_Excel_Pages pages=new Selenium_TestNG_24_Excel_Pages();
    String path= "src/test/resources/userData.xlsx";
    String sheetName="positive";
    ExcelUtils excel=new ExcelUtils(path, sheetName);
    public static int count=1;

    @Test
    public void testName() {
        int totalRow= excel.rowCount();
        for (int i = 0; i < totalRow; i++) {
            TestNG testNG=new TestNG();
            List<String> suites=new ArrayList<>();
            suites.add("xmlFile_Gorup.xml");
            testNG.setTestSuites(suites);
            testNG.run();
        }

    }

    @Test(groups="test1")
    public void testName1() {
        getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        for (int i = count; i <=count; i++) {
            String email=excel.getCellData(i,0);
            String password=excel.getCellData(i,1);

            pages.emailLambda.sendKeys(email);
            pages.passwordLambda.sendKeys(password);
            pages.loginLambda.click();
        }




    }
    @Test(groups="test2")
    public void testName2() {
        System.out.println("2. test basladi");
    }
    @Test(groups="test3")
    public void testName3() {
        System.out.println("3. test basladi");

        count++;
        System.out.println("count 1 artti");
    }
}
