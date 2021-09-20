package diaceutics.selenium.enums.pageFields;

public enum MarketplaceMainPageFields implements FormFieldInterface {

    ENTER_A_LOCATION("Enter a location", "location", "location", FieldType.TEXT),
    TYPE("Type", "type", "type", FieldType.COMBOBOX),
    KEYWORDS("Keywords", "keywords", "keywords", FieldType.TEXT),
    LABORATORY("Laboratory", "//label[@for='categories_2']", "laboratory", FieldType.CHECKBOX),
    PHARMACEUTICAL("Pharmaceutical", "//label[@for='categories_3']", "pharmaceutical", FieldType.CHECKBOX),
    DIAGNOSTIC("Diagnostic", "//label[@for='categories_4']", "diagnostic", FieldType.CHECKBOX);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;

    MarketplaceMainPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static MarketplaceMainPageFields getEnumValue(String friendlyName) {
        MarketplaceMainPageFields marketplaceMainPageFields = null;
        for (MarketplaceMainPageFields constant : MarketplaceMainPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                marketplaceMainPageFields = constant;
                break;
            }
        }
        return marketplaceMainPageFields;
    }
}
