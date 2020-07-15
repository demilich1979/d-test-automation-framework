package diaceutics.selenium.enums.pageFields;

public enum AddAnAssayPageFields implements FormFieldInterface {
    ASSAY_NAME("Assay name", "Assay name", "assayName", FieldType.TEXT),
    ASSAY_DESCRIPTION("Assay description",
            "Assay description",
            "assayDescription",
            FieldType.TEXT_AREA),

    ONTOLOGIES("Ontologies",
            "//div[./label[text()='Ontologies']]",
            "ontologies",
            FieldType.COMBOBOX_JS),

    SCORING_METHOD("Scoring method",
            "//div[./label[text()='Scoring method']]",
            "scoringMethod",
            FieldType.COMBOBOX_JS),

    SPECIMENS_TESTED("Specimens Tested",
            "//div[./label[text()='Specimens Tested']]",
            "specimensTested",
            FieldType.COMBOBOX_JS),

    DETECTS_GERM_LINE_SOMATIC_ALTERATIONS("Detects Germline/Somatic alterations",
            "//div[./label[text()='Detects Germline/Somatic alterations']]",
            "detectsGermLineSomaticAlterations",
            FieldType.COMBOBOX_JS),

    FDA_510K_APPROVED_KIT("FDA 510K APPROVED KIT",
            "FDA 510K APPROVED KIT",
            "fda510KApprovedKit",
            FieldType.CHECKBOX),

    LABORATORY_DEVELOPED_TEST("Laboratory Developed Test (LDT)",
            "Laboratory Developed Test (LDT)",
            "laboratoryDevelopedTest",
            FieldType.CHECKBOX),

    FDA_PMA_APPROVED_KIT("FDA PMA APPROVED KIT",
            "FDA PMA APPROVED KIT",
            "fdaPmaApprovedKit",
            FieldType.CHECKBOX),

    IVD_CE("IVD-CE", "IVD-CE", "ivdCe", FieldType.CHECKBOX),
    RUO_IUO("RUO/IUO", "RUO/IUO", "ruoIuo", FieldType.CHECKBOX),
    TURN_AROUND_TIME("Turn around time (days)",
            "//ui-input[./label[text()='Turn around time (days)']]//input[@type='number']",
            "TurnAroundTime",
            FieldType.NUMBER),

    ASSOCIATED_DISEASES("Associated diseases",
            "//div[./label[text()='Associated diseases']]",
            "associatedDiseases",
            FieldType.COMBOBOX_JS),

    METHOD("Method", "//div[./label[text()='Method']]", "method", FieldType.COMBOBOX_JS),
    METHOD_DESCRIPTION("Method description",
            "Method description",
            "methodDescription",
            FieldType.TEXT_AREA),

    COMMERCIAL_ASSAYS("Commercial Assays",
            "//div[./label[text()='Commercial Assays']]",
            "commercialAssays",
            FieldType.COMBOBOX_JS),

    RESULT_FORMAT("Result Format",
            "//div[./label[text()='Result Format']]",
            "resultFormat",
            FieldType.COMBOBOX_JS),

    REPORT_SAMPLE_URL("Report sample URL", "Report sample URL", "reportSampleURL", FieldType.TEXT),
    SEND_OUT_OR_IN_HOUSE("Send-out or inhouse?",
            "//ui-radio-group[./label[.='Send-out or inhouse?']]",
            "sendOutOrInHouse",
            FieldType.RADIO),

    SEND_OUT_LAB("Send-out Lab",
            "//div[./label[text()='Send-out Lab']]",
            "sendOutLab",
            FieldType.COMBOBOX_JS),

    PANEL_NAME_RADIO("Panel name radio",
            "//ui-radio-group[@formcontrolname='includedInPanel']",
            "panelNameRadio",
            FieldType.RADIO),

    PANEL_NAME("Panel name", "Panel name", "panelName", FieldType.TEXT),
    ACCURACY("Accuracy",
            "//ui-input[./label[text()='Accuracy']]//input[@type='number']",
            "accuracy",
            FieldType.NUMBER),

    PRECISION("Precision",
            "//ui-input[./label[text()='Precision']]//input[@type='number']",
            "precision",
            FieldType.NUMBER),

    SENSITIVITY("Sensitivity",
            "//ui-input[./label[text()='Sensitivity']]//input[@type='number']",
            "sensitivity",
            FieldType.NUMBER),

    BATCH_OR_INDIVIDUAL("Batch or Individual?",
            "//ui-radio-group[./label[.='Batch or Individual?']]",
            "batchOrIndividual",
            FieldType.RADIO),

    VARIANTS_INCLUDED("Variants included?",
            "//ui-radio-group[./label[.='Variants included?']]",
            "variantsIncluded",
            FieldType.RADIO);

    private final String friendlyName;
    private final String locator;
    private final String modelField;
    private final FieldType fieldType;


    AddAnAssayPageFields(String friendlyName, String locator, String modelField, FieldType fieldType) {
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

    public static AddAnAssayPageFields getEnumValue(String friendlyName) {
        AddAnAssayPageFields addAnAssayPageFields = null;
        for (AddAnAssayPageFields constant : AddAnAssayPageFields.values()) {
            if (constant.getFriendlyName().equals(friendlyName)) {
                addAnAssayPageFields = constant;
                break;
            }
        }
        return addAnAssayPageFields;
    }
}
