package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import diaceutics.selenium.models.Assay;
import diaceutics.selenium.models.Lab;
import diaceutics.selenium.models.Volume;
import diaceutics.selenium.pageobject.BaseForm;
import diaceutics.selenium.pageobject.forms.*;
import diaceutics.selenium.pageobject.grids.Grid;
import diaceutics.selenium.models.Platform;
import diaceutics.selenium.utilities.RegExUtil;
import org.openqa.selenium.By;

import java.util.List;

public class LabProfilePage extends BaseForm {

    private static final String EDIT_BUTTON_TEMPLATE = "//td[./span[.='Edit']]//span";
    private static final String PLATFORM_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]";
    private static final String ADD_BUTTON_TEMPLATE = "//div[contains(@class,'titleArea')]//button[.='%s']";
    private static final String EDIT_PLATFORM_BUTTON_TEMPLATE = PLATFORM_TEMPLATE + EDIT_BUTTON_TEMPLATE;
    private static final String DELETE_PLATFORM_BUTTON_TEMPLATE = PLATFORM_TEMPLATE + "//td[./span[.='Delete']]//span";
    private static final String VOLUME_TEMPLATE = "//tr[.//span[.='%s'] and .//span[.='%s'] and .//span[.='%s'] and .//span[.='%s']]";
    private static final String EDIT_VOLUME_BUTTON_TEMPLATE = VOLUME_TEMPLATE + EDIT_BUTTON_TEMPLATE;
    private static final String GRID_TEMPLATE = "//div[contains(@class,'dataTable')][.//h3[.='%s']]//ui-table//table[2]";
    private static final String ASSAY_TEMPLATE = "//tr[.//span[.='%s'] and .//span[.='%s'] and .//span[.='%s']]";
    private static final String ASSAY_NAME_TEMPLATE = "//tr[.//span[.='%s']]//td[count(//th[.='Assay name']/preceding-sibling::*)+1]/span";
    private static final String SORT_COLUMN_BUTTON_TEMPLATE = GRID_TEMPLATE + "//th[.//span[.='%s']]//ui-icon";
    private static final String ROW_COUNT_TEMPLATE = "//h3[.='%s']/parent::div/span";

    private final ILink editDetailsLink = getElementFactory().getLink(
            By.xpath("//a//span[.='Edit Details']"), "Edit Details");

    private final ILink labNameLink = getElementFactory().getLink(
            By.xpath("//div[contains(@class,'titleArea')]//h1"), "Lab name");

    private final ILink labUrlLink = getElementFactory().getLink(
            By.xpath("//a[.//ui-icon[@name='external-link']]//span"), "Lab url");

    private final List<IElement> labTypeLink = getElementFactory().findElements(By.xpath
            ("//div[contains(@class,'details')]//span[contains(@class,'ng-star-inserted')]"), ElementType.LINK);

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

    public LocationsForm getLocationsForm() {
        return new LocationsForm();
    }

    public LogPatientVolumeForm getLogPatientVolumeForm() {
        return new LogPatientVolumeForm();
    }

    public EditPatientVolumeForm getEditPatientVolumeForm() {
        return new EditPatientVolumeForm();
    }

    public void clickSortColumnInGrid(String column, String gridName) {
        IButton sortColumnBtn = getElementFactory().getButton(
                By.xpath(String.format(SORT_COLUMN_BUTTON_TEMPLATE, gridName, column)),
                String.format("Sort %s Column", column));
        sortColumnBtn.clickAndWait();
    }

    public void clickEditPlatform(Platform platform) {
        IButton editPlatformBtn = getElementFactory().getButton(
                By.xpath(String.format(EDIT_PLATFORM_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Edit %s", platform.getPlatform()));

        editPlatformBtn.clickAndWait();
    }

    public void clickDeletePlatform(Platform platform) {
        IButton editBtn = getElementFactory().getButton(
                By.xpath(String.format(DELETE_PLATFORM_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Delete %s", platform.getPlatform()));

        editBtn.clickAndWait();
    }

    public boolean isPlatformAdded(Platform platform) {
        List<IElement> platformLink = getElementFactory().findElements(By.xpath
                (String.format(PLATFORM_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())), ElementType.LINK);

        return platformLink.size() > 0;
    }

    public boolean isDataInColumnInGridSorted(String column, String gridName) {
        return new Grid(String.format(GRID_TEMPLATE, gridName)).isDataInColumnSorted(column);
    }

    public String getNumberOfRowsFromGridHead(String gridName) {
        ILink rowCountLink = getElementFactory().getLink(
                By.xpath(String.format(ROW_COUNT_TEMPLATE, gridName)),
                String.format("Row count for %s", gridName));

        return RegExUtil.regexGetMatchGroup(rowCountLink.getText(), "[-]?[0-9]+(.[0-9]+)?", 0);
    }

    public String getNumberOfRowsInGrid(String gridName) {
        Grid platformsGrid = new Grid(String.format(GRID_TEMPLATE, gridName));
        return String.valueOf(platformsGrid.getNumberOfRowsInGrid());
    }

    public void clickEditDetails() {
        editDetailsLink.clickAndWait();
    }

    public String getLabNameFromPage() {
        return labNameLink.getText();
    }

    public String getLabTypeFromPage() {
        String labType = "Unspecified";
        if (labTypeLink.size() > 1) {
            labType = RegExUtil.regexGetMatchGroup(labTypeLink.get(0).getText(), "\\((.*?)\\)", 1) + " Lab";
        }
        return labType;
    }

    public String getLabUrlFromPage() {
        return labUrlLink.getText();
    }

    public Lab getLabFromPage() {
        Lab lab = new Lab();
        lab.setName(getLabNameFromPage());
        lab.setLabType(getLabTypeFromPage());
        lab.setUrl(getLabUrlFromPage());
        return lab;
    }

    public void clickAdd(String buttonName) {
        IButton addBtn = getElementFactory().getButton(
                By.xpath(String.format(ADD_BUTTON_TEMPLATE, buttonName)), buttonName);

        addBtn.clickAndWait();
    }

    public boolean isVolumeAdded(Volume volume) {
        List<IElement> volumeLink = getElementFactory().findElements(By.xpath
                        (String.format(
                                VOLUME_TEMPLATE,
                                volume.getTimePeriod(),
                                volume.getBiomarker(),
                                volume.getDisease(),
                                volume.getVolume())),
                ElementType.LINK);

        return volumeLink.size() > 0;
    }

    public void clickEditVolume(Volume volume) {
        IButton editVolumeBtn = getElementFactory().getButton(
                By.xpath(String.format(
                        EDIT_VOLUME_BUTTON_TEMPLATE,
                        volume.getTimePeriod(),
                        volume.getBiomarker(),
                        volume.getDisease(),
                        volume.getVolume())),
                "Edit volume");

        editVolumeBtn.clickAndWait();
    }

    public boolean isAssayAdded(Assay assay) {
        List<IElement> assayLink = getElementFactory().findElements(By.xpath
                        (String.format(
                                ASSAY_TEMPLATE,
                                assay.getAssayName(),
                                assay.getClassifications(),
                                assay.getMethod())),
                ElementType.LINK);

        return assayLink.size() > 0;
    }

    public void clickByAssay(Assay assay) {
        ILink assayLink = getElementFactory().getLink(
                By.xpath(String.format(ASSAY_NAME_TEMPLATE, assay.getAssayName())), assay.getAssayName());

        assayLink.clickAndWait();
    }

}
