package diaceutics.selenium.pageobject.grids;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class Grid {
    private final String locator;

    public Grid(String locator) {
        this.locator = locator;
    }

    public List<String> getColumns() {
        List<IElement> columnLinks = getElementFactory().findElements(By.xpath
                (String.format("%s//th", locator)), ElementType.LINK);
        List<String> columns = new ArrayList<>();
        columnLinks.forEach(option -> {
            columns.add(option.getText());
        });
        return columns;
    }

    public List<String> getValuesFromColumn(String columnName) {
        List<IElement> valueLinks = getElementFactory().findElements(By.xpath
                (String.format("%s//td[count(//th[.='%s']/preceding-sibling::*)+1]", locator, columnName)), ElementType.LINK);
        List<String> values = new ArrayList<>();
        valueLinks.forEach(option -> {
            values.add(option.getText());
        });
        return values;
    }

    public boolean isValueExistInColumn(String value, String columnName) {
        return AqualityServices.getConditionalWait()
                .waitFor(() -> getValuesFromColumn(columnName).stream().anyMatch(option -> option.equals(value)));
    }

    public int getNumberOfRowsInGrid() {
        List<IElement> rowLinks = getElementFactory().findElements(By.xpath
                (String.format("%s//tr[not(th)]", locator)), ElementType.LINK);
        return rowLinks.size();
    }

    public boolean isDataInColumnSorted(String columnName) {
        List<String> tmp = getValuesFromColumn(columnName);
        Collections.sort(tmp);
        return getValuesFromColumn(columnName).equals(tmp);
    }
}
