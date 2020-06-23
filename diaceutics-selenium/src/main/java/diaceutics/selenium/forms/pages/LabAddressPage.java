package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.forms.BaseForm;
import org.openqa.selenium.By;

public class LabAddressPage extends BaseForm {

    private final IButton btnFinish = getElementFactory().getButton(By.xpath("//button[.='Finish']"), "Finish");

    public LabAddressPage() {
        super(By.xpath("//h3[contains(text(),'Lab Address')]"), "Lab Address");
    }

    public void clickFinish() {
        btnFinish.clickAndWait();
    }

}
