package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.pages.AssayManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.inject.Inject;

public class AssayManagementPageSteps {

    private final AssayManagementPage assayManagementPage;

    @Inject
    public AssayManagementPageSteps() {
        assayManagementPage = new AssayManagementPage();
    }

    @Given("Assay Management page is opened")
    public void labsPageIsOpened() {
        Assert.assertTrue(assayManagementPage.isDisplayed(), "Assay Management page should be opened");
    }

    @When("I click {string} on Assay Management page")
    public void openCreateLabPage(String buttonName) {
        assayManagementPage.clickByButton(buttonName);
    }

    @Then("I select {string} country on Assay Management page")
    public void iSelectCountryOnLabsPage(String countryName) {
        assayManagementPage.clickByCountryLink(countryName);
    }

    @When("I choose a {string} and press Search icon on Assay Management page")
    public void iChooseACountryAndPressSearchIcon(String country) {
        assayManagementPage.chooseCountry(country);
        assayManagementPage.clickSearch();
    }

    @When("I put a Lab {string} on search field {string} and press Search icon on Assay Management page")
    public void iPutALabLabNameAnSearchTextBoxAndPressSearchIcon(String labName, String searchFieldName) {
        assayManagementPage.putTextInSearchField(labName,searchFieldName);
        assayManagementPage.clickSearch();
    }

}
