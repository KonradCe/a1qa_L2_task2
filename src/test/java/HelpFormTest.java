import base.BaseTest;
import forms.CardOnePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpFormTest extends BaseTest {

    @Test
    private void hidingHelpTest() {

        logger.info("Hiding the help form test - step 2/2");
        CardOnePage cardOnePage = new CardOnePage();
        cardOnePage.hideHelpForm();
        Assert.assertTrue(cardOnePage.isHelpFormHidden(), "help form is not hidden");
    }
}
