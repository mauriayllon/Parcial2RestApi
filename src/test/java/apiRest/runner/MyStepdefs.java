package apiRest.runner;

import apiRest.configuration.Config;
import apiRest.factoryRequest.FactoryRequest;
import apiRest.factoryRequest.RequestInformation;
import apiRest.utilsJson.JsonHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;
import io.cucumber.java.en.Then;

public class MyStepdefs {
/*
    Response response;
    RequestInformation request = new RequestInformation();
    Map<String, String> data = new HashMap<>();

    @Given("I have access to Todo.ly")
    public void iHaveAccessToTodoLy() {
    }

    @When("I send a request {} to url {} with json")
    public void iSendARequestPOSTToUrlHttpTodoLyApiProjectsJsonWithJson(String requestMethod, String url, String body) {
        request.setAuthType(Config.AUTH_BASIC);
        request.setAuthValue(Config.AUTH_BASIC_VALUE);
        request.setUrl(replaceAllData(url));
        request.setBody(replaceAllData(body));
        response = FactoryRequest.make(requestMethod).send(request);
    }

    @Then("I expected response code {int}")
    public void iExpectedResponseCode(int expectedResponseCode) {
        response.then().
                statusCode(expectedResponseCode);
    }

    @And("I expected the response body")
    public void iExpectedTheResponseBody(String expectedResponseBody) {
        System.out.println(response.getBody().asString());
        Assert.assertTrue("ERROR! los json no son iguales", JsonHelper.areEqualJson(replaceAllData(expectedResponseBody), response.getBody().asString()));
    }

    @And("I get the property {} save on {}")
    public void iGetThePropertyIdSaveOnID_PROJECT(String property, String varName) {
        data.put(varName, response.then().extract().path(property) + "");
    }

    private String replaceAllData(String value) {

        for (String key : data.keySet()) {
            value = value.replace(key, data.get(key));
        }

        return value;
    }*/
}