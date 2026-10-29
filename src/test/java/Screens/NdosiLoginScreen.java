package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NdosiLoginScreen {
    private AppiumDriver driver;


    public NdosiLoginScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button")
    WebElement mainMenuButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Login / Sign Up']")
    WebElement loginSignUpButton;

    @FindBy(xpath = "//android.widget.EditText[@hint='Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//android.widget.EditText[@text=\"2026\"]")
    WebElement yearField;

    @FindBy(xpath = "//android.widget.EditText[@hint='Password']")
    WebElement txtPassword;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Admin Dashboard\"]")
    WebElement adminLoginDashboard;

    public void clickMainMenuButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainMenuButton));
        mainMenuButton.click();
    }

    public void clickLoginSignUpButton() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"Login / Sign Up\"))"
        )).click();
    }

    public void enterEmail(String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(txtEmail));
        txtEmail.click();
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password) {
        txtPassword.click();
        txtPassword.sendKeys(password);
        driver.executeScript("mobile: hideKeyboard");
    }

    public void clickLoginButton() {
        btnLogin.click();
    }
    // Please remove the line with your name and task once completed

    public boolean isLoggedIn() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId("Admin Dashboard")
                    ));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    // ToDo - Ntakuseni to do method to click Burger Menu
    // ToDo - Lydia to click scroll down
    // ToDo - Agco is going to click admin panel
    // ToDO - Asiphe to click second bugger menu on admin dash
    // ToDo - Mbasa to click on groups
    // ToDo - Sherry to click on create new group
    // ToDo - Ennie to enter the group name
    // ToDo - Promise  to enter description
    // ToDo - Nandipha  to update the year to 2027

    public void ChangeYear() {
        yearField.click();
        yearField.sendKeys("2027");
    }

    public void verifyAdminSuccessfulLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(adminLoginDashboard));
        Assert.assertTrue(
                adminLoginDashboard.isDisplayed(),
                "Admin Login may have been Failed! Admin Dashboard was not displayed on the screen");

    }

    // ToDo - Zuzeka  to dismiss keyboard
    // ToDo - Mdu  to click create group
    // ToDo - Itumeleng  to verify that the group is created
    // ToDo - Rilinde  to do logout
    // ToDo - Sibusiso verify you are logged out
}
