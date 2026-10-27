package Steps;

import Screens.NdosiLoginScreen;
import Utils.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.OutputType;
import Screens.DashboardScreen;
import org.testng.Assert;


public class StepDef {

    NdosiLoginScreen ndosiLoginScreen;
    DashboardScreen dashboardScreen;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        AppiumDriverFactory.getIntstanceOfAppiumDriverFactory(System.getProperty("user.dir") + "/src/main/Apps/app-qa-release.apk");
        this.ndosiLoginScreen = new NdosiLoginScreen(AppiumDriverFactory.getDriver());
        this.dashboardScreen = new DashboardScreen(AppiumDriverFactory.getDriver());
        Thread.sleep(5000); // Wait for the app to load
    }

    @And("the user clicks burger menu")
    public void theUserClicksBurgerMenu() {
        ndosiLoginScreen.clickMainMenuButton();
    }

    @And("the user click login button")
    public void the_user_click_login_button() {
        ndosiLoginScreen.clickLoginSignUpButton();

    }

    @And("the user enters valid username (.*)$")
    public void the_user_enters_valid_username(String username) {
        ndosiLoginScreen.enterEmail(username);

    }

    @And("the user enters valid password (.*)$")
    public void the_user_enters_valid_password(String password) {
        ndosiLoginScreen.enterPassword(password);

    }

    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        ndosiLoginScreen.clickLoginButton();

    }
    @And("the user changes the year")
    public void Change_Year(){
        ndosiLoginScreen.ChangeYear();
    }

    @Then("the welcome message should be displayed")
    public void the_welcome_message_should_be_displayed() {

    }

    @And("the user clicks burger menu on the dashboard")
    public void the_user_clicks_burger_menu_on_the_dashboard() {
        dashboardScreen.clickBurgerMenu();
    }

    @And("the user clicks logout")
    public void the_user_clicks_logout() {
        dashboardScreen.clickLogout();
    }


        Assert.assertTrue(
                ndosiLoginScreen.isLoggedIn(),
                "Login failed: Admin Dashboard is not displayed"
        );


}
