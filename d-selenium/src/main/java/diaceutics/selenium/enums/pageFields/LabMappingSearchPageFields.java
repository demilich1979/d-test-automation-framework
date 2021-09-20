package diaceutics.selenium.enums.pageFields;

public enum LabMappingSearchPageFields implements FormFieldInterface {
    COUNTRY("Country", "//div[./label[text()='Country']]", "country", FieldType.COMBOBOX_JS),
    DISEASE("Disease", "//div[./label[text()='Disease']]", "associatedDiseases", FieldType.COMBOBOX_JS),
    BIOMARKER_ANALOGUE("Biomarker / Analogue",
            "//div[./label[text()='Biomarker / Analogue']]",
            "biomarker",
            FieldType.COMBOBOX_JS),

    YEAR_FROM("Year From", "//div[./label[text()='Year From']]", "yearFrom", FieldType.COMBOBOX_JS),
    MONTH_FROM("Month From", "//div[./label[text()='Month From']]", "monthFrom", FieldType.COMBOBOX_JS),
    YEAR_TO("Year To", "//div[./label[text()='Year To']]", "yearTo", FieldType.COMBOBOX_JS),
    MONTH_TO("Month To", "//div[./label[text()='Month To']]", "monthTo", FieldType.COMBOBOX_JS);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    LabMappingSearchPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static LabMappingSearchPageFields getEnumValue(String friendlyName) {
        LabMappingSearchPageFields labMappingSearchPageFields = null;
        for (LabMappingSearchPageFields constant : LabMappingSearchPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                labMappingSearchPageFields = constant;
                break;
            }
        }
        return labMappingSearchPageFields;
    }
}
