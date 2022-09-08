import base.BaseTest;
import forms.CardOnePage;
import forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.LoggerUtils;
import utils.TestDataUtils;

public class HelpFormTest extends BaseTest {

    @Test
    private void hidingHelpTest() {
        LoggerUtils.info("Hiding the help form test - step 1/2");
//        STEP: Navigate to home page.
//        RESULT: Welcome page is open.
        browser.goTo(TestDataUtils.getHomePageUrl());
        HomePage homePage = new HomePage();
        String errorMessageStep1 = "opening home page should result in home page being open";
        Assert.assertTrue(homePage.state().waitForDisplayed(), errorMessageStep1);

        LoggerUtils.info("Hiding the help form test - step 2/2");
//        STEP: Hide help form.
//        RESULT: Form content is hidden.
        homePage.goToNextPage();
        CardOnePage cardOnePage = new CardOnePage();
        cardOnePage.hideHelpForm();
        String errorMessageStep2 = "clicking on 'send to bottom' button on help form should hide the form";
        Assert.assertTrue(cardOnePage.isHelpFormHidden(), errorMessageStep2);
    }
}
