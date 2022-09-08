import base.BaseTest;
import forms.CardOnePage;
import forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoggerUtils;
import utils.TestDataUtils;

public class TimerTest extends BaseTest {

    @Test
    private void timerTest() {
        LoggerUtils.info("Validating timer test - step 1/2");
//        STEP: Navigate to home page.
//        RESULT: Welcome page is open.
        browser.goTo(TestDataUtils.getHomePageUrl());
        HomePage homePage = new HomePage();
        String errorMessageStep1 = "opening home page should result in home page being open";
        Assert.assertTrue(homePage.state().waitForDisplayed(), errorMessageStep1);

        LoggerUtils.info("Validating timer test - step 2/2");
//        STEP: Navigate to game page
//        RESULT: Validate that timer starts from "00:00"
        homePage.goToNextPage();
        CardOnePage cardOnePage = new CardOnePage();
        String timerValue = cardOnePage.getTimerValue();
        String errorMessageStep2 = "timer should start at '00:00:00'";
        Assert.assertEquals(timerValue, "00:00:00", errorMessageStep2);
    }
}
