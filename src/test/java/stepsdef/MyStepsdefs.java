package stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.Messages;
import processes.Hooks;

//import static processes.SecureCitizen.CitizenVerifyIDLookupService.getsimplifiedResponseBody;
import static processes.SecureCitizen.CitizenVerifyIDLookupService.postrequest;

public class MyStepsdefs {


//    @Given("I access the endpoint {string}")
//    public void iAccessTheEndpoint(String endpoint) {
////        Hooks.storeendpoint(endpoint);
//
//        postrequest();
//    }

    @When("I send the request")
    public void iSendTheRequest() {

    }

    @And("my body should have the right response body")
    public void myBodyShouldHaveTheRightResponseBody() {
    }

    @Then("I should be able to get status code of {int}")
    public void iShouldBeAbleToGetStatusCodeOf(int statuscode) {

//        Hooks.sendrequests(statuscode);
    }

    @Given("I access the endpoint")
    public void iAccessTheEndpoint() {
        postrequest();
    }
}
