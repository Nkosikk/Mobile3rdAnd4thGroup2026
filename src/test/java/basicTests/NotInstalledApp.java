package basicTests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NotInstalledApp {

    AppiumDriver driver;

    @BeforeClass
    public void setup() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setNoReset(false);
        options.setApp("C:\\Mobile3rdAnd4thGroup2026\\src\\main\\Apps\\app-qa-release.apk");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
    }

    @Test
    public void testimonialTest() {
        driver.findElement(AppiumBy.accessibilityId("Testimonials")).click();
        driver.findElement(AppiumBy.accessibilityId("All Reviews")).isDisplayed();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
