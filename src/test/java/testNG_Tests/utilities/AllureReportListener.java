package testNG_Tests.utilities;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import static testNG_Tests.utilities.Driver.getDriver;


public class AllureReportListener implements ITestListener{
    //Getting the method name - to mention in the test cases
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    /** Implementation of "Interface - ITestListener" **/
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart - Starting the method" + iTestContext.getName());
        //iTestContext.setAttribute("WebDriver", BasePage.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish - Test case" + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart - Starting test case" + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess" + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance(); // The instance on which this method was run.

        WebDriver driver = getDriver();
        if (driver != null) {
            System.out.println("Screenshot for the failed test: " + getTestMethodName(iTestResult));
            byte[] screenshot = saveScreenshotPNG(driver);
            if (screenshot != null) {
                attachScreenshotToAllure(screenshot);
            }
        } else {
            System.out.println("Driver is null, cannot capture screenshot");
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    // Bu metod artık Allure'a ekran görüntüsünü eklemek için kullanılacak.
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            return screenshot.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Error while taking screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    private void attachScreenshotToAllure(byte[] screenshot) {
        // Bu metodun içi boş çünkü `@Attachment` anotasyonu ile ekran görüntüsü otomatik olarak eklenir.
        // `saveScreenshotPNG` metodundaki `@Attachment` anotasyonu işi halleder.
    }


    // Text attachment for Allure
    @Attachment(value = "Text Log", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }
    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html; }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed in defined success ratio " + getTestMethodName(iTestResult));
    }
}
