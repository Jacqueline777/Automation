package processes.SecureCitizen;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class GetRequests {
static String url ="http://demo.guru99.com/V4/sinkministatement.php";
    public static void getResponseBody() {


//        given(). -> No headers required, no query or path param.
//
//        when(). -> No specific condition setup
//
//        get(‘http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1‘). ->only the url needs to be supplied
//
//        then(). -> No specific assertions required
//
//        log(). all() -> Once all the response is fetched, log response, headers, essentially everything that the request returns to you.
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then().log()
                .all();

    }


    public static void getsimplifiedResponseBody() {
//        Note that we used body instead of all this helps us to extract only the body of the response.
        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get(url)
                .then()
                .log()
                .body();
    }

    public static void getResponseStatus(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get(url).then().assertThat().statusCode(200);
    }

//    Rest Assured is a very straightforward language, and fetching headers is just as simple.
//    The method name is headers(). Like before, we will create a standalone method to do the same.

    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                get(url).then().extract()
                        .headers());
    }

    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    public static void getResponseContentType(){
        System.out.println("The content type of response "+
                get(url).then().extract()
                        .contentType());
    }
    public static void getSpecificPartOfResponseBody(){

        ArrayList<String> amounts = when().get(url).then().extract().path("result.statements.AMOUNT") ;
        int sumOfAll=0;
        for(String a:amounts){

            System.out.println("The amount value fetched is "+a);
            sumOfAll=sumOfAll+Integer.valueOf(a);
        }
        System.out.println("The total amount is "+sumOfAll);

    }
}
