package test;

import baseUrl.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_2_POST_To_All_Products_List extends BaseUrl {

/*
API 2: POST To All Products List
API URL: https://automationexercise.com/api/productsList
Request Method: POST
Response Code: 405
Response Message: This request method is not supported.
 */

    @Test
    public void api1() {
        spec.pathParams("1", "api", "2","productsList");
        Response response = given().contentType(ContentType.JSON).spec(spec).post("/{1}/{2}");
       // response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);

        JsonPath actualData = response.jsonPath();
        Assert.assertEquals("This request method is not supported.", actualData.getString("message"));
        Assert.assertEquals("405", actualData.getString("responseCode"));
        System.out.println(actualData.getString("message"));
    }
}
