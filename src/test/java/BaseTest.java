import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    Browser browser;

    @BeforeClass
    public void setUp() {
        // TODO: log actions
        System.out.println("test setup");
        browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @AfterClass
    public void tearDown() {
        // TODO: log message here
        System.out.println("test tear down");
//        browser.quit();
    }


}
