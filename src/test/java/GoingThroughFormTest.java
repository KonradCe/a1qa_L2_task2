import base.BaseTest;
import forms.CardOnePage;
import forms.CardThreePage;
import forms.CardTwoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoingThroughFormTest extends BaseTest {

    @Test
    public void goingThroughFormTest() {

        logger.info("Completing the form test - step 2/4");
        CardOnePage cardOnePage = new CardOnePage();
        Assert.assertTrue(cardOnePage.state().waitForDisplayed(), "'card 1' page was not displayed");

        logger.info("Completing the form test - step 3/4");
        cardOnePage.fillOutTheForm();
        cardOnePage.acceptTerms();
        cardOnePage.clickNextBtn();
        CardTwoPage cardTwoPage = new CardTwoPage();
        Assert.assertTrue(cardTwoPage.state().waitForDisplayed(), "'card 2' page was not displayed");

        logger.info("Completing the form test - step 4/4");
        cardTwoPage.selectInterests();
        cardTwoPage.uploadImage();
        cardTwoPage.clickNext();
        CardThreePage cardThreePage = new CardThreePage();
        Assert.assertTrue(cardThreePage.state().waitForDisplayed(), "'card 3' page was not displayed");
    }
}
