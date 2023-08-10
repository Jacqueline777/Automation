package processes;
import io.cucumber.java.*;
import io.cucumber.plugin.event.*;
import io.cucumber.plugin.event.Status;
import io.restassured.RestAssured;
import org.apache.commons.lang3.StringUtils;
import processes.testrail.APIClient;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static processes.testrail.TestRailAccount.testRailApiClient;


import org.junit.rules.TestName;
import processes.testrail.APIException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Hooks{

    Result result ;
    Status status;
    Throwable error;
    String error_message;
    private static APIClient client = null;
    private static String runId = "5";
    private static final int FAIL_STATE = 5;
    private static final int SUCCESS_STATE = 1;
    private static final String SUCCESS_COMMENT = "This test passed with Selenium";

    String  FAILED_COMMENT="";


    //    @Rule
    static String   path = "C:\\Users\\Jacqueline.Kamadi\\Downloads\\APIs\\APIs\\src\\test\\java\\processes\\utils\\getPassProperties.properties";

    public TestName testName = new TestName();
//   static String
    public static void storeendpoint(String endpoint){

        FileOutputStream fileOut = null;
        FileInputStream fileIn = null;

        Properties configProperty = new Properties();

        File file = new File(path);
        try {
            fileIn = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            configProperty.load(fileIn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            configProperty.store(fileOut, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Properties file created......");
    }


    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
    public static void sendrequests(int statuscode) {
        Properties prop = new Properties();

        try {
            //load a properties file from class path, inside static method
            InputStream in = new FileInputStream(path);

            prop.load(in);
            //get the property value and print it out

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        RestAssured.baseURI =  prop.getProperty("endpoint");
        //obtain Response from GET request
        given()
                .when()
                .get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7")
                .then()
                .assertThat()
                .statusCode(statuscode);
    }

    @After
    public void tearDown(Scenario scenario) {
        Properties prop = null;
        try {
            prop = readPropertiesFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FAILED_COMMENT = prop.getProperty(scenario.getSourceTagNames().toString());
        logResultToTestRail(scenario);
    }


    private void logResultToTestRail(Scenario scenario) {
        String caseId = "";

        for (String s : scenario.getSourceTagNames()) {
            if (s.contains("TestRail")) {

                String[] res = s.split("(\\(.*?)");

                caseId = res[1].substring(0, res[1].length() - 1); // Removing the last parenthesis
            }
        }

        Map<String, Serializable> data = new HashMap<>();

        if (StringUtils.equalsIgnoreCase("passed", scenario.getStatus().toString())) {
            data.put("status_id", SUCCESS_STATE);
            data.put("comment", SUCCESS_COMMENT);

        } else if (StringUtils.equalsIgnoreCase("failed", scenario.getStatus().toString())) {
            data.put("status_id", FAIL_STATE);
            data.put("comment",FAILED_COMMENT);

        } else {
            data.put("status_id", FAIL_STATE);
            data.put("comment", FAILED_COMMENT);
        }

        if (!caseId.equals("")) {
            try {

                if (System.getenv("runIdTestRail") != null && System.getenv("runTestRailId").equals("")) {
                    runId = System.getenv("runIdTestRail");
                }

                client = testRailApiClient();
                client.sendPost("add_result_for_case/" + runId + "/" + caseId, data);
            } catch (IOException | APIException e) {
                e.printStackTrace();
            }
        }
    }



}