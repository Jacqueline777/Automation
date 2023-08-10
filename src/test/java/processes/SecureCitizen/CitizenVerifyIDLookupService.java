package processes.SecureCitizen;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class CitizenVerifyIDLookupService {
static String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IkQ1M0NEOTRGOTAyMzIxQjY2QTk2NDcyRUZFMTQzMUJFIiwidHlwIjoiYXQrand0In0.eyJuYmYiOjE2OTAyNzc2MTAsImV4cCI6MTY5MDI4MTIxMCwiaXNzIjoiaHR0cHM6Ly9zdHMuc2VjdXJlY2l0aXplbi5jbG91ZCIsImF1ZCI6InNjLWNpdGl6ZW4iLCJjbGllbnRfaWQiOiI0MjIyNDdhMC0zNzU4LTQ3Y2QtYWZlOS02MmQ2ZGQwZDMxOTYiLCJjbGllbnRfc2FmcHNfcmVkdWN0aW9uIjoicmVkdWNlIiwic3ViIjoiYzllYzRiMmYtZjc5MC00MDEzLWI4NGItMmU5OGMwZmFkYmZlIiwiYXV0aF90aW1lIjoxNjkwMjc3NjEwLCJpZHAiOiJsb2NhbCIsInNlY3RvciI6IkRpZ2l0YWwgVGVjaG5vbG9neSBTb2x1dGlvbnMiLCJncm91cCI6IklNU1ZlbnR1cmVzIiwicm9sZSI6WyJDSVBDQWNjZXNzIiwiQ2l0aXplbkFjY2VzcyIsIkN1c3RvbUNsaWVudDFJbnRlZ3JhdGlvbkFjY2VzcyJdLCJuYW1lIjoiSU1TVmVudHVyZXMiLCJlbWFpbCI6IklNU1ZlbnR1cmVzQHNlY3VyZWNpdGl6ZW4uY28uemEiLCJqdGkiOiJERDg1QjExMDMxNkFGRUQ2MjRBOEEzNDkzODIwM0EyQiIsImlhdCI6MTY5MDI3NzYxMCwic2NvcGUiOlsic2MtY2l0aXplbiJdLCJhbXIiOlsicHdkIl19.AsmS74Yn8Lk5hr50JrMXZj9iTTpA7dlNKAQCqkKp2_IUJDomk3xBXsK0TYkFw85t-q-wbfN4VK7nC9TQQyLLYBryR3HW4HrKLR8-SughtxWFu1JeamMfXFtzhUwI1jY0FXjbWuXSYfMzdfi_lJPdptkpUqQu84ePmzUHKKKR7bUvvEbliXO61ts7vLvHYsTST1X4sbCQcNhC68xvPgutmjp1TBm_Udh0OimgvT83cxNl1TWBgR3MLFkBLZQMpSWuYcYfF15W4ABgxX_wmX_XL0nwLsWPf7J2oxL8dHiAblSEyPPamQstpwC3h18Hq6xNL7tvVZ4B4n0nRq1z8VAKlw";
    static String url ="http://demo.guru99.com/V4/sinkministatement.php";
static RequestSpecification request;
    public static void initialize() {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
         request = RestAssured.given();



    }

    public static void getresponse(){

        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString()); // Post the request and check the response
        Response response = request.post("/BookStoreV1BooksPost");
        System.out.println("The status received: " + response.statusLine());
    }




//        given()
//                .auth().preemptive().oauth2(accessToken)
//
//        or use
//        given().
//                filter((requestSpec, responseSpec, ctx) -> {
//                    requestSpec.header("AUTH", "TOKEN");
//                    return ctx.next(requestSpec, responseSpec);
//                }).
//                when().

        //Verify status
//        post("/api").then().assertThat().statusCode(200).
//                post("/api").then().assertThat().statusLine(containsString("OK")). ..
//
////Verify headers
//        post("/api").then().assertThat().header("headerName", "headerValue"). ..
//        post("/api").then().assertThat().headers("headerName1", containsString("value")). .

//Verify body
//        https://howtodoinjava.com/java/library/rest-assured-http-post-and-put-examples/
//        given()
//                .body(requestParams.toString())
//    ...
//.when()

//        InputStream stream = post("/api").asInputStream();
//        byte[] byteArray = post("/api").asByteArray();
//        String json = post("/api").asString();
//
//        String id = given()
//        ...
//        .post("/users")
//                .then()
//        ...
//        .extract().body().path("user.id");
//                .post("/users")
//                .then()
//    ...
//    .body("id", notNullValue())
//                .body("name", equalTo("lokesh"))
//                .body("gender", equalTo("male"))
//                .body("status", equalTo("active"))
//                .body("email", equalTo("admin@howtodoinjava.com"))
//    ...;
//
////Verify response time
//
//        post("/api").then().time(lessThan(2000L));
//        post("/api").then().time(lessThan(2L), TimeUnit.SECONDS);

    public static void postrequest(){
        JSONObject requestParams = new JSONObject();
//        requestParams.put("name", "lokesh");
//        requestParams.put("email", "admin@howtodoinjava.com");
        requestParams.put("IdNumber", "8210245022089");
        requestParams.put("SCConsentReceived", true);
        requestParams.put("CRef", "422247a0-3758-47cd-afe9-62d6dd0d3196");
        requestParams.put(  "ConsentReceived", true);
        requestParams.put( "IdentityCache", false);
        requestParams.put( "MobileNumber","+277725");
        requestParams.put( "EmailAddress", "jkamadi@imsglo");
        given()
                .body(requestParams.toString())
                .contentType("application/json")
                .accept("text/plain")
                .header("Authorization", "Bearer " + token)
//                .auth().preemptive().oauth2("eyJhbGciOiJSUzI1NiIsImtpZCI6IkQ1M0NEOTRGOTAyMzIxQjY2QTk2NDcyRUZFMTQzMUJFIiwidHlwIjoiYXQrand0In0.eyJuYmYiOjE2ODkyNDQ2NTYsImV4cCI6MTY4OTI0ODI1NiwiaXNzIjoiaHR0cHM6Ly9zdHMuc2VjdXJlY2l0aXplbi5jbG91ZCIsImF1ZCI6InNjLWNpdGl6ZW4iLCJjbGllbnRfaWQiOiI0MjIyNDdhMC0zNzU4LTQ3Y2QtYWZlOS02MmQ2ZGQwZDMxOTYiLCJjbGllbnRfc2FmcHNfcmVkdWN0aW9uIjoicmVkdWNlIiwic3ViIjoiYzllYzRiMmYtZjc5MC00MDEzLWI4NGItMmU5OGMwZmFkYmZlIiwiYXV0aF90aW1lIjoxNjg5MjQ0NjU2LCJpZHAiOiJsb2NhbCIsInNlY3RvciI6IkRpZ2l0YWwgVGVjaG5vbG9neSBTb2x1dGlvbnMiLCJncm91cCI6IklNU1ZlbnR1cmVzIiwicm9sZSI6WyJDSVBDQWNjZXNzIiwiQ2l0aXplbkFjY2VzcyIsIkN1c3RvbUNsaWVudDFJbnRlZ3JhdGlvbkFjY2VzcyJdLCJuYW1lIjoiSU1TVmVudHVyZXMiLCJlbWFpbCI6IklNU1ZlbnR1cmVzQHNlY3VyZWNpdGl6ZW4uY28uemEiLCJqdGkiOiIwRTU5N0Y3RTBFQ0M4QUZDMEE4QkI3OUY3QTJDQjU4MSIsImlhdCI6MTY4OTI0NDY1Niwic2NvcGUiOlsic2MtY2l0aXplbiJdLCJhbXIiOlsicHdkIl19.HeEJ9Mjtzba1fDrX9pX3V45TU1YmKlDsPtPETWx_j5C5uZqUpxfBjhBi1vo__xBQvS8w7Ir-Qx92lYgR5gtw6mxiOLA9c2k7-vddexvGnpb5IsYvf3LtbProeqfi765s86vNvBx4n0CZse9xc5zWF38YABDQ1TMyLCDnC3yPIABPtMcB9RHFVGRydmq0xwaff3JpZPkFKKiaYnpTVZKhlXjGm0X8SCZySeaw-ks72HcOrjNFxVPdOoMSnggRUgGyyEcv43tOm49eWrmlpP8R2z4ajyifnCVtXZwA4UXV48O_vFLPKnkuHRWK7NnMIbKWMRqs6ql0xe8ebr8LEe7Hrg")
                .when()
                .post("https://citizenapi.securecitizen.cloud/Citizen/LookupIDNumber")
                .then()
                .assertThat().statusCode(200);
//                .statusCode(201);
//                .body("id", notNullValue())
//                .body("name", equalTo("lokesh"))
//                .body("email", equalTo("admin@howtodoinjava.com"));
    }

}
