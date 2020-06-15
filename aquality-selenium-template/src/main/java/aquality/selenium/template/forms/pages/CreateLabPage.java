package aquality.selenium.template.forms.pages;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CreateLabPage extends Form {

    private final ITextBox txbName = getElementFactory().getTextBox(By.xpath("//label[text()='Name']/following-sibling::input"), "Name");

    public CreateLabPage setName (final String name) {
        txbName.clearAndType(name);
        return this;
    }

    public CreateLabPage(){
        super(By.xpath("//h1[text()='Create a Lab']"), "Create a Lab");
    }
}
