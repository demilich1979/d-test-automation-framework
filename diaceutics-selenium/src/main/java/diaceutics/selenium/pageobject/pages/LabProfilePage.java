package diaceutics.selenium.pageobject.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILink;
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

    private static final String SORT_COLUMN_BUTTON_TEMPLATE = "//th[.//span[.='%s']]//ui-icon";
    private static final String EDIT_BUTTON_TEMPLATE = "//td[./span[.='Edit']]//span";
    private static final String PLATFORM_TEMPLATE = "//tr[.//span[.='%s']and .//span[.='%s']]";
    private static final String ADD_BUTTON_TEMPLATE = "//div[contains(@class,'titleArea')]//button[.='%s']";
    private static final String EDIT_PLATFORM_BUTTON_TEMPLATE = PLATFORM_TEMPLATE + EDIT_BUTTON_TEMPLATE;
    private static final String DELETE_PLATFORM_BUTTON_TEMPLATE = PLATFORM_TEMPLATE + "//td[./span[.='Delete']]//span";
    private static final String VOLUME_TEMPLATE = "//tr[.//span[.='%s'] and .//span[.='%s'] and .//span[.='%s'] and .//span[.='%s']]";
    private static final String EDIT_VOLUME_BUTTON_TEMPLATE = VOLUME_TEMPLATE + EDIT_BUTTON_TEMPLATE;
    private static final String GRID_TEMPLATE = "//div[contains(@class,'dataTable')][.//h3[.='%s']]//ui-table//table[2]";
    private static final String ASSAY_TEMPLATE = "//tr[.//span[.='%s'] and .//span[.='%s'] and .//span[.='%s']]";

    private final ILink linkPlatformCount = getElementFactory().getLink(
            By.xpath("//h3[.='Platforms']/parent::div/span"), "Platform Count");

    private final ILink linkEditDetails = getElementFactory().getLink(
            By.xpath("//a//span[.='Edit Details']"), "Edit Details");

    private final ILink linkLabName = getElementFactory().getLink(
            By.xpath("//div[contains(@class,'titleArea')]//h1"), "Lab name");

    private final List<IElement> linksLabType = getElementFactory().findElements(By.xpath
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

    public void clickSortColumn(String column) {
        IButton btnSortColumn = getElementFactory().getButton(
                By.xpath(String.format(SORT_COLUMN_BUTTON_TEMPLATE, column)),
                String.format("Sort %s Column", column));
        btnSortColumn.clickAndWait();
    }

    public void clickEditPlatform(Platform platform) {
        IButton btnEditPlatform = getElementFactory().getButton(
                By.xpath(String.format(EDIT_PLATFORM_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Edit %s", platform.getPlatform()));

        btnEditPlatform.clickAndWait();
    }

    public void clickDeletePlatform(Platform platform) {
        IButton btnEdit = getElementFactory().getButton(
                By.xpath(String.format(DELETE_PLATFORM_BUTTON_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())),
                String.format("Delete %s", platform.getPlatform()));

        btnEdit.clickAndWait();
    }

    public boolean isPlatformAdded(Platform platform) {
        List<IElement> platformLink = getElementFactory().findElements(By.xpath
                (String.format(PLATFORM_TEMPLATE, platform.getPlatform(), platform.getPlatformManufacturer())), ElementType.LINK);

        return platformLink.size() > 0;
    }

    public boolean isDataInColumnInGridSorted(String column, String gridName) {
        return new Grid(String.format(GRID_TEMPLATE, gridName)).isDataInColumnSorted(column);
    }

    public String getNumberOfPlatformsFromHead() {
        return RegExUtil.regexGetMatchGroup(linkPlatformCount.getText(), "[-]?[0-9]+(.[0-9]+)?", 0);
    }

    public String getNumberOfRowsInGrid(String gridName) {
        Grid platformsGrid = new Grid(String.format(GRID_TEMPLATE, gridName));
        return String.valueOf(platformsGrid.getNumberOfRowsInGrid());
    }

    public void clickEditDetails() {
        linkEditDetails.clickAndWait();
    }

    public String getLabNameFromPage() {
        return linkLabName.getText();
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

    public void clickAdd(String buttonName) {
        IButton btnAdd = getElementFactory().getButton(
                By.xpath(String.format(ADD_BUTTON_TEMPLATE, buttonName)), buttonName);

        btnAdd.clickAndWait();
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
        IButton btnEditVolume = getElementFactory().getButton(
                By.xpath(String.format(
                        EDIT_VOLUME_BUTTON_TEMPLATE,
                        volume.getTimePeriod(),
                        volume.getBiomarker(),
                        volume.getDisease(),
                        volume.getVolume())),
                "Edit volume");

        btnEditVolume.clickAndWait();
    }

    public boolean isAssayAdded(Assay assay) {
        List<IElement> volumeLink = getElementFactory().findElements(By.xpath
                        (String.format(
                                ASSAY_TEMPLATE,
                                assay.getAssayName(),
                                assay.getClassifications(),
                                assay.getMethod())),
                ElementType.LINK);

        return volumeLink.size() > 0;
    }
}
