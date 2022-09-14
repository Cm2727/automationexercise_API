package test;

import baseUrl.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_4_PUT_To_All_Brands_List extends BaseUrl {

/*
API 4: PUT To All Brands List
API URL: https://automationexercise.com/api/brandsList
Request Method: PUT
Response Code: 405
Response Message: This request method is not supported.
 */
@Test
public void test01() {
    spec.pathParams("first", "api", "second", "brandsList");

    spec.pathParams("first","api","second","brandsList");


    Response response=given().spec(spec).accept(ContentType.JSON).when().put("/{first}/{second}");

    JsonPath actualData = response.jsonPath();

    Assert.assertEquals("This request method is not supported.", actualData.getString("message"));
    Assert.assertEquals("405", actualData.getString("responseCode"));
    System.out.println(actualData.getString("message"));


}
}
