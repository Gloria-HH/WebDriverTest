package com.demo.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.common.Constants;

public abstract class BasePage {
    /**
     * Documents the system property that is used to inject a different
     * webdriver into the tests. Set the property to the name of the alternative
     * driver to use ("InternerExplorerDriver", "ChromeDriver", and so forth).
     */
    public final static String WEBDRIVER_DRIVER_NAME = "webdriver.driver.name";

    /**
     * Documents the system property that indicates the location of the
     * ChromeDriver binary, if it is not installed in the default location.
     * https://code.google.com/p/selenium/wiki/ChromeDriver
     */
    public final static String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    public WebDriver driver;

    /*public BasePage() {
        this(null, true);
    }*/

    public BasePage(){
        PageFactory.initElements(driver, this);
    }
    public BasePage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

//    public BasePage(BasePage parent) {
//        this(parent, false);
//    }

    /*public BasePage(BasePage parent, Boolean navigate) {
        Long start = System.currentTimeMillis();
        System.out.println(start);
        if (driver == null) {
            if (parent == null || parent.driver == null) {
                instanceDriver();
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            } else {
                driver = parent.driver;
            }

        }
        Long driverInitTime = System.currentTimeMillis();
        System.out.println("driverInitTime-start=" + (driverInitTime - start));
        if (navigate) {
            navigateTo(getUrl());
        }
        System.out.println(this.getClass().getName());
        PageFactory.initElements(this.driver, this);
        Long end = System.currentTimeMillis();
        System.out.println("end-start=" + (end - start));
    }*/

    /**
     * Returns the absolute url to open the page.
     *
     * @return Absolute url for the page
     */
    public String getUrl() {
        return Constants.BASE_URL;
    }

    public java.util.List<String> getAllErrors() {
        throw new java.lang.UnsupportedOperationException();
    }

    public java.util.List<String> getAllPrompts() {
        throw new java.lang.UnsupportedOperationException();
    }

    /**
     * Navigates browser to the url
     *
     * @param url
     */
    public BasePage navigateTo(String url) {
        driver.get(url);
        return this;
    }

    /**
     * Returns title of the current browser page
     *
     * @return
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * Returns url of the current browser page
     *
     * @return
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Returns HTML source of the current browser page.
     *
     * @return
     */
    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        if (driver != null) {
            driver.close();
        }
        driver = null;
    }

    private void instanceDriver() {
        String driverName = System.getProperty(WEBDRIVER_DRIVER_NAME,
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

    public String getErrorMessage() {
        return null;
    }

    public WebElement find(By by) {
        return driver.findElement(by);
    }


}
