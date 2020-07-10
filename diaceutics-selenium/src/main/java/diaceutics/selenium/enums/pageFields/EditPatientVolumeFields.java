package diaceutics.selenium.enums.pageFields;

public enum EditPatientVolumeFields implements FormFieldInterface {
    DISEASE("Disease", "//div[./label[text()='Disease']]", "disease", FieldType.COMBOBOX_JS),
    BIOMARKER("Biomarker", "//div[./label[text()='Biomarker']]", "biomarker", FieldType.COMBOBOX_JS),
    VOLUME("Volume", "//div[@class='volume']//input[@type='number']", "volume", FieldType.NUMBER);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    EditPatientVolumeFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static EditPatientVolumeFields getEnumValue(String friendlyName) {
        EditPatientVolumeFields editPatientVolumeFields = null;
        for (EditPatientVolumeFields constant : EditPatientVolumeFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                editPatientVolumeFields = constant;
                break;
            }
        }
        return editPatientVolumeFields;
    }
}
