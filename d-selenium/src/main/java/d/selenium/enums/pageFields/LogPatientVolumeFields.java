package diaceutics.selenium.enums.pageFields;

public enum LogPatientVolumeFields implements FormFieldInterface {
    TIME_PERIOD_COMBOBOX("Time period combobox",
            "//app-volume-form[..//@label]//div[@class='timePeriod']",
            "timePeriodCombobox",
            FieldType.COMBOBOX_JS),

    TIME_PERIOD_RADIO("Time period radio",
            "//app-volume-form[..//@label]//div[@class='timePeriod']",
            "timePeriodRadio",
            FieldType.RADIO),

    DISEASE("Disease", "//div[./label[text()='Disease']]", "disease", FieldType.COMBOBOX_JS),
    BIOMARKER("Biomarker", "//div[./label[text()='Biomarker']]", "biomarker", FieldType.COMBOBOX_JS),
    VOLUME("Volume", "//div[@class='volume']//input[@type='number']", "volume", FieldType.NUMBER);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    LogPatientVolumeFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static LogPatientVolumeFields getEnumValue(String friendlyName) {
        LogPatientVolumeFields logPatientVolumeFields = null;
        for (LogPatientVolumeFields constant : LogPatientVolumeFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                logPatientVolumeFields = constant;
                break;
            }
        }
        return logPatientVolumeFields;
    }
}
