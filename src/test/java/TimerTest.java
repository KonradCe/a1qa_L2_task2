import base.BaseTest;
import forms.CardOnePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimerTest extends BaseTest {

    @Test
    private void timerTest() {
        logger.info("Validating timer test - step 2/2");
        CardOnePage cardOnePage = new CardOnePage();
        String timerValue = cardOnePage.getTimerValue();
        Assert.assertEquals(timerValue, TEST_DATA.getValue("/startingTimerValue").toString(), "timer does not start at '00:00:00'");
    }
}
