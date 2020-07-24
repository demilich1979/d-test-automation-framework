package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.pageobject.BaseForm;
import org.openqa.selenium.By;

public class HomePage extends BaseForm {

    private static final String TOOLS_LINK_TEMPLATE = "//div[@class='card-body pt-1_5'][./h2[contains(text(),'%s')]]//a";

    private final IButton startCollaborationBtn = getElementFactory().getButton(
            By.xpath("//a[contains(@class,'btn-collaboration')]"), "Start collaboration");

    public HomePage() {
        super(By.id("main"), "Home");
    }

    public void openTool(String tool) {
        ILink toolLink = getElementFactory().getLink(By.xpath(String.format(TOOLS_LINK_TEMPLATE, tool)), tool);
        toolLink.clickAndWait();
    }

    public void clickStartCollaboration(){
        startCollaborationBtn.clickAndWait();
    }
}
