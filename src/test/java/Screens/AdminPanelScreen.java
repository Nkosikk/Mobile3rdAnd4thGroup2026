package Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import io.appium.java_client.AppiumBy;

public class AdminPanelScreen {

    private final AppiumDriver driver;
    @FindBy(xpath = "//android.widget.Button[@content-desc='Admin Panel']")
    private WebElement adminPanelButton;

    public AdminPanelScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void scrollToAdminPanel() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\"))" +
                        ".scrollIntoView(new UiSelector().description(\"Admin Panel\"))"
        ));
    }
    public void clickAdminPanel() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(adminPanelButton));

        adminPanelButton.click();
    }
}
