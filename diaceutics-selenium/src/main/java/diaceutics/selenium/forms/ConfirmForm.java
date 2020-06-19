package diaceutics.selenium.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ConfirmForm extends Form {

    private final IButton btnConfirm = getElementFactory().getButton(
            By.xpath("//button[.='Confirm']"), "Confirm");

    public ConfirmForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Confirm']"), "Confirm");
    }

    public void clickConfirm() {
        btnConfirm.clickAndWait();
    }
}
