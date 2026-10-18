package Screens;

import io.appium.java_client.AppiumDriver;
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

    public void clickMainMenuButton() {
        mainMenuButton.click();
    }

    public void clickLoginSignUpButton() {
        loginSignUpButton.click();
    }
}
