package diaceutics.selenium.enums.pageFields;

public enum LabsPageFields implements FormFieldInterface{
    COUNTRY("Country", "//div[./label[text()='Country']]", "country", FieldType.COMBOBOX_JS),
    LAB_TYPE("Lab type", "//ui-radio-group[./label[.='Lab type']]", "labType", FieldType.RADIO);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    LabsPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
        this.friendlyName = friendlyName;
        this.locator = locator;
        this.modelField = modelField;
        this.fieldType = fieldType;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getLocator() {
        return locator;
    }

    public String getModelField() {
        return modelField;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public static LabsPageFields getEnumValue(String friendlyName) {
        LabsPageFields labsPageFields = null;
        for (LabsPageFields constant : LabsPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                labsPageFields = constant;
                break;
            }
        }
        return labsPageFields;
    }
}
