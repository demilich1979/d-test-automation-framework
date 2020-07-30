package diaceutics.selenium.pageobject.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.utilities.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AGGridLabSummaryForm extends BaseForm {

    private static final String COLUMN_TEMPLATE = "//div[@col-id='%s' and not(contains(@class,'ag-header-cell'))]";
    private static final String LAB_TEMPLATE = "//span[contains(@class,'ag-cell-wrapper')][.//app-lab-name-grouped-cell-renderer/span[.='%s']]";
    private static final String LAB_EXPANDED_TEMPLATE = LAB_TEMPLATE + "//span[@class='ag-group-contracted']";
    private static final String LAB_LABEL_TEMPLATE = LAB_TEMPLATE + "//abbr[.='%s']";

    private final WebElement horizontalScrollBar = AqualityServices.getBrowser().getDriver().findElement(
            By.className("ag-body-horizontal-scroll-viewport"));

    public AGGridLabSummaryForm() {
        super(By.id("labMappingResultsContainer"), "lab Mapping Results");
    }

    public boolean isLabDisplayed(Lab lab) {
        labelLargeSpinner.state().waitForNotDisplayed();
        List<IElement> labLink = getElementFactory().findElements(By.xpath
                (String.format(LAB_TEMPLATE, lab.getName())), ElementType.LINK);
        return labLink.size() > 0;
    }

    public void clickByExpandedLab(Lab lab) {
        ILink labLink = getElementFactory().getLink(By.xpath
                (String.format(LAB_EXPANDED_TEMPLATE, lab.getName())), lab.getName());
        labLink.clickAndWait();
    }

    @Override
    public String getFieldValue(FormFieldInterface field) {
        ITextBox textBox = getElementFactory().getTextBox(By.xpath(
                String.format(COLUMN_TEMPLATE, field.getLocator())), field.getFriendlyName());

        while (!textBox.state().isDisplayed()) {
            JavaScriptUtil.scrollHorizontalBarToRight(horizontalScrollBar);
        }
        return textBox.getText();
    }

    public boolean isLabelDisplayedForLab(String label, Lab lab) {
        List<IElement> labLabel = getElementFactory().findElements(By.xpath
                (String.format(LAB_LABEL_TEMPLATE, lab.getName(), label)), ElementType.LABEL);

        return labLabel.size() > 0;
    }

}
