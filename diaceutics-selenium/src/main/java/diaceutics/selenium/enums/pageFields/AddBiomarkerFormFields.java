package diaceutics.selenium.enums.pageFields;

public enum AddBiomarkerFormFields implements FormFieldInterface {
    BIOMARKER("Biomarker",
            "//div[./label[text()='Biomarker']]",
            "biomarker",
            FieldType.COMBOBOX),

    SCORING_METHODOLOGIES("Scoring methodologies",
            "//div[./label[text()='Scoring methodologies']]",
            "scoringMethodologies",
            FieldType.COMBOBOX),

    VARIANTS("Variants",
            "//div[./label[text()='Variants']]",
            "variants",
            FieldType.COMBOBOX);


    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    AddBiomarkerFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static AddBiomarkerFormFields getEnumValue(String friendlyName) {
        AddBiomarkerFormFields addBiomarkerFormFields = null;
        for (AddBiomarkerFormFields constant : AddBiomarkerFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                addBiomarkerFormFields = constant;
                break;
            }
        }
        return addBiomarkerFormFields;
    }
}
