package diaceutics.selenium.enums.pageFields;

public enum DescriptionOfTheCollaborationPageFields implements FormFieldInterface {
    TITLE("TITLE", "new_listing__step_one_translations_en_title", "title", FieldType.TEXT),
    DESCRIPTION("Description",
            "new_listing__step_one_translations_en_description",
            "description",
            FieldType.TEXT),

    OTHER_REQUIREMENTS("Other requirements",
            "new_listing__step_one_translations_en_rules",
            "otherRequirements",
            FieldType.TEXT),

    TYPE("Type", "new_listing__step_one_categories", "type", FieldType.COMBOBOX),
    ENTER_A_YOUTUBE_URL("Enter a Youtube URL", "video-add-input", "youtubeUrl", FieldType.TEXT);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    DescriptionOfTheCollaborationPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static DescriptionOfTheCollaborationPageFields getEnumValue(String friendlyName) {
        DescriptionOfTheCollaborationPageFields descriptionOfTheCollaborationPageFields = null;
        for (DescriptionOfTheCollaborationPageFields constant : DescriptionOfTheCollaborationPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                descriptionOfTheCollaborationPageFields = constant;
                break;
            }
        }
        return descriptionOfTheCollaborationPageFields;
    }
}
