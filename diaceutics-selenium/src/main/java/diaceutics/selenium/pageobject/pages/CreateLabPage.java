package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class CreateLabPage extends BaseForm {

    private final IButton btnNext = getElementFactory().getButton(By.xpath("//button[.='Next']"), "Next");

    public CreateLabPage() {
        super(By.xpath("//h1[text()='Create a Lab']"), "Create a Lab");
    }

    public void clickNext() {
        btnNext.clickAndWait();
    }

}
