package test;

import baseUrl.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_5_POST_To_Search_Product extends BaseUrl {

    /*
    API 5: POST To Search Product
API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
Response JSON: Searched products list
     */

    @Test
    public void api1() {
        spec.pathParams("1", "api", "2","searchProduct");
        Response response = given()
                .spec(spec)
                .formParam("search_product","tshirt")
                .when()
                .post("/{1}/{2}");

        response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
