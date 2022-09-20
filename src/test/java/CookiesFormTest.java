import base.BaseTest;
import forms.CardOnePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesFormTest extends BaseTest {

    @Test
    private void acceptCookiesTest() {
        logger.info("Accept cookies test - step 2/2");
        CardOnePage cardOnePage = new CardOnePage();
        cardOnePage.acceptCookies();
        Assert.assertFalse(cardOnePage.isCookiesFormOpen(), "cookie form is still open");
    }
}
