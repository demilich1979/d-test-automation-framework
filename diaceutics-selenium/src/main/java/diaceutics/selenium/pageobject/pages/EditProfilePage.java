package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;


public class EditProfilePage extends BaseForm {

    private static final String SORT_COLUMN_BUTTON_TEMPLATE = "//th[.//span[.='%s']]//ui-icon";

    private final IButton btnSave = getElementFactory().getButton(
            By.xpath("//form[contains(@class,'submitted')]//button[.='Save']"), "Save");

    public EditProfilePage() {
        super(By.xpath("//h1[.='Edit Profile']"), "Edit Profile");
    }

    public void clickSave(){
        btnSave.clickAndWait();
    }

}
