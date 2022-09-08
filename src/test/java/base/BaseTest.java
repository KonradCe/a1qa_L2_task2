package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.LoggerUtils;

public class BaseTest {

    protected Browser browser;

    @BeforeClass
    public void setUp() {
        LoggerUtils.info("test set up");
        browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @AfterClass
    public void tearDown() {
        LoggerUtils.info("test tear down");
        browser.quit();
    }

    @BeforeSuite
    public void setupLogger() {
        LoggerUtils.info("start of the testing suite");
    }


}
