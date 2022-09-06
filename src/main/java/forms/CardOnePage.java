package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomDataGenerator;

public class CardOnePage extends Form {
    private final ITextBox passwordTextBox = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "password text box");


    public CardOnePage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'1 / 4')]]"), "card 1 page - email and password form");
    }

    public void fillOutTheForm() {
        fillOutPassword();
        fillOutEmail();
        selectDomain();
    }

    private void fillOutPassword() {
        String validPassword = RandomDataGenerator.createValidPassword();
        passwordTextBox.clearAndType(validPassword);
    }

    private void fillOutEmail() {
    }

    private void selectDomain() {
    }

    public void acceptTerms() {
    }

    public void clickNextBtn() {
    }
}
