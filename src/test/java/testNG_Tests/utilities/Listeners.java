package testNG_Tests.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testNG_Tests.test.Selenium_TestNG_20_Log4J_Test;

public class Listeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart() herbir @Testten önce 1 kez çalışır");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess() başarılı (pass) @Testten sonra çalışır");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure() hatalı (fail) @Testten sonra çalışır");
        System.out.println(result.getName());
        System.out.println(result.getTestClass());
        final Logger logger= LogManager.getLogger(result.getTestClass().getName());
        logger.trace("trace seviyesi");
        logger.debug("debug seviyesi");
        logger.info("info seviyesi");
        logger.warn("warn seviyesi");
        logger.error("error seviyesi");
        logger.fatal("fatal seviyesi");
        ReusableMethods.tumSayfaScreenShoot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped() atlanılacak (skip) @Test lerden sonra çalışır");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart() tüm @Test lerden önce çalışır. yani classtan önce çalışır");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onStart() tüm @Test lerden sonra çalışır. yani classtan sonra çalışır");
    }
}
