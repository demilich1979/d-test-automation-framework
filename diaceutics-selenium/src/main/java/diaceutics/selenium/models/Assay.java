package diaceutics.selenium.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Assay extends BaseModel {
    private String assayName;
    private String assayDescription;
    private String inHouseOrSendOut;
    private String sendOutLab;
    private String testingPurpose;
    private String detects;
    private String specimensTested;
    private String method;
    private String methodDescription;
    private String turnAroundTime;
    private String ontology;
    private String sensitivity;
    private String scoringMethod;
    private String resultFormat;
    private String classification;
    private String fda510KApprovedKit;
    private String fdaPmaApprovedKit;
    private String ivdCe;
    private String ruoIuo;
    private String commercialAssays;
    private List<Biomarker> biomarkers = new ArrayList<>();

    public void addBiomarker(Biomarker biomarker) {
        biomarkers.add(biomarker);
    }

    public String getClassifications() {
        List<String> classifications = new ArrayList<>();
        if (classification.equals("Commercial assay")) {

            if (getIvdCe().equals("true")) {
                classifications.add("IVD-CE");
            }
            if (getRuoIuo().equals("true")) {
                classifications.add("RUO/IUO");
            }
            if (getFda510KApprovedKit().equals("true")) {
                classifications.add("FDA 510K APPROVED KIT");
            }
            if (getFdaPmaApprovedKit().equals("true")) {
                classifications.add("FDA PMA APPROVED KIT");
            }

            return String.join(",", classifications).replaceAll(",", ", ");
        }

        return "Laboratory Developed Test (LDT)";
    }
}
