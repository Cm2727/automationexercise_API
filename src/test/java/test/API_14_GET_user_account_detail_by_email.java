package test;

import baseUrl.BaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.AutomationExerciseTestData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;



public class API_14_GET_user_account_detail_by_email extends BaseUrl {

    /*
    API 14: GET user account detail by email
    API URL: https://automationexercise.com/api/getUserDetailByEmail
    Request Method: GET
    Request Parameters: email
    Response Code: 200
    Response JSON: User Detail
     */
   public static JsonPath actualDateMap;

    @Test
    public void test01() throws IOException {

        spec.pathParams("first", "api", "second", "getUserDetailByEmail");

        AutomationExerciseTestData dataKey = new AutomationExerciseTestData();// gerekli methodun cagrilmasi icin obje olusturuyoruz

        Map<String, Object> user = dataKey.userdate("mahmut", "mahmut@gmail.com", "Mr"); // ic map olusuturoyrz
        System.out.println("user = " + user);
        Map<String, Object> expectedData = dataKey.expectedDateMap(200, user);
        System.out.println("expectedData = " + expectedData);

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .formParams("email", "mahmut@gmail.com")
                .when()
                .get("/{first}/{second}");

        // response.jsonPath().prettyPrint();
        //response.then().assertThat().statusCode(200);

         ObjectMapper obj = new ObjectMapper();
        Map<String, Object> actualDateMap =obj.readValue(response.asString(),HashMap.class);

        //Map<String, Object> actualDateMap = response.as(HashMap.class);
        //actualDateMap= response.jsonPath();
       // System.out.println("actualDateMap = " + actualDateMap.getString("responseCode"));
        System.out.println("actualDateMap = " + actualDateMap);

        //Map<String, Object> actualDateMap = response.jsonPath(); //  De-Serialization ==> Json formatindan Java obj cevirme

        Assert.assertEquals(expectedData.get("responseCode"), actualDateMap.get("responseCode"));
        Assert.assertEquals(user.get("name"), ((Map) actualDateMap.get("user")).get("name"));
        Assert.assertEquals(user.get("email"), ((Map) actualDateMap.get("user")).get("email"));
        Assert.assertEquals(user.get("title"), ((Map) actualDateMap.get("user")).get("title"));



    }
}
