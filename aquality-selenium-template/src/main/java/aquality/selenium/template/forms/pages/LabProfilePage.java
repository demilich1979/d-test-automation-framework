package aquality.selenium.template.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LabProfilePage extends Form {

    private final IButton btnCreateLab = getElementFactory().getButton(By.xpath("//button[text()='Create a Lab']"), "Create a Lab");

    public void clickCreateLab(){
        btnCreateLab.clickAndWait();
    }

    public LabProfilePage(){
        super(By.xpath("//h1[text()='Labs']"), "Labs");
    }

}
