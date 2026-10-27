package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import java.time.Duration;

public class CreateNNewGroupScreen {
    private AppiumDriver driver;
    private WebDriverWait wait;


    public CreateNNewGroupScreen(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement groupNameField;


    @FindBy(xpath = "//android.widget.EditText[2]")
    private WebElement descriptionField;


    @FindBy(xpath = "//android.widget.EditText[3]")
    private WebElement yearField;

    @FindBy(xpath = "//android.widget.EditText[4]")
    private WebElement maxCapacityField;

    // Start Date calendar button
    //@FindBy(xpath = "(//android.view.View[@text])[last()-1]")
    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")
    private WebElement startDateButton;


    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button")
    private WebElement endDateButton;



    @FindBy(xpath = "//android.widget.Button[@content-desc='OK']")
    private WebElement datePickerOkButton;


    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Create Group\"]")
    WebElement createGroupButton;


    public void enterGroupName(String groupName) {
        wait.until(ExpectedConditions.elementToBeClickable(groupNameField));
        groupNameField.sendKeys(groupName);
    }

    public void enterDescription(String description) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(descriptionField));
        descriptionField.sendKeys(description);
    }


    public void enterYear(String year) {
        wait.until(ExpectedConditions.elementToBeClickable(yearField));
        yearField.clear();
        yearField.sendKeys(year);
    }


    public void enterMaxCapacity(String capacity) {
        wait.until(ExpectedConditions.elementToBeClickable(maxCapacityField));
        maxCapacityField.sendKeys(capacity);
    }


    public void selectDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE, MMMM d, yyyy", Locale.ENGLISH);
        String dateDescription = date.format(formatter);
        WebElement dayButton = wait.until(ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath("//android.widget.Button[@content-desc='" + dateDescription + "']"))
        );

        dayButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(datePickerOkButton)).click();
    }


    public void clickStartDate() {
        wait.until(ExpectedConditions.elementToBeClickable(startDateButton));
        startDateButton.click();
    }

    public void clickEndDate() {
        wait.until(ExpectedConditions.elementToBeClickable(endDateButton));
        endDateButton.click();
    }

    public void confirmSelectedDate() {
        wait.until(ExpectedConditions.elementToBeClickable(datePickerOkButton));
        datePickerOkButton.click();
    }

    public void clickCreateGroup() {
        wait.until(ExpectedConditions.elementToBeClickable(createGroupButton));
        createGroupButton.click();
    }


}
