package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardThreePage extends Form {
    public CardThreePage() {
        super(By.xpath("//div[@class='page-indicator' and text()[contains(.,'3 / 4')]]"), "card 3 page - personal details");
    }
}
