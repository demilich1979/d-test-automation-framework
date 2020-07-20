package diaceutics.cucumber.stepdefinitions;

import diaceutics.selenium.pageobject.forms.AssayManagementHeaderForm;
import io.cucumber.java.en.When;

public class AssayManagementHeaderFormSteps {

    private final AssayManagementHeaderForm assayManagementHeaderForm;

    public AssayManagementHeaderFormSteps() {
        assayManagementHeaderForm = new AssayManagementHeaderForm();
    }

    @When("I click {string} on Header form")
    public void iClickOnHeaderFormOnAssayManagementPage(String linkName) {
        assayManagementHeaderForm.clickBy(linkName);
    }
}
