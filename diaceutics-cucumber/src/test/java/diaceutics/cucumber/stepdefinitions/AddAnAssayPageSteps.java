package diaceutics.cucumber.stepdefinitions;

import diaceutics.cucumber.utilities.ScenarioContext;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.enums.pageFields.AddAnAssayPageFields;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.pageobject.pages.AddAnAssayPage;
import diaceutics.selenium.utilities.TimeUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;
import java.util.Map;


public class AddAnAssayPageSteps {

    private final AddAnAssayPage addAnAssayPage;
    private final ScenarioContext scenarioContext;

    @Inject
    public AddAnAssayPageSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
        addAnAssayPage = new AddAnAssayPage();
    }

    @Given("Add an Assay page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(addAnAssayPage.isDisplayed(), "Add an Assay page should be opened");
    }

    @When("I fill following fields on Add an Assay page and save as {string}:")
    public void fillLabAddressFormOnAddLocationPage(String key, Map<String, String> data) {
        Assay assay = new Assay();
        data.forEach((field, value) -> {
            if (field.equals("Assay name")) {
                value = value + TimeUtil.getTimestamp();
            }
            addAnAssayPage.setFieldValue(AddAnAssayPageFields.getEnumValue(field), value);
            assay.setReflectionFieldValue(AddAnAssayPageFields.getEnumValue(field).getModelField(), value);

        });

        XmlFileStore.store(key, assay);
    }

    @And("I click {string} on Add an Assay page")
    public void iClickAddAssayOnAddAnAssayPage(String buttonName) {
        addAnAssayPage.clickAdd(buttonName);
    }
}
