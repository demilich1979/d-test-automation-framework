package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class ConfirmForm extends BaseForm {

    private final IButton btnConfirm = getElementFactory().getButton(
            By.xpath("//button[.='Confirm']"), "Confirm");

    public ConfirmForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Confirm']"), "Confirm");
    }

    public void clickConfirm() {
        btnConfirm.clickAndWait();
    }
}
