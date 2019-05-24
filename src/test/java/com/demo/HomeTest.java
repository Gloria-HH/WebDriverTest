package com.demo;

import com.demo.common.Constants;
import com.demo.page.HomePage;
import com.demo.page.SearchPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() {
//        Driver.start();
//        driver.get(Constants.BASE_URL);
//        driver = Driver.getCurrentDriver();
//        homePage = new HomePage(driver);
    }


    @Test
    public void homePageSearchHasResult() {
        driver.get(Constants.BASE_URL);
        homePage = new HomePage(driver);
        SearchPage searchPage = homePage.search("TDD");
        Assertions.assertThat(searchPage.getResult()).contains(
                "repository result");

    }

    @Test
    public void homePageSearchHasNoResult() {
        driver.get(Constants.BASE_URL);
        homePage = new HomePage(driver);
        String searchContent = "2523test";
        SearchPage searchPage = homePage.search(searchContent);
        Assertions.assertThat(searchPage.getNoResultMsg()).contains(
                searchContent);

    }

//    @AfterClass
//    public void after() {
//        homePage.close();
//    }

}
