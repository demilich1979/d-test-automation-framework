package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.AssayDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AssayDetailsPageSteps {

    private final AssayDetailsPage assayDetailsPage;

    public AssayDetailsPageSteps() {
        assayDetailsPage = new AssayDetailsPage();
    }

    @Given("Assay details page is opened")
    public void labProfilesPageIsOpened() {
        Assert.assertTrue(assayDetailsPage.isDisplayed(), "Assay details page should be opened");
    }

    @When("I click Edit Details on Assay details page")
    public void iClickEditDetailsOnAssayDetailsPage() {
        assayDetailsPage.clickEditDetails();
    }
}
