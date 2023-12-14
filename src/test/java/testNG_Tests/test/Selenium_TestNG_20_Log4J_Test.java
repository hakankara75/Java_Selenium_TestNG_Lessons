package testNG_Tests.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Selenium_TestNG_20_Log4J_Test {

    private final Logger logger= LogManager.getLogger(Selenium_TestNG_20_Log4J_Test.class.getName());


    @Test
    public void log4J() {

        logger.trace("trace seviyesi");
        logger.debug("debug seviyesi");
        logger.info("info seviyesi");
        logger.warn("warn seviyesi");
        logger.error("error seviyesi");
        logger.fatal("fatal seviyesi");


    }
}
