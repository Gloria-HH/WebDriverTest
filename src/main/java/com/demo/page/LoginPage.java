package com.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.demo.common.Constants;

public class LoginPage extends BasePage {
    private By username = By.id("login_field");
    private By pwd = By.id("password");
    private By sign = By.name("commit");
    private By errorBox = By.id("js-flash-container");


    @Override
    public String getUrl() {
        return Constants.LOGIN;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public AccountPage loginSuccess(String userName, String password) {
        find(username).sendKeys(userName);
        find(pwd).sendKeys(password);
        find(sign).click();
        return new AccountPage();
    }

    public LoginPage loginFailure(String userName, String password) {
        find(username).sendKeys(userName);
        find(pwd).sendKeys(password);
        find(sign).click();
        return this;
    }

    public String getErrorMessage() {
        return find(errorBox).getText();
    }

}
