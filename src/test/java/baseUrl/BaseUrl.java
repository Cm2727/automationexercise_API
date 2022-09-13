package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;

public class BaseUrl {
    protected RequestSpecification spec;

    @Before
    public void SetUp(){
        spec=new RequestSpecBuilder().setBaseUri("https://automationexercise.com").build();
    }

}
