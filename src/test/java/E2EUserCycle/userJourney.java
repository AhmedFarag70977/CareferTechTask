package E2EUserCycle;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;


public class userJourney {
    @Test(priority = 0)
    public void regNewUser(){
        File reqBody= new File("RegRequestBody.json");
        Response responseBody =
                given()
                        .contentType("application/json")
                        .header("Platform","careferProviderApplication2Ej!%")
                        .baseUri("https://provider.test.carefer.co/api/provider/")
                        .body(reqBody)
                        .when()
                        .post("v1/auth/register")

                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String actualResult = responseBody.asString();
        Assert.assertEquals(actualResult.contains("Success Register."),true);
        System.out.println("Registration :Actual Result is matching Expected Result: " + actualResult.contains("Success Register.") + "\n" + "Success Register.");
    }
    @Test(priority = 1)
    public void verifyRegUser(){
        File reqBody= new File("VerifyRequestBody.json");
        Response responseBody =
                given()
                        .contentType("application/json")
                        .header("Platform","careferProviderApplication2Ej!%")
                        .baseUri("https://provider.test.carefer.co/api/provider")
                        .body(reqBody)
                        .when()
                        .post("/v1/auth/verify")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .extract().response();
        String actualResult = responseBody.asString();
        Assert.assertEquals(actualResult.contains("Success verify."),true);
        System.out.println("Verification :Actual Result is matching Expected Result: " + actualResult.contains("Success verify.") + "\n" + "Success verify.");
    }

    @Test(priority = 2)
    public void verifyLogin(){
    File reqBody= new File("LoginRequestBody.json");
    Response responseBody =
            given()
                    .contentType("application/json")
                    .header("Platform","careferProviderApplication2Ej!%")
                    .baseUri("https://provider.test.carefer.co/api/provider")
                    .body(reqBody)
                    .when()
                    .post("/v1/auth/login")
                    .then()
                    .statusCode(200)
                    .log().body()
                    .extract().response();
    String actualResult = responseBody.asString();
    Assert.assertEquals(actualResult.contains("Success Login."),true);
    System.out.println("Login :Actual Result is matching Expected Result: " + actualResult.contains("Success Login.") + "\n" + "Success Login.");
}
}


