package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.LabMappingResultsForm;
import org.openqa.selenium.By;

public class LabMappingResultsPage extends BaseForm {

    public LabMappingResultsPage() {
        super(By.id("labMappingResultsContainer"), "lab Mapping Results");
    }

    public LabMappingResultsForm getLabMappingResultsGrid() {
        return new LabMappingResultsForm();
    }
}
