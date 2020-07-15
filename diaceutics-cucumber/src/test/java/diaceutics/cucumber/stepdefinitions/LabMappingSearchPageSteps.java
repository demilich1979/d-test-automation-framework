package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.LabMappingSearchPageFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.LabMappingSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LabMappingSearchPageSteps {

    private final LabMappingSearchPage labMappingSearchPage;

    public LabMappingSearchPageSteps() {
        labMappingSearchPage = new LabMappingSearchPage();
    }

    @Then("Lab Mapping Search page is opened")
    public void labMappingSearchIsOpened() {
        Assert.assertTrue(labMappingSearchPage.isDisplayed(), "Lab Mapping Search page should be opened");
    }

    @When("I fill following fields on Lab Mapping Search page:")
    public void iFillFollowingFieldsOnLabMappingSearchPage(Map<String, String> data) {
        data.forEach((field, value) -> {
            labMappingSearchPage.setFieldValue(LabMappingSearchPageFields.getEnumValue(field), value);
        });
    }

    @And("I click {string} on Lab Mapping Search page")
    public void iClickStartOnLabMappingSearchPage(String buttonName) {
        labMappingSearchPage.clickByButton(buttonName);
    }

    @When("I fill following fields on Lab Mapping Search page using data from {string}:")
    public void iFillFollowingFieldsOnLabMappingSearchPageUsingDataFromLab(String key, List<String> fields) {
        Lab lab = XmlFileStore.get(key);
        String country = lab.getCountry();
        Assay assay = lab.getAssays().get(0);
        String disease = assay.getAssociatedDiseases();
        String biomarker = assay.getBiomarkers().get(0).getBiomarker();
        labMappingSearchPage.setFieldValue(LabMappingSearchPageFields.getEnumValue(fields.get(0)), country);
        labMappingSearchPage.setFieldValue(LabMappingSearchPageFields.getEnumValue(fields.get(1)), disease);
        labMappingSearchPage.setFieldValue(LabMappingSearchPageFields.getEnumValue(fields.get(2)), biomarker);
    }
}
