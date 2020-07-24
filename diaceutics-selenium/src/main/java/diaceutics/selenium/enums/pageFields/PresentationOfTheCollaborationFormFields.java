package diaceutics.selenium.enums.pageFields;

public enum PresentationOfTheCollaborationFormFields implements FormFieldInterface {
    TITLE("TITLE", "listing_translations_en_title", "title", FieldType.TEXT),
    DESCRIPTION("Description",
            "listing_translations_en_description",
            "description",
            FieldType.TEXT),

    OTHER_REQUIREMENTS("Other requirements",
            "listing_translations_en_rules",
            "otherRequirements",
            FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    PresentationOfTheCollaborationFormFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static PresentationOfTheCollaborationFormFields getEnumValue(String friendlyName) {
        PresentationOfTheCollaborationFormFields presentationOfTheCollaborationFormFields = null;
        for (PresentationOfTheCollaborationFormFields constant : PresentationOfTheCollaborationFormFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                presentationOfTheCollaborationFormFields = constant;
                break;
            }
        }
        return presentationOfTheCollaborationFormFields;
    }
}
