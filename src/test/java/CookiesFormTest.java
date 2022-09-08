import base.BaseTest;
import forms.CardOnePage;
import forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataUtils;

public class CookiesFormTest extends BaseTest {

    @Test
    private void acceptCookiesTest() {
//        STEP: Navigate to home page.
//        RESULT: Welcome page is open.
        browser.goTo(TestDataUtils.getHomePageUrl());
        HomePage homePage = new HomePage();
        String errorMessageStep1 = "opening home page should result in home page being open";
        Assert.assertTrue(homePage.state().waitForDisplayed(), errorMessageStep1);

//        Accept cookies.
//        Form is closed.
        homePage.goToNextPage();
        CardOnePage cardOnePage = new CardOnePage();
        cardOnePage.acceptCookies();
        String errorMessageStep2 = "accepting cookies should close the cookies banner";
        Assert.assertFalse(cardOnePage.isCookiesFormOpen(), errorMessageStep2);
    }
}