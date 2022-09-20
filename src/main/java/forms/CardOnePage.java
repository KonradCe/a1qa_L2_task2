package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.StringUtils;

public class CardOnePage extends Form {

    private final ITextBox passwordTextBox = getElementFactory().getTextBox(
            By.xpath("//input[contains(@placeholder, 'Choose Password')]"), "password text box");
    private final ICheckBox termsAndConditionsCheckbox = getElementFactory().getCheckBox(
            By.xpath("//span[@class='checkbox__box']"), "terms and conditions checkbox");
    private final IButton nextButton = getElementFactory().getButton(
            By.xpath("//a[@class='button--secondary' and text()[contains(., 'Next')]]"), "next button");

    private final ITextBox emailLocalTextBox = getElementFactory().getTextBox(
            By.xpath("//input[contains(@placeholder, 'Your email')]"), "email name text box");
    private final ITextBox emailServerTextBox = getElementFactory().getTextBox(
            By.xpath("//input[contains(@placeholder, 'Domain')]"), "email server text box");
    private final IButton emailDomainElement = getElementFactory().getButton(
            By.xpath("//div[@class='dropdown__field']"), "email domain fake dropdown");
    private final IButton emailSpecificDomainElement = getElementFactory().getButton(
            By.xpath("//div[@class='dropdown__list-item' and text()[contains(., '.org')]]"), "element with .org domain");

    private final IButton hideHelpButton = getElementFactory().getButton(
            By.xpath("//button[contains(@class, 'help-form__send-to-bottom-button')]"), "hide help from button");
    private final IButton hiddenHelpFrom = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'is-hidden')]"), "hidden help from");

    private final IButton acceptCookiesButton = getElementFactory().getButton(
            By.xpath("//button[contains(text(), 'Not really')]"), "accept cookies button");
    private final IButton cookiesBanner = getElementFactory().getButton(
            By.xpath("//div[@class='cookies']"), "cookies banner");

    private final IButton timer = getElementFactory().getButton(
            By.xpath("//div[contains(@class, 'timer')]"), "timer");

    public CardOnePage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'1')]]"), "card 1 page - email and password form");
    }

    public void fillOutTheForm() {
        fillOutPasswordAndEmail();
        selectDomain();
    }

    private void fillOutPasswordAndEmail() {
        String validPassword = StringUtils.createValidPassword();

        passwordTextBox.clearAndType(validPassword);
        emailLocalTextBox.clearAndType(validPassword.charAt(1) + "_" + StringUtils.createRandomWord(5));
        emailServerTextBox.clearAndType(StringUtils.createRandomWord(8));
    }

    private void selectDomain() {
        emailDomainElement.click();
        emailSpecificDomainElement.click();
    }

    public void acceptTerms() {
        termsAndConditionsCheckbox.click();
    }

    public void clickNextBtn() {
        nextButton.click();
    }

    public void hideHelpForm() {
        hideHelpButton.click();
    }

    public boolean isHelpFormHidden() {
        return hiddenHelpFrom.state().isExist();
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    public boolean isCookiesFormOpen() {
        return cookiesBanner.state().isDisplayed();
    }

    public String getTimerValue() {
        return timer.getText();
    }
}
