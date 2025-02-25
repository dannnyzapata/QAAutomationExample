package stepdefinition;

import controller.websiteController;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;


public class websiteSteps {
    WebDriver driver;
    websiteController controller = new websiteController(driver);

    @Given("I open demoqa website")
    public void launchWebsite(){
        controller.openWebsite();

    }

    @Then("I Verify I'm in the Mainscreen")
    public void iVerifyInTheMainscreen() {
        Assert.isTrue(controller.verifyMainScreen(),"demopa not displayed");

    }

    @When("I Close demoqa website")
    public void iCloseDemoqaWebsite() {
        controller.closeWebsite();
    }

    @When("I Click Elements")
    public void iClickElements() {
        controller.clickElements();
    }

    @When("I Click Text Box")
    public void iClickTextBox() {
        controller.clickTextBox();
    }

    @Then("I Verify I'm in the Text Box Screen")
    public void iVerifyIMInTheTextBoxScreen() {
        Assert.isTrue(controller.textBoxDisplayed(),"Text Box Screen is not Displayed");
    }

    @When("I fill information: {string}, {string}, {string} and {string}")
    public void iFillInformationAnd(String name, String email, String address, String permanentAddress) {
        controller.fillBoxes(name, email, address, permanentAddress);
    }

    @When("I Click Submit")
    public void iClickSubmit() {
        controller.clickSubmit();
    }

    @Then("The {string}, {string}, {string} and {string} are correct")
    public void theAndAreCorrect(String name, String email, String address, String permanentAddress) {
        Assert.isTrue(controller.infoRetrived(name,email,address,permanentAddress),
                "Information does not match submission");
    }
}
