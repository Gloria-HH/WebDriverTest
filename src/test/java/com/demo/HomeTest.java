package com.demo;

import com.demo.common.Constants;
import com.demo.common.Driver;
import com.demo.page.HomePage;
import com.demo.page.SearchPage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {

    private HomePage homePage;
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        Driver.start();
        driver.get(Constants.BASE_URL);
        driver = Driver.getCurrentDriver();
        homePage = new HomePage(driver);
    }


    @Test
    public void homePageSearchHasResult() {
        SearchPage searchPage = homePage.search("TDD");
        Assertions.assertThat(searchPage.getResult()).contains(
                "repository result");

    }

    @Test
    public void homePageSearchHasNoResult() {
        String searchContent = "2523test";
        SearchPage searchPage = homePage.search(searchContent);
        Assertions.assertThat(searchPage.getNoResultMsg()).contains(
                searchContent);

    }

    @AfterClass
    public void after() {
        homePage.close();
    }

}
