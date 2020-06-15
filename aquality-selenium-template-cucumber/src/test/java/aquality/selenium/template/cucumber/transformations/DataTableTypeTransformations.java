package aquality.selenium.template.cucumber.transformations;

import aquality.selenium.template.models.CreateLabInfo;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTypeTransformations {

    @DataTableType
    public CreateLabInfo getCreateLabInfo(Map<String, String> entry) {
        CreateLabInfo createLabInfoModel = new CreateLabInfo();
        createLabInfoModel.setName(entry.get("Name"));
        return createLabInfoModel;
    }
}
