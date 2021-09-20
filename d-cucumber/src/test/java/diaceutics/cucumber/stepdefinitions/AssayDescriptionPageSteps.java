package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.AssayDescriptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AssayDescriptionPageSteps {

    private final AssayDescriptionPage assayDescriptionPage;

    public AssayDescriptionPageSteps() {
        assayDescriptionPage = new AssayDescriptionPage();
    }

    @Given("Assay description page is opened")
    public void assayDetailsPageIsOpened() {
        Assert.assertTrue(assayDescriptionPage.isDisplayed(), "Assay description page should be opened");
    }

    @When("I click Edit Details on Assay description page")
    public void iClickEditDetailsOnAssayDetailsPage() {
        assayDescriptionPage.clickEditDetails();
    }
}
