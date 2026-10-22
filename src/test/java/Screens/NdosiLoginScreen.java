package Screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        mainMenuButton.click();
    }

    public void clickLoginSignUpButton() {
        loginSignUpButton.click();
    }

    public void enterEmail(String email) {
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

    //ToDo - Hlayi to do the method to verify that we are loggedin
    // ToDo - Ntakuseni to do method to click Burger Menu
}
