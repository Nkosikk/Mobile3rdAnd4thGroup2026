package Steps;

import Screens.NdosiLoginScreen;
import Utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;

public class StepDef {
    AppiumDriver driver;
    NdosiLoginScreen ndosiLoginScreen;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        AppiumDriverFactory.getIntstanceOfAppiumDriverFactory(System.getProperty("user.dir") + "/src/main/Apps/app-qa-release.apk");
        this.ndosiLoginScreen = new NdosiLoginScreen(AppiumDriverFactory.getDriver());
        Thread.sleep(5000); // Wait for the app to load
    }

    @And("the user click login button")
    public void the_user_click_login_button() {
        ndosiLoginScreen.clickMainMenuButton();

    }

    @And("the user enters valid username (.*)$")
    public void the_user_enters_valid_username(String username) {

    }

    @And("the user enters valid password (.*)$")
    public void the_user_enters_valid_password(String password) {

    }

    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {

    }

    @Then("the welcome message should be displayed")
    public void the_welcome_message_should_be_displayed() {

    }
}
