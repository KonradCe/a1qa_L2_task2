import base.BaseTest;
import forms.CardOnePage;
import forms.CardThreePage;
import forms.CardTwoPage;
import forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataUtils;

public class GoingThroughFormTest extends BaseTest {

    @Test
    public void goingThroughFormTest() {

//        STEP: Navigate to home page.
//        RESULT: Welcome page is open.
        browser.goTo(TestDataUtils.getHomePageUrl());
        HomePage homePage = new HomePage();
        String errorMessageStep1 = "opening home page should result in home page being open";
        Assert.assertTrue(homePage.state().waitForDisplayed(), errorMessageStep1);

//        STEP: Click the link (in text 'Please click HERE to GO to the next page') to navigate the next page.
//        RESULT: The '1' card is open.
        homePage.goToNextPage();
        CardOnePage cardOnePage = new CardOnePage();
        String errorMessageStep2 = "clicking on the link should open 'card 1' page";
        Assert.assertTrue(cardOnePage.state().waitForDisplayed(), errorMessageStep2);

//        STEP: Input random valid password, email, accept the terms of use and click "next" button.
//        RESULT: The '2' card is open.
        cardOnePage.fillOutTheForm();
        cardOnePage.acceptTerms();
        cardOnePage.clickNextBtn();

        CardTwoPage cardTwoPage = new CardTwoPage();
        String errorMessageStep3 = "filling the form correctly and clicking on 'next' button should open 'card 2' page";
        Assert.assertTrue(cardTwoPage.state().waitForDisplayed(), errorMessageStep3);

//        STEP: Choose 3 random interest, upload image, click "Next" button.
//        RESULT: The '3' card is open.
        cardTwoPage.selectInterests();
        cardTwoPage.uploadImage();
        cardTwoPage.clickNext();
        CardThreePage cardThreePage = new CardThreePage();
        String errorMessageStep4 = "clicking next button after filling the form should open 'card 3' page";
        Assert.assertTrue(cardThreePage.state().waitForDisplayed(), errorMessageStep4);
    }
}
