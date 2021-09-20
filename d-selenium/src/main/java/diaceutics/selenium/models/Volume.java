package diaceutics.selenium.models;

import lombok.Data;

@Data
public class Volume extends BaseModel {
    private String timePeriod;
    private String timePeriodCombobox;
    private String timePeriodRadio;
    private String disease;
    private String biomarker;
    private String volume;

    public String getTimePeriod() {
        return String.format("%s-%s", timePeriodCombobox, timePeriodRadio);
    }
}
