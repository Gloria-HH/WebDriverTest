package com.demo;

import com.demo.common.Constants;
import com.demo.page.AccountPage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
    private HomePage homePage;

    @BeforeMethod
    public void HomePage() {
        homePage = new HomePage();
    }

    @Test
    public void loginSearchHasResults() {
        //登录
        LoginPage loginPage = homePage.navigateToLoginPage();
        AccountPage accountPage = loginPage.loginSuccess("&&", "111");
        Assertions.assertThat("GitHub"
                .equals(accountPage.getTitle()));


        //查询
//        SearchPage searchPage=
//        SearchParameter searchParameter = new SearchParameter();
//        searchParameter.setSearchContent("test");
//        SearchFlow searchFlow = new SearchFlow(searchParameter);
//        searchFlow.withStartPage(loginFlow.getEndPage()).execute();

    }

    @AfterClass
    public void after() {
        homePage.close();
    }

}
