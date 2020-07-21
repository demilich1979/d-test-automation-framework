package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Biomarker;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.AddBiomarkerForm;
import org.openqa.selenium.By;

import java.util.List;

public class EditAssayPage extends BaseForm {

    private static final String BIOMARKER_TEMPLATE = "//tr[.//span[.='%s']]";
    private static final String COMMERCIAL_ASSAY_BIOMARKER_TEMPLATE =
            "//div[contains(@class,'commercialAssayBiomarkers')]//span[contains(text(),'%s')]";

    private final ILabel biomarkerInputLabel = getElementFactory().getLabel(
            By.xpath("//app-biomarker-control[@formcontrolname='biomarkers']"), "Biomarker Input");

    public EditAssayPage() {
        super(By.xpath("//h1[.='Edit assay']"), "Edit assay");
    }

    public AddBiomarkerForm getAddBiomarkerForm() {
        return new AddBiomarkerForm();
    }

    public boolean isBiomarkerAdded(Biomarker biomarker) {
        List<IElement> volumeLink = getElementFactory().findElements(By.xpath
                (String.format(BIOMARKER_TEMPLATE, biomarker.getBiomarker())), ElementType.LINK);

        return volumeLink.size() > 0;
    }

    public boolean isDefaultBiomarkerInputDisplayed() {
        return biomarkerInputLabel.state().waitForNotDisplayed();
    }

    public boolean isCommercialAssayBiomarkerAdded(Assay assay) {
        ILabel commercialAssayBiomarkerLabel = getElementFactory().getLabel(
                By.xpath(String.format(COMMERCIAL_ASSAY_BIOMARKER_TEMPLATE, assay.getCommercialAssays())),
                assay.getCommercialAssays());

        return commercialAssayBiomarkerLabel.state().waitForDisplayed();
    }
}
