package Screens;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//android.widget.EditText[@hint='Password']")
    WebElement txtPassword;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    WebElement btnLogin;

    public void clickMainMenuButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(mainMenuButton));
        mainMenuButton.click();
    }

    public void clickLoginSignUpButton() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(loginSignUpButton));
        loginSignUpButton.click();
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

    //ToDo - Hlayi to do the method to verify that we are loggedin
    // ToDo - Ntakuseni to do method to click Burger Menu
    // ToDo - Lydia to click scroll down
    // ToDo - Agco is going to click admin panel
    // ToDO - Asiphe to click second bugger menu on admin dash
    // ToDo - Mbasa to click on groups
    // ToDo - Sherry to click on create new group
    // ToDo - Ennie to enter the group name
    // ToDo - Promise  to enter description
    // ToDo - Nandipha  to update the year to 2027
    // ToDo - Zuzeka  to dismiss keyboard
    // ToDo - Mdu  to click create group
    // ToDo - Itumeleng  to verify that the group is created
    // ToDo - Rilinde  to do logout
    // ToDo - Sibusiso verify you are logged out
}
