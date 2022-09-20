package base;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public static final Logger logger = Logger.getInstance();
    protected static final ISettingsFile URLS = new JsonSettingsFile("Urls.json");
    protected static final ISettingsFile TEST_DATA = new JsonSettingsFile("TestData.json");
    protected Browser browser;
    protected HomePage homePage;

    @BeforeSuite
    public void setupLogger() {
        logger.info("start of the testing suite");
    }

    @BeforeClass
    public void setUp() {
        logger.info("test set up");
        browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @BeforeMethod
    public void firstStep() {
        logger.info("Navigate to home page - step 1");
        browser.goTo(URLS.getValue("/home_page_url").toString());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "home page was not displayed");
        homePage.goToNextPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("test tear down");
        browser.quit();
    }
}
