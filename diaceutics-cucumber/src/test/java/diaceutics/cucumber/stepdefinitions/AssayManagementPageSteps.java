package diaceutics.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.configuration.Configuration;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.pages.AssayManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AssayManagementPageSteps {

    private final AssayManagementPage assayManagementPage;

    public AssayManagementPageSteps() {
        assayManagementPage = new AssayManagementPage();
    }

    @Given("Assay Management page is opened")
    public void assayManagementPageIsOpened() {
        // ToDo: remove after fixed issue
        AqualityServices.getBrowser().goTo("https://ice-dev.diaceuticscloud.com/profiles/");
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
    public void iPutALabLabNameAnSearchTextBoxAndPressSearchIcon(String key, String searchFieldName) {
        Lab lab = XmlFileStore.get(key);
        String labName = lab.getName();
        assayManagementPage.putTextInSearchField(labName, searchFieldName);
        assayManagementPage.clickSearch();
    }

}
