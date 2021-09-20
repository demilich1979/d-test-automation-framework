package diaceutics.cucumber.transformations;

import diaceutics.selenium.models.Lab;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTypeTransformations {

    @DataTableType
    public Lab getCreateLabInfo(Map<String, String> entry) {
        Lab createLabInfoModel = new Lab();
        createLabInfoModel.setName(entry.get("Name"));
        return createLabInfoModel;
    }
}
