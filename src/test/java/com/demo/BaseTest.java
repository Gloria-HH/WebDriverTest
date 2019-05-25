package com.demo;

import com.demo.page.HomePage;
import org.testng.annotations.AfterClass;

public class BaseTest {
    protected HomePage homePage;

    @AfterClass
    public void after() {
        if (homePage != null) {
            homePage.close();
        }
    }
}
