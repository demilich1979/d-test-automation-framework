package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class LabMappingSearchPage extends BaseForm {

    public LabMappingSearchPage() {
        super(By.id("labMappingSearchContainer"), "lab Mapping Search");
    }
}
