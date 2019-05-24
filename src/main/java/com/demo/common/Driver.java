package com.demo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Driver {

    private static WebDriver driver;


    public static void start() {
        instanceDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getCurrentDriver() {
        if (driver == null) {
            start();
        }
        return driver;
    }


    private static void instanceDriver() {
        String driverName = System.getProperty(Constants.WEBDRIVER_DRIVER_NAME,
                "ChromeDriver");
        switch (driverName) {
            case "FireFoxDriver":
                driver = new FirefoxDriver();
                break;
            case "InternetExplorerDriver":
                driver = new InternetExplorerDriver();
                break;
            case "SafariDriver":
                driver = new SafariDriver();
                break;
            case "ChromeDriver":
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
    }
}
