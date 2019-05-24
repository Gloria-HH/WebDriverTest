package com.demo;

import com.demo.common.Constants;
import com.demo.page.AccountPage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        loginPage = homePage.navigateToLoginPage();
    }

    @Test
    public void loginPass() {
        AccountPage accountPage = loginPage.loginSuccess("&&", "111");
        Assertions.assertThat("GitHub"
                .equals(accountPage.getTitle()));

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

    @AfterMethod
    public void after() {
        loginPage.close();
    }

}
