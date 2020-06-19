package diaceutics.selenium.forms.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import diaceutics.selenium.forms.ConfirmForm;
import diaceutics.selenium.forms.EditPlatformForm;
import diaceutics.selenium.grids.Grid;
import diaceutics.selenium.forms.AddPlatformForm;
import diaceutics.selenium.models.Platform;
import diaceutics.selenium.utilities.RegExUtil;
import org.openqa.selenium.By;

public class LabProfilePage extends Form {
    private static final String SORT_COLUMN_BUTTON_TEMPLATE = "//th[.//span[.='%s']]//ui-icon";
    private static final String EDIT_BUTTON_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]//td[./span[.='Edit']]//span";
    private static final String DELETE_BUTTON_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]//td[./span[.='Delete']]//span";
    private static final String PLATFORM_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]";

    private final IButton btnAddPlatform = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'titleArea')]//button[.='Add platform']"), "Add platform");

    private final ILink linkPlatformCount = getElementFactory().getLink(
            By.xpath("//h3[.='Platforms']/parent::div/span"), "Platform Count");

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
        boolean isPlatformAdded = false;
        if (platformsGrid.isValueExistInColumn(platform.getPlatformManufacturer(), platformsGrid.getColumns().get(0))
                && platformsGrid.isValueExistInColumn(platform.getPlatform(), platformsGrid.getColumns().get(1))) {
            isPlatformAdded = true;
        }

        return isPlatformAdded;
    }

    public boolean isPlatformExist(Platform platform) {
        ILink platformLink = getElementFactory().getLink(
                By.xpath(String.format(PLATFORM_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Platform %s", platform.getPlatform()));

        return platformLink.state().waitForDisplayed();
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
}
