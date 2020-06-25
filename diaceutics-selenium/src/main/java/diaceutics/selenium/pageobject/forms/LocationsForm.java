package diaceutics.selenium.pageobject.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import diaceutics.selenium.models.Location;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;

public class LocationsForm extends BaseForm {

    private static final String LOCATION_TEMPLATE =
            "//div[contains(@class,'address ng-star-inserted')][.//span/strong[.='%s']]//";

    private static final String LOCATION_INFO_TEMPLATE = LOCATION_TEMPLATE + "span[not(.='Edit location')]";
    private static final String EDIT_LOCATION_TEMPLATE = LOCATION_TEMPLATE + "a/ui-icon";

    public LocationsForm() {
        super(By.xpath("//h3[.='Locations']"), "Locations");
    }

    public boolean isLocationDisplayed(Location location) {
        boolean isLocationDisplayed = false;
        List<IElement> locationLabel = getElementFactory().findElements(By.xpath
                (String.format(LOCATION_INFO_TEMPLATE, location.getLocationName())), ElementType.LABEL);

        AqualityServices.getLogger().info("---------------"+locationLabel.get(0).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(1).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(2).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(3).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(4).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(5).getText());
        AqualityServices.getLogger().info("---------------"+locationLabel.get(6).getText());

        if (locationLabel.get(0).getText().equals(location.getLocationName()) &&
                locationLabel.get(1).getText().equals(location.getAddressOne()) &&
                locationLabel.get(2).getText().equals(location.getAddressTwo()) &&
                locationLabel.get(3).getText().equals(location.getCityTown()) &&
                locationLabel.get(4).getText().equals(location.getRegion()) &&
                locationLabel.get(5).getText().equals(location.getCountry()) &&
                locationLabel.get(6).getText().equals(location.getPostalCode())
        ) {
            isLocationDisplayed = true;
        }

        return isLocationDisplayed;
    }

    public void clickEditLocation(Location location) {
        IButton btnEditLocation = getElementFactory().getButton(
                By.xpath(String.format(EDIT_LOCATION_TEMPLATE, location.getLocationName())), location.getLocationName());

        btnEditLocation.clickAndWait();
    }

}
