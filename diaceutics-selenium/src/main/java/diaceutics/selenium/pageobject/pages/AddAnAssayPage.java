package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import diaceutics.selenium.models.Biomarker;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.AddBiomarkerForm;
import org.openqa.selenium.By;

import java.util.List;

public class AddAnAssayPage extends BaseForm {

    private static final String ADD_BUTTON_TEMPLATE = "//form//button[.='%s']";
    private static final String BIOMARKER_TEMPLATE = "//tr[.//span[.='%s']]";

    public AddAnAssayPage() {
        super(By.xpath("//h1[.='Add an assay']"), "Add a location");
    }

    public AddBiomarkerForm getAddBiomarkerForm() {
        return new AddBiomarkerForm();
    }

    public void clickAdd(String buttonName) {
        IButton btnAdd = getElementFactory().getButton(
                By.xpath(String.format(ADD_BUTTON_TEMPLATE, buttonName)), buttonName);

        btnAdd.clickAndWait();
    }

    public boolean isBiomarkerAdded(Biomarker biomarker) {
        List<IElement> volumeLink = getElementFactory().findElements(By.xpath
                (String.format(BIOMARKER_TEMPLATE, biomarker.getBiomarker())), ElementType.LINK);

        return volumeLink.size() > 0;
    }

}
