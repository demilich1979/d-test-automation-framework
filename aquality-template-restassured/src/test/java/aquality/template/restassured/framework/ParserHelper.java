package aquality.template.restassured.framework;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/**
 * Created to help parsing responses
 */
public class ParserHelper {
    /**
     * Get xml param value by its name
     * @param xmlResponse response
     * @param paramPath path to param
     * @return param value
     */
    public static String getXmlParamValue(String xmlResponse, String paramPath){
        return new XmlPath(xmlResponse).get(paramPath);
    }

    /**
     * Get json param value by its name
     * @param jsonResponse response
     * @param paramPath path to param
     * @return param value
     */
    public String getJsonParamValue(String jsonResponse, String paramPath){
        return new JsonPath(jsonResponse).get(paramPath);
    }

    /**
     * Get html param value by its name
     * @param htmlResponse response
     * @param paramPath path to param
     * @return param value
     */
    public String getHtmlParamValue(String htmlResponse, String paramPath){
        return new XmlPath(XmlPath.CompatibilityMode.HTML, htmlResponse).getString(paramPath);
    }

    /**
     * Get single param value
     * @param response http response
     * @param paramPath path to param
     * @return value
     */
    public Object getSingleParamValue(Response response, String paramPath){
        return response.path(paramPath);
    }
}

