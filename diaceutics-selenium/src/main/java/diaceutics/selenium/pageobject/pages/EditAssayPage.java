package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditAssayPage extends BaseForm {

    public EditAssayPage() {
        super(By.xpath("//h1[.='Edit assay']"), "Edit assay");
    }

}
