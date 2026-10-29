package Screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardScreen {
    private AppiumDriver driver;

    public DashboardScreen(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.ScrollView/android.widget.Button")
    WebElement burgerMenuButton;

    public void clickBurgerMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(burgerMenuButton));
        burgerMenuButton.click();
    }

    public void clickGroups() {
        WebElement groupsOption = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Groups")
                ));

        groupsOption.click();
    }

    public void clickCreateNewGroup() {
        WebElement createNewGroupButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("+ Create New Group")
                ));

        createNewGroupButton.click();
    }


    public void clickLogout() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().description(\"Logout\"))"
        )).click();
    }
}