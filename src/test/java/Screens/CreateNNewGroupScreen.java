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
import org.openqa.selenium.By;
import java.time.YearMonth;
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



    @FindBy(xpath = "//android.widget.Button[@content-desc='Previous month']")
    private WebElement previousMonthButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Next month']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//android.widget.Button[starts-with(@content-desc, 'Select year')]")
    private WebElement monthYearHeader;



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


    public void dismissKeyboard() {
        try {
            driver.executeScript("mobile: hideKeyboard");
        } catch (Exception e) {
            // Keyboard may already be hidden.
        }
    }


//This method reads the month/year displayed by the header and navigates to the requested month.

    public void navigateToMonth(LocalDate targetDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

        YearMonth targetMonth = YearMonth.from(targetDate);
        WebDriverWait calendarWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int attempt = 0; attempt < 24; attempt++) {
            String description = calendarWait.until(
                    ExpectedConditions.visibilityOf(monthYearHeader)).getAttribute("contentDescription");

            if (description == null || !description.contains("\n")) {
                throw new IllegalStateException("Could not read the displayed calendar month.");
            }

            String displayedMonth = description.substring(
                    description.lastIndexOf('\n') + 1).trim();

            YearMonth currentMonth =
                    YearMonth.parse(displayedMonth, formatter);

            if (currentMonth.equals(targetMonth)) {
                return;
            }

            if (currentMonth.isBefore(targetMonth)) {
                calendarWait.until(ExpectedConditions.elementToBeClickable(nextMonthButton)).click();
            } else {calendarWait.until(ExpectedConditions.elementToBeClickable(previousMonthButton)).click();
            }
        }

        throw new IllegalStateException("Could not navigate to calendar month: " + targetMonth
        );
    }


    public void selectDate(LocalDate date) {
        // Navigate to the requested month and year first
        navigateToMonth(date);

        // Build the dynamic accessibility description for the requested day
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d, EEEE, MMMM d, yyyy", Locale.ENGLISH);

        String dateDescription = date.format(formatter);

        By dayLocator = By.xpath("//android.widget.Button[@content-desc='" + dateDescription + "']");

        // Wait for the requested day to become clickable
        WebElement dayButton = wait.until(ExpectedConditions.elementToBeClickable(dayLocator));

        dayButton.click();

        // Confirm the selected date
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

    public void selectStartDate(LocalDate date) {
        clickStartDate();
        selectDate(date);
    }

    public void selectEndDate(LocalDate date) {
        clickEndDate();
        selectDate(date);
    }


    //Month Navigation Method

    public void clickNextMonth() {
        wait.until(ExpectedConditions.elementToBeClickable(nextMonthButton));
        nextMonthButton.click();
    }

    public void clickPreviousMonth() {
        wait.until(ExpectedConditions.elementToBeClickable(previousMonthButton));
        previousMonthButton.click();
    }


    public void clickCreateGroup() {
        wait.until(ExpectedConditions.elementToBeClickable(createGroupButton));
        createGroupButton.click();
    }

}
