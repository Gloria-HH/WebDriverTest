package com.demo;

import com.demo.data.LoginData;
import com.demo.page.AccountPage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import com.demo.utils.YamlUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private LoginData loginData;

    @BeforeClass
    public void setupBeforeClass() {
        loginData = YamlUtils.readConfigFromYaml("/login/login.yaml", LoginData.class);
    }


    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
        loginPage = homePage.navigateToLoginPage();
    }

    @Test
    public void loginPass() {
        AccountPage accountPage = loginPage.loginSuccess(loginData.getCorrectLogin().getUsername(),
                loginData.getCorrectLogin().getPassword());
        Assertions.assertThat(StringUtils.isNotBlank(accountPage.getUserName()));
        accountPage.logout();
    }

    @Test
    public void loginFailureWithErrorUsername() {
        LoginPage resultPage = loginPage.loginFailure(loginData.getErrorUsername().getUsername(),
                loginData.getErrorUsername().getPassword());
        Assertions.assertThat(resultPage.getErrorMessage()).isEqualTo(
                "Incorrect username or password.");
    }

    @Test
    public void loginFailureWithErrorPassword() {
        LoginPage resultPage = loginPage.loginFailure(loginData.getErrorPassword().getUsername(),
                loginData.getErrorPassword().getPassword());
        Assertions.assertThat(resultPage.getErrorMessage()).isEqualTo(
                "Incorrect username or password.");
    }

}
