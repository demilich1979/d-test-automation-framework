package diaceutics.selenium.pageobject.pages;

import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class SearchResultsPage extends BaseForm {

    public SearchResultsPage() {
        super(By.xpath("//div[contains(@class,'is-collapsed')]"), "Search Results");
    }

}
