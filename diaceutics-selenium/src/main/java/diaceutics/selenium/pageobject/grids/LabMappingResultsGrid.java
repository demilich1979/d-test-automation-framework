package diaceutics.selenium.pageobject.grids;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import diaceutics.selenium.enums.pageFields.FormFieldInterface;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class LabMappingResultsGrid extends BaseForm {

    private static final String LAB_TEMPLATE =
            "//span[contains(@class,'ag-cell-wrapper')][.//app-lab-name-grouped-cell-renderer/span[.='%s']]//span[@class='ag-group-contracted']";

    private static final String COLUMN_TEMPLATE ="//div[@col-id='%s' and not(contains(@class,'ag-header-cell'))]";

    private final List<IElement> columnLinks = getElementFactory().findElements(By.xpath
            ("//div[contains(@class,'ag-header-cell')]//span[@role='columnheader']"), ElementType.LINK);

    public LabMappingResultsGrid() {
        super(By.id("labMappingResultsContainer"), "lab Mapping Results");
    }

    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        columnLinks.forEach(option -> {
            columns.add(option.getText());
        });
        return columns;
    }

    public boolean isLabDisplayed(String labName) {
        labelSmallSpinner.state().waitForNotDisplayed();
        List<IElement> labLink = getElementFactory().findElements(By.xpath
                (String.format(LAB_TEMPLATE, labName)), ElementType.LINK);
        return labLink.size() > 0;
    }

    public void clickByLab(Lab lab) {
        ILink labLink = getElementFactory().getLink(By.xpath
                (String.format(LAB_TEMPLATE, lab.getName())), lab.getName());
        labLink.clickAndWait();
    }

    public String getColumnValue(FormFieldInterface field) {
        AqualityServices.getBrowser().getDriver().executeScript("document.getElementsByClassName('ag-body-horizontal-scroll-viewport').scrollLeft += 250;");
        ITextBox textBox = getElementFactory().getTextBox(By.xpath(
                String.format(COLUMN_TEMPLATE,field.getLocator())), field.getFriendlyName());

        List<IElement> labLink = getElementFactory().findElements(By.xpath
                (String.format(COLUMN_TEMPLATE,field.getLocator())), ElementType.LINK);

        if (labLink.size()==0){
            WebElement chooseFile = AqualityServices.getBrowser().getDriver().findElement(
                    By.xpath("//div[@class='ag-body-horizontal-scroll']"));

            AqualityServices.getBrowser().getDriver().executeScript("arguments[0].scrollRight = 250;", chooseFile);


//            textBox.getJsActions().scrollIntoView();
        }
        return textBox.getText();
    }

}
