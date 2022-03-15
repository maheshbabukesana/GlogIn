package StepDefinations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssureSteps {

    @Test
    public void getDetails(){
        given().when().get("https://reqres.in/api/users");

    }
}
