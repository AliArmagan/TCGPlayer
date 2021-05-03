package com.tcgplayer.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriver {
    private static AppiumDriver<MobileElement> driver;
    private static final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
// private final static String ANDROID_APP_URL = ConfigurationReader.getProperty("android.app.url");

    public static AppiumDriver<MobileElement> getDriverMobile() {
        if (driver == null) {
            String platform = ConfigurationReader.getProperty("platform");
            //logger.info("Running tests on: " + platform);
            switch (platform) {
                case "android":
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a_API_30_x86");
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                    // driver = new RemoteWebDriver(url, desiredCapabilities);
                    try {
                        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    //   logger.error("Driver type is not implemented yet!");
                    throw new RuntimeException("Driver type is not implemented yet!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.closeApp();
            driver = null;
        }
    }
}
