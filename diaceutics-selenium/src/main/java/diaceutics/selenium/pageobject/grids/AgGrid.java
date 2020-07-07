package diaceutics.selenium.pageobject.grids;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class AgGrid extends BaseForm {

    private final List<IElement> columnLinks = getElementFactory().findElements(By.xpath
            ("//div[contains(@class,'ag-header-cell')]//span[@role='columnheader']"), ElementType.LINK);


    public AgGrid() {
        super(By.xpath("//div[@class='mainContentContainer']"), "AgGrid");
    }

    public List<String> getColumns() {
        List<String> columns = new ArrayList<>();
        columnLinks.forEach(option -> {
            columns.add(option.getText());
        });
        return columns;
    }

    public boolean isLabDisplayed(String labName) {
        List<IElement> labLink = getElementFactory().findElements(By.xpath
                (String.format("//app-lab-name-grouped-cell-renderer/span[.='%s']", labName)), ElementType.LINK);
        return labLink.size() > 0;
    }
}
