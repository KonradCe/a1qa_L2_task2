package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class CardTwoPage extends Form {

    private IButton uploadButton = getElementFactory().getButton(
            By.xpath("//a[@class='avatar-and-interests__upload-button']"), "upload image button");
    private IButton unselectAllInterestsButton = getElementFactory().getButton(
            By.xpath("//input[@id='interest_unselectall']//following-sibling::span"), "unselect all interests checkbox");
    private IButton nextButton = getElementFactory().getButton(
            By.xpath("//button[contains(text(), 'Next')]"), "go to the next page button");
    private IButton avatarImage = getElementFactory().getButton(
            By.xpath("//div[@class='avatar-and-interests__avatar-image']"), "avatar image");
    // for some reason framework (?) can't process xpath "//parent//child" (with two pairs of "//")
    // xpath written like this: "//label[@class='checkbox__label']//input[not(@id='interest_unselectall')]" returns 0 matches
    private List<IButton> interestsButtons = getElementFactory().findElements(
            By.xpath("//label[@class='checkbox__label' and descendant::input[not(contains(@id, 'select'))]]"), IButton.class);

    public CardTwoPage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'2')]]"), "card 2 page - interests and avatar");
    }

    private static void copyImagePathToClipboard() {
        String pathToAvatar = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "avatar.png";
        StringSelection stringSelection = new StringSelection(pathToAvatar);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
    }

    private static void pasteImagePathFromClipboard() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(100);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadImage() {
        uploadButton.click();
        copyImagePathToClipboard();
        pasteImagePathFromClipboard();

        // waiting for the image to finish uploading, so we can proceed further
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> avatarImage.getAttribute("style").contains("url"));
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectInterests() {
        unselectAllInterests();
        for (int i = 0; i < 3; i++) {
            int randomInterestIndex = new Random().nextInt(interestsButtons.size());
            interestsButtons.get(randomInterestIndex).click();
            interestsButtons.remove(randomInterestIndex);
        }
    }

    private void unselectAllInterests() {
        unselectAllInterestsButton.click();
//        for (IButton button : interestsButtons) {
//            button.click();
//        }
    }

    public void clickNext() {
        nextButton.click();
    }
}
