package com.demo;

import com.demo.page.HomePage;
import com.demo.page.SearchPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest  {

    private HomePage homePage;

    /*@BeforeClass
    public void setup() {
        homePage = new HomePage();
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
    }*/

}
