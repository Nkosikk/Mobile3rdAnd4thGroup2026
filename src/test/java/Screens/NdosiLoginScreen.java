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
        new WebDriverWait(driver, Duration.ofSeconds(10))
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
        driver.executeScript("mobile:hideKeyboard");

    }

    public void clickLoginButton() {
        btnLogin.click();


    }
}
