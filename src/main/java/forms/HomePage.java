package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ILink nextPageLink = AqualityServices.getElementFactory().getLink(By.xpath("//a[@class='start__link']"), "link to next page");

    public HomePage() {
        super((By.xpath("//p[@class='start__paragraph']")), "home page");
    }


    public void goToNextPage() {
        nextPageLink.click();
    }
}
