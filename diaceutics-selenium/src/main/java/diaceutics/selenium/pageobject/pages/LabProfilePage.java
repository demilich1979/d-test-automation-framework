package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.ConfirmForm;
import diaceutics.selenium.pageobject.forms.EditPlatformForm;
import diaceutics.selenium.pageobject.grids.Grid;
import diaceutics.selenium.pageobject.forms.AddPlatformForm;
import diaceutics.selenium.models.Platform;
import diaceutics.selenium.utilities.RegExUtil;
import org.openqa.selenium.By;

import java.util.List;

public class LabProfilePage extends BaseForm {

    private static final String SORT_COLUMN_BUTTON_TEMPLATE = "//th[.//span[.='%s']]//ui-icon";
    private static final String EDIT_BUTTON_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]//td[./span[.='Edit']]//span";
    private static final String DELETE_BUTTON_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]//td[./span[.='Delete']]//span";
    private static final String PLATFORM_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]";

    private final IButton btnAddPlatform = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'titleArea')]//button[.='Add platform']"), "Add platform");

    private final ILink linkPlatformCount = getElementFactory().getLink(
            By.xpath("//h3[.='Platforms']/parent::div/span"), "Platform Count");

    private final ILink linkEditDetails = getElementFactory().getLink(
            By.xpath("//a//span[.='Edit Details']"), "Edit Details");

    private final ILink linkLabName = getElementFactory().getLink(
            By.xpath("//div[contains(@class,'titleArea')]//h1"), "Lab name");

    private final ILink linkLabType = getElementFactory().getLink(
            By.xpath("//div[contains(@class,'details')]//span[contains(@class,'ng-star-inserted')][1]"), "Lab type");

    List<IElement> linksLabType = getElementFactory().findElements(By.xpath
            ("//div[contains(@class,'details')]//span[contains(@class,'ng-star-inserted')]"), ElementType.LINK);

    private final Grid platformsGrid = new Grid(
            "//div[@class='dataTable'][.//h3[.='Platforms']]//ui-table//table[2]",
            "Platform manufacturer",
            "Platform equipment");

    public LabProfilePage() {
        super(By.id("viewLabContainer"), "LabProfile");
    }

    public AddPlatformForm getAddPlatformForm() {
        return new AddPlatformForm();
    }

    public EditPlatformForm getEditPlatformForm() {
        return new EditPlatformForm();
    }

    public ConfirmForm getConfirmForm() {
        return new ConfirmForm();
    }

    public void clickAddPlatform() {
        btnAddPlatform.clickAndWait();
    }

    public void clickSortColumn(String column) {
        IButton btnSortColumn = getElementFactory().getButton(
                By.xpath(String.format(SORT_COLUMN_BUTTON_TEMPLATE, column)),
                String.format("Sort %s Column", column));
        btnSortColumn.clickAndWait();
    }

    public void clickEditPlatform(Platform platform) {
        IButton btnEdit = getElementFactory().getButton(
                By.xpath(String.format(EDIT_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Edit %s", "platform.getPlatform()"));

        btnEdit.clickAndWait();
    }

    public void clickDeletePlatform(Platform platform) {
        IButton btnEdit = getElementFactory().getButton(
                By.xpath(String.format(DELETE_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Delete %s", platform.getPlatform()));

        btnEdit.clickAndWait();
    }

    public boolean isPlatformAdded(Platform platform) {
        List<IElement> platformLink = getElementFactory().findElements(By.xpath
                (String.format(PLATFORM_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())), ElementType.LINK);

        return platformLink.size() > 0;
    }

    public boolean isDataInColumnInPlatformGridSorted(String column) {
        return platformsGrid.isDataInColumnSorted(column);
    }

    public String getNumberOfPlatformsFromHead() {
        return RegExUtil.regexGetMatchGroup(linkPlatformCount.getText(), "[-]?[0-9]+(.[0-9]+)?", 0);
    }

    public String getNumberOfPlatformsFromGrid() {
        return String.valueOf(platformsGrid.getNumberOfRowsInColumns(platformsGrid.getColumns().get(0)));
    }

    public void clickEditDetails() {
        linkEditDetails.clickAndWait();
    }

    public String getLabNameFromPage() {
        String name=linkLabName.getText();
        return name;
    }

    public String getLabTypeFromPage() {
        String labType = "Unspecified";
        if (linksLabType.size() > 1) {
            labType = RegExUtil.regexGetMatchGroup(linksLabType.get(0).getText(), "\\((.*?)\\)", 1) + " Lab";
        }
        return labType;
    }


    public boolean isLabDisplayedOnPage(Lab lab) {
        boolean isLabDisplayed = false;
        if (lab.getName().equals(getLabNameFromPage()) &&
                lab.getLabType().equals(getLabTypeFromPage())) {
            isLabDisplayed = true;
        }

        return isLabDisplayed;
    }
}
