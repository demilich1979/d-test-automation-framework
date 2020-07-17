package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.*;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class MarketplaceMainPage extends BaseForm {

    private static final String LINK_OF_THE_MIDDLE_TEMPLATE = "//a[contains(@class,'btn-primary')][contains(text(),'%s')]";
    private static final String LINK_OF_THE_BOTTOM_TEMPLATE = "//div[@class='pt-2 text-size-default']//a[contains(text(),'%s')]";
    private final IButton categoriesBtn = getElementFactory().getButton(By.id("categories"), "Categories");
    private final IButton searchBtn = getElementFactory().getButton(
            By.xpath("//button[contains(@class,'btn-primary')]"), "Search");

    public MarketplaceMainPage() {
        super(By.xpath("//div[contains(@class,'jumbotron-holder')]"), "Marketplace");
    }

    public void clickByLinkOnTheMiddleOfThePage(String linkName) {
        IButton link = getElementFactory().getButton(
                By.xpath(String.format(LINK_OF_THE_MIDDLE_TEMPLATE, linkName)), linkName);

        link.clickAndWait();
    }

    public void clickSearch() {
        searchBtn.clickAndWait();
    }

    public void clickByLInkOnTheBottomOfThePage(String linkName) {
        ILink link = getElementFactory().getLink(
                By.xpath(String.format(LINK_OF_THE_BOTTOM_TEMPLATE, linkName)), linkName);

        link.clickAndWait();
    }

    @Override
    public String setFieldValue(FormFieldInterface field, String value) {
        switch (field.getFieldType()) {
            case TEXT:
                ITextBox textBox = getElementFactory().getTextBox(By.id(field.getLocator()), field.getFriendlyName());
                textBox.clearAndType(value);

                break;

            case COMBOBOX:
                IComboBox comboBox = getElementFactory().getComboBox(By.id(field.getLocator()), field.getFriendlyName());
                if (value.equals("random")) {
                    List<String> options = comboBox.getTexts();
                    int randomIndex = new Random().nextInt(options.size());
                    value = options.get(randomIndex);
                }

                comboBox.selectByText(value);

                break;

            case CHECKBOX:
                categoriesBtn.clickAndWait();
                ICheckBox checkBox = getElementFactory().getCheckBox(By.xpath(field.getLocator()), field.getFriendlyName());
                boolean shouldBeChecked = Boolean.parseBoolean(value);
                if (shouldBeChecked) {
                    checkBox.click();
                }
                categoriesBtn.clickAndWait();

                break;

            default:
                break;
        }

        return value;
    }
}
