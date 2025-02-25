package stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import controller.endpointController;
import org.json.simple.parser.ParseException;
import org.junit.Assert;


public class endpointSteps {

     endpointController EndpointController = new endpointController();
     private String content = new String();

    @When("I GET the jsonplaceholder End Point and I recieve {int} response")
    public void getJsonPlaceholder(int expectedCode) {
        content = EndpointController.getsResponseAsString();
        Assert.assertEquals(expectedCode, EndpointController.getsResponseWebsite());

    }

    @Then("userId is {int}, id is {int}, and title is not empty")
    public void useridIsIdIsAndTitleIsNotEmpty(int userId, int id) throws ParseException {
        Assert.assertTrue("Response contains expected results", EndpointController.verifyResponseIsCorrect(content, userId, id));

    }
}
