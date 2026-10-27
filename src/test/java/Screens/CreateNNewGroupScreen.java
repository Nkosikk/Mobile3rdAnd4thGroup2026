package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateNNewGroupScreen {
    private AppiumDriver driver;


    public CreateNNewGroupScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.Button")
    WebElement adminDashboardMainMenu;


    public void clickOnAdminDashboardMainMenu(String description) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(adminDashboardMainMenu));
        adminDashboardMainMenu.click();
    }


}
