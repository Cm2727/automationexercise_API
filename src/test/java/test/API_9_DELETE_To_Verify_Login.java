package test;

import baseUrl.BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_9_DELETE_To_Verify_Login extends BaseUrl {
    /*
    API 9: DELETE To Verify Login
API URL: https://automationexercise.com/api/verifyLogin
Request Method: DELETE
Response Code: 405
Response Message: This request method is not supported.
     */

    @Test
    public void test01() {

        spec.pathParams("first", "api", "second", "verifyLogin");

        Response response = given().spec(spec).when().delete("/{first}/{second}");

        response.jsonPath().prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath actualData = response.jsonPath();

        Assert.assertEquals("This request method is not supported.", actualData.getString("message"));
        Assert.assertEquals("405", actualData.getString("responseCode"));



    }

}
