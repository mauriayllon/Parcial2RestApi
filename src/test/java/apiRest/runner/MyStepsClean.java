package apiRest.runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import apiRest.configuration.Config;
import apiRest.factoryRequest.FactoryRequest;
import apiRest.factoryRequest.RequestInformation;
import apiRest.utilsJson.JsonHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MyStepsClean {
    Response response;
    RequestInformation request = new RequestInformation();
    Map<String, String> data= new HashMap<>();
    String email;
    String password;

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
        Assert.assertTrue("ERROR! los json no son iguales" , JsonHelper.areEqualJson(replaceAllData(expectedResponseBody),response.getBody().asString()));

    }

    @And("I get the property {} save on {}")
    public void iGetThePropertyIdSaveOnID_PROJECT(String property, String varName) {
        data.put(varName,response.then().extract().path(property)+"");
    }

    @When("I send a delete request with {} to {}")
    public void iSendADeleteRequestWithTokenIDHeader(String tokenValue, String url) {
        response = given().header("Token", replaceAllData(tokenValue)).when().delete(url);
    }



    private String replaceAllData(String value){

        for (String key: data.keySet()) {
            value=value.replace(key,data.get(key));
        }

        return value;
    }

    @Given("I have access to Todo.ly with email {} and password {}")
    public void iHaveAccessToTodoLyWithEmailComAndPasswordPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @When("I send a request PUT to url {} with json and my new user")
    public void iSendARequestPUTToUrlHttpTodoLyApiUserJsonWithJsonAndMyNewUser(String url, String body) {
        response = given().auth().preemptive().basic(email, password).body(body).log().all().when().put(url);
        response.then().log().all();
    }
}