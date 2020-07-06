package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import diaceutics.selenium.models.Biomarker;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.AddBiomarkerForm;
import org.openqa.selenium.By;

import java.util.List;

public class AddAnAssayPage extends BaseForm {

    private static final String BIOMARKER_TEMPLATE = "//tr[.//span[.='%s']]";

    public AddAnAssayPage() {
        super(By.xpath("//h1[.='Add an assay']"), "Add a location");
    }

    public AddBiomarkerForm getAddBiomarkerForm() {
        return new AddBiomarkerForm();
    }

    public boolean isBiomarkerAdded(Biomarker biomarker) {
        List<IElement> volumeLink = getElementFactory().findElements(By.xpath
                (String.format(BIOMARKER_TEMPLATE, biomarker.getBiomarker())), ElementType.LINK);

        return volumeLink.size() > 0;
    }

}
