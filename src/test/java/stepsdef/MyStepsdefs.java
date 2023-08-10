package stepsdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static processes.Process.*;

public class MyStepsdefs {


    @Then("I should be able to get status code of {int} from create employee post request with {int} {string} {string} {string}")
    public void iShouldBeAbleToGetStatusCodeOfFromCreateEmployeePostRequestWith(int statuscode,int id, String name, String email, String title) {
        createnewemployee(statuscode,id,name,email,title);

    }

    @Then("I should be able to get status code of {int} from get employee get request")
    public void iShouldBeAbleToGetStatusCodeOfFromGetEmployeeGetRequest(int statuscode) {
        getemployees(statuscode);
    }

    @Then("I should be able to get status code of {int} from get employee number {int}")
    public void iShouldBeAbleToGetStatusCodeOfFromGetEmployeeNumber(int statuscode, int employeeid) {
        getspecificemployee(statuscode,employeeid);
    }

    @Given("I access the endpoint")
    public void iAccessTheEndpoint() {
    }

    @When("I send the request")
    public void iSendTheRequest() {
    }
}
