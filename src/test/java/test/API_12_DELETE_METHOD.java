package test;

import baseUrl.BaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_12_DELETE_METHOD extends BaseUrl {
    /*
    API 12: DELETE METHOD To Delete User Account
API URL: https://automationexercise.com/api/deleteAccount
Request Method: DELETE
Request Parameters: email, password
Response Code: 200
Response Message: Account deleted!
     */

    @Test
    public void test01() {
spec.pathParams("1","api","2","deleteAccount");

        Map<String, String> data =new HashMap<>();

        data.put("email", "mahmut@gmail.com");
        data.put("password", "1234");

        Response response=given().spec(spec).formParams(data).when().delete("/{1}/{2}");

        response.jsonPath().prettyPrint();

        response.then().assertThat().statusCode(200);

        JsonPath actuelData=response.jsonPath();
        Assert.assertEquals("Account deleted!",actuelData.getString("message"));
        Assert.assertEquals("200", actuelData.getString("responseCode"));

    }
}
