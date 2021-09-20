package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class AssayManagementHeaderForm extends BaseForm {

    private static final String LINK_TEMPLATE = "//li//a[.='%s']";

    public AssayManagementHeaderForm() {
        super(By.xpath("//ui-header//div[@class='header']"), "Header");
    }

    public void clickBy(String linkName) {
        ILink link = getElementFactory().getLink(
                By.xpath(String.format(LINK_TEMPLATE,linkName)), linkName);
        link.clickAndWait();
    }

}
