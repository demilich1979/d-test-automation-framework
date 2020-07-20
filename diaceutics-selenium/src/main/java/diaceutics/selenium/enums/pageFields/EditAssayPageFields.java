package diaceutics.selenium.enums.pageFields;

public enum EditAssayPageFields implements FormFieldInterface {
    ASSAY_NAME("Assay name", "Assay name", "assayName", FieldType.TEXT),
    ASSAY_DESCRIPTION("Assay description",
            "Assay description",
            "assayDescription",
            FieldType.TEXT_AREA),

    IN_HOUSE_OR_SEND_OUT("Inhouse or send-out?",
            "//ui-radio-group[./label[.='Inhouse or send-out?']]",
            "inHouseOrSendOut",
            FieldType.RADIO),

    SEND_OUT_LAB("Send-out Lab",
            "//div[./label[text()='Send-out Lab']]",
            "sendOutLab",
            FieldType.COMBOBOX_JS),

    DETECTS("Detects",
            "//div[./label[text()='Detects']]",
            "detects",
            FieldType.COMBOBOX_JS),

    SPECIMENS_TESTED("Specimens Tested",
            "//div[./label[text()='Specimens tested']]",
            "specimensTested",
            FieldType.COMBOBOX_JS),

    METHOD("Method",
            "//div[./label[text()='Method']]",
            "method",
            FieldType.COMBOBOX_JS),

    METHOD_DESCRIPTION("Method description",
            "Method description",
            "methodDescription",
            FieldType.TEXT_AREA),

    TURN_AROUND_TIME("Turn around time (TaT)",
            "//ui-input[./label[text()='Turn around time (TaT)']]//input[@type='number']",
            "turnAroundTime",
            FieldType.NUMBER),

    ONTOLOGY("Ontology",
            "//div[./label[text()='Ontology']]",
            "ontology",
            FieldType.COMBOBOX_JS),

    SENSITIVITY("Sensitivity",
            "//ui-input[./label[text()='Sensitivity']]//input[@type='number']",
            "sensitivity",
            FieldType.NUMBER),

    SCORING_METHOD("Scoring method",
            "//div[./label[text()='Scoring method']]",
            "scoringMethod",
            FieldType.COMBOBOX_JS),

    RESULT_FORMAT("Result Format",
            "//div[./label[text()='Result Format']]",
            "resultFormat",
            FieldType.COMBOBOX_JS),

    CLASSIFICATION("Classification",
            "//ui-radio-group[./label[text()='Classification']]",
            "classification",
            FieldType.RADIO),

    FDA_510K_APPROVED_KIT("FDA 510K APPROVED KIT",
            "FDA 510K APPROVED KIT",
            "fda510KApprovedKit",
            FieldType.CHECKBOX),

    FDA_PMA_APPROVED_KIT("FDA PMA APPROVED KIT",
            "FDA PMA APPROVED KIT",
            "fdaPmaApprovedKit",
            FieldType.CHECKBOX),

    IVD_CE("IVD-CE", "IVD-CE", "ivdCe", FieldType.CHECKBOX),
    RUO_IUO("RUO/IUO", "RUO/IUO", "ruoIuo", FieldType.CHECKBOX),

    COMMERCIAL_ASSAYS("Commercial Assays",
            "//div[./label[text()='Commercial Assays']]",
            "commercialAssays",
            FieldType.COMBOBOX_JS);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    EditAssayPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static EditAssayPageFields getEnumValue(String friendlyName) {
        EditAssayPageFields editAssayPageFields = null;
        for (EditAssayPageFields constant : EditAssayPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                editAssayPageFields = constant;
                break;
            }
        }
        return editAssayPageFields;
    }
}
