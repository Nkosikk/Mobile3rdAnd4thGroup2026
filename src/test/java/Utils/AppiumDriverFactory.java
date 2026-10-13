package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverFactory {

    private AppiumDriver driver;

    public  static AppiumDriverFactory  instanceOfAppiumDriverFactory;

    public AppiumDriverFactory(String appPath){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", appPath);

        try{
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public static AppiumDriverFactory getInstanceOfAppiumDriverFactory(String appPath){
        if(instanceOfAppiumDriverFactory == null){
            instanceOfAppiumDriverFactory = new AppiumDriverFactory(appPath);
        }
        return instanceOfAppiumDriverFactory;
    }

    public static AppiumDriver getDriver(){
        return driver;
    }
}
