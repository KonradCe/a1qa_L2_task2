package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.TestDataUtils;

import java.util.List;

public class CardTwoPage extends Form {
    IButton uploadButton = getElementFactory().getButton(
            By.xpath("//a[@class='avatar-and-interests__upload-button']"), "upload image button");
    IButton unselectAllInterestsButton = getElementFactory().getButton(
            By.xpath("//input[@id='interest_unselectall']//following-sibling::span"), "unselect all interests checkbox");

    public CardTwoPage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'2 / 4')]]"), "card 2 page - interests and avatar");
    }

    public void uploadImage() {
//        uploadButton.sendKeys("G:\\Dokumenty K\\dev\\qa_academy\\L2_task2_userinterface\\userinterface\\src\\main\\resources\\avatar.png");
        uploadButton.click();
    }

    public void selectInterests() {
        unselectAllInterests();
        List<String> interests = TestDataUtils.getInterestsToSelect();
    }

    private void unselectAllInterests() {
        unselectAllInterestsButton.click();
    }
}
