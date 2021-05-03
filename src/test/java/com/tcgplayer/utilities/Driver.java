package com.tcgplayer.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){}

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver(){

        if (driverPool.get() == null) {

            synchronized (Driver.class) {

                String browser = com.tcgplayer.utilities.ConfigurationReader.getProperty("browser");

                switch (browser) {

                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;

                    default:
                        throw new RuntimeException("No such Browser yet!");

                }

            }

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().close();
            driverPool.remove();
        }

    }
}

