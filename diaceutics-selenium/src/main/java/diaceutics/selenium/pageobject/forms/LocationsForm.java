package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LocationsForm extends BaseForm {

    private static final String LOCATION_TEMPLATE =
            "//div[contains(@class,'address ng-star-inserted')][.//span/strong[.='%s']]//";

    private static final String LOCATION_INFO_TEMPLATE = LOCATION_TEMPLATE + "span[not(.='Edit location')]";
    private static final String EDIT_LOCATION_TEMPLATE = LOCATION_TEMPLATE + "a/ui-icon";

    public LocationsForm() {
        super(By.xpath("//h3[.='Locations']"), "Locations");
    }

    public void clickEditLocation(Location location) {
        IButton btnEditLocation = getElementFactory().getButton(
                By.xpath(String.format(EDIT_LOCATION_TEMPLATE, location.getLocationName())), location.getLocationName());

        btnEditLocation.clickAndWait();
    }

    public List<String> getLocationFieldValues(Location location) {
        List<String> list = new ArrayList<>();
        List<IElement> locationLabel = getElementFactory().findElements(By.xpath
                (String.format(LOCATION_INFO_TEMPLATE, location.getLocationName())), ElementType.LABEL);

        locationLabel.forEach(option -> {
            list.add(option.getText());
        });

        return list;
    }

}
