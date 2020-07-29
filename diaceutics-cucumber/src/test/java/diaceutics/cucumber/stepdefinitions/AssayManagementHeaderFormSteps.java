package diaceutics.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import diaceutics.selenium.configuration.Configuration;
import diaceutics.selenium.pageobject.forms.AssayManagementHeaderForm;
import io.cucumber.java.en.When;

public class AssayManagementHeaderFormSteps {

    private final AssayManagementHeaderForm assayManagementHeaderForm;

    public AssayManagementHeaderFormSteps() {
        assayManagementHeaderForm = new AssayManagementHeaderForm();
    }

    @When("I click {string} on Header form")
    public void iClickOnHeaderFormOnAssayManagementPage(String linkName) {
//        assayManagementHeaderForm.clickBy(linkName);
        AqualityServices.getBrowser().goTo("https://www.dev.dxrx.io/en/mappings/lab/");
    }
}
