package processes;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class Process {

    static String employeesurl ="https://assessments.codescreen.com/api/employees";
    static String specificemployeeurl = "https://assessments.codescreen.com/api/employees/1234";
  static String posturl ="https://demoqa.com/BookStore/v1/Books";
  static String geturl ="http://demo.guru99.com/V4/sinkministatement.php";
    static RequestSpecification request;

    public static void createnewemployee(int statuscode, int id, String name,String email, String title){

        RestAssured.baseURI = employeesurl;
        request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", id);
        requestParams.put("name", name);
        requestParams.put("email", email);
        requestParams.put("title", title);
        request.header("X-API-KEY","fed9fd44-6eac-44c0-a676-83a9930cf394");
        // Add a header stating the Request body is a JSON
        given()

                .body(requestParams.toString())
                .contentType("application/json")
                .when()
                .post("/BookStoreV1BooksPost")
                .then()
                .statusCode(equalTo(statuscode));
    }


    public static void getemployees(int statuscode){
        given().
                header("X-API-KEY","fed9fd44-6eac-44c0-a676-83a9930cf394").
                when().get("https://assessments.codescreen.com/api/employees/1234").then().assertThat().statusCode(statuscode);

    }
    public static void getspecificemployee(int statuscode,int employeeid){
        given().
                header("X-API-KEY","fed9fd44-6eac-44c0-a676-83a9930cf394").
                when().get(specificemployeeurl+"/"+employeeid).then().assertThat().statusCode(statuscode);

    }
   public static void postrequest(int statuscode){

       RestAssured.baseURI = posturl;
       request = RestAssured.given();


        JSONObject requestParams = new JSONObject();
       requestParams.put("userId", "TQ123");
       requestParams.put("isbn", "9781449325862");
       // Add a header stating the Request body is a JSON

       given()
               .body(requestParams.toString())
               .contentType("application/json")
               .when()
               .post("/BookStoreV1BooksPost")
               .then()
               .statusCode(equalTo(statuscode));
    }
    public static void getrequest(int statuscode){


       //GET WITH PARAMETERS
//                given().queryParam("CUSTOMER_ID","68195")
//                .queryParam("PASSWORD","1234!")
//                .queryParam("Account_No","1")
//                .when()
//                .get(geturl).then().assertThat().statusCode(statuscode);


//        GET WITHOUT PARAMETERS
        given().
                header("X-API-KEY","fed9fd44-6eac-44c0-a676-83a9930cf394").
                when().get("https://assessments.codescreen.com/api/employees/1234").then().assertThat().statusCode(200);
    }
}
