package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.ILabel;
import diaceutics.selenium.models.Volume;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class EditPatientVolumeForm extends BaseForm {

    public EditPatientVolumeForm() {
        super(By.xpath("//div[contains(@class,'header')]//span[.='Edit patient volume']"), "Log patient volume");
    }

    public boolean isMessageForVolumeDisplayed(String messageTemplate, Volume volume) {
        String message = String.format(messageTemplate, volume.getDisease(), volume.getBiomarker());
        ILabel labelMessage = getElementFactory().getLabel(
                By.xpath(String.format("//span[.='%s']", message)),
                "message");

        return labelMessage.state().waitForDisplayed();
    }

}
