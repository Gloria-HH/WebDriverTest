package com.demo;

import com.demo.page.AccountPage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;


    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        loginPage = homePage.navigateToLoginPage();
    }

    @Test
    public void loginPass() {
        AccountPage accountPage = loginPage.loginSuccess("xx@sina.com", "xxx");
        Assertions.assertThat(StringUtils.isNotBlank(accountPage.getUserName()));
        accountPage.logout();
    }

    @Test
    public void loginFailureWithErrorUsername() {
        LoginPage resultPage = loginPage.loginFailure("XXX@sina.com", "XXX");
        Assertions.assertThat(resultPage.getErrorMessage()).isEqualTo(
                "Incorrect username or password.");
    }

    @Test
    public void loginFailureWithErrorPassword() {
        LoginPage resultPage = loginPage.loginFailure("XXX@sina.com", "111");
        Assertions.assertThat(resultPage.getErrorMessage()).isEqualTo(
                "Incorrect username or password.");
    }

}
