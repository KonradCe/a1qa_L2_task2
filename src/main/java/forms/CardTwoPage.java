package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.TestDataUtils;
import aquality.selenium.core.configurations.LoggerConfiguration;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class CardTwoPage extends Form {
    IButton uploadButton = getElementFactory().getButton(
            By.xpath("//a[@class='avatar-and-interests__upload-button']"), "upload image button");
    IButton unselectAllInterestsButton = getElementFactory().getButton(
            By.xpath("//input[@id='interest_unselectall']//following-sibling::span"), "unselect all interests checkbox");
    IButton nextButton = getElementFactory().getButton(
            By.xpath("//button[contains(text(), 'Next')]"), "go to the next page button");
    IButton avatarImage = getElementFactory().getButton(
            By.xpath("//div[@class='avatar-and-interests__avatar-image']"), "avatar image");

    public CardTwoPage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'2 / 4')]]"), "card 2 page - interests and avatar");
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
        List<String> interests = TestDataUtils.getInterestsToSelect();

        for (String interest : interests) {
            String interestsXpath = String.format("//input[@id='interest_%s']//following-sibling::span", interest);
            getElementFactory().getButton(By.xpath(interestsXpath), "random interest checkbox button").click();
        }

    }

    private void unselectAllInterests() {
        unselectAllInterestsButton.click();
    }

    public void clickNext() {
        nextButton.click();
    }
}
