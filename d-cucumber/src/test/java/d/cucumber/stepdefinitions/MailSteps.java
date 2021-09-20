package diaceutics.cucumber.stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import diaceutics.cucumber.utilities.XmlFileStore;
import diaceutics.selenium.models.User;
import diaceutics.selenium.utilities.MailUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class MailSteps {

    @Then("I get a mail for the {string} with a subject {string}")
    public void iGetAMailForTheUserWithASubjectVerifyYourEmail(String key, String subject) {
        User user = XmlFileStore.get(key);
        Assert.assertTrue(MailUtil.isMailWithSubjectExist(user.getEmail(), subject),
                String.format("Mail with subject %s should be exist", subject));
    }

    @And("I open Verify Link from {string} mail with subject {string} and confirm registration")
    public void iOpenVerifyLinkFromUserMail(String key, String subject) {
        User user = XmlFileStore.get(key);
        String url = MailUtil.getLinkFromMailWithSubject(user.getEmail(), subject);
        AqualityServices.getBrowser().goTo(url);
    }
}
