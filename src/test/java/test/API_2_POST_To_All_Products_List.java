package test;

import baseUrl.BaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public void api1() throws IOException {
        spec.pathParams("1", "api", "2","productsList");
        Response response = given().contentType(ContentType.JSON).spec(spec).post("/{1}/{2}");
       // response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);

        ObjectMapper obj = new ObjectMapper();
        Map<String, Object> actualData =obj.readValue(response.asString(), HashMap.class);


      //  JsonPath actualData = response.jsonPath();
        System.out.println("actualData"+actualData);

        Assert.assertEquals("This request method is not supported.", actualData.get("message"));
        Assert.assertEquals(405, actualData.get("responseCode"));

    }
}
