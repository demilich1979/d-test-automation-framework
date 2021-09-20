package diaceutics.selenium.pageobject.forms;

import aquality.selenium.elements.interfaces.IComboBox;
import diaceutics.selenium.pageobject.BaseMarketplaceForm;
import org.openqa.selenium.By;

public class CategoriesOfTheCollaborationForm extends BaseMarketplaceForm {

    private final IComboBox categoriesComboBox = getElementFactory().getComboBox(
            By.id("listing_categories_listingListingCategories"), "Categories");

    public CategoriesOfTheCollaborationForm() {
        super(By.xpath("//li//span[contains(text(),'Categories')]"), "Categories of the collaboration");
    }

    public String getCategories() {
        return categoriesComboBox.getSelectedText().trim();
    }

}
