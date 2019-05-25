package com.demo;

import com.demo.page.AccountPage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import com.demo.page.SearchPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @BeforeMethod
    public void HomePage() {
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

    @Test
    public void loginSearchHasResults() {
        //登录
        LoginPage loginPage = homePage.navigateToLoginPage();
        AccountPage accountPage = loginPage.loginSuccess("XX@sina.com", "xx");
        //查询退出
        SearchPage searchPage = accountPage.search("TDD");
        Assertions.assertThat(searchPage.getResult()).contains(
                "repository result");
        accountPage.logout();

    }


}
