package com.demo.page;

import com.demo.common.Driver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

    public BasePage() {
        driver = Driver.getCurrentDriver();
        System.out.println(this.driver.getCurrentUrl());
        if (StringUtils.isNotBlank(getUrl())) {
            navigateTo(getUrl());
        }
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        System.out.println(this.driver.getCurrentUrl());
        PageFactory.initElements(driver, this);
    }

    /**
     * Returns the absolute url to open the page.
     *
     * @return Absolute url for the page
     */
    public String getUrl() {
//        return Constants.BASE_URL;
        return null;
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


    public String getErrorMessage() {
        return null;
    }

    public WebElement find(By by) {
        return driver.findElement(by);
    }

    public void click(By by) {
        driver.findElement(by).click();
    }


}
