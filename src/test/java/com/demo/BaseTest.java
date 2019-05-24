package com.demo;

import com.demo.common.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        Driver.start();
        driver = Driver.getCurrentDriver();
    }
}
