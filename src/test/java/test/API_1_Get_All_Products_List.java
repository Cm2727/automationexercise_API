package test;

import baseUrl.BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_1_Get_All_Products_List extends BaseUrl {

 /*
    API 1: Get All Products List
API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list
     */

    @Test
    public void api1() {
        spec.pathParams("1", "api", "2","productsList");
        Response response = given().spec(spec).get("/{1}/{2}");
        response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
