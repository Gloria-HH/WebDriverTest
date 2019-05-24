package com.demo.page;

import com.demo.common.Constants;
import com.demo.common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private By signIn = By.xpath("//*[@href='/login']");

    private By search = By.name("q");

    public HomePage() {
        super();
    }


    public LoginPage navigateToLoginPage() {
        click(signIn);
        return new LoginPage(driver);
    }

    public SearchPage search(String keyword) {
        WebElement searchElement = find(search);
        searchElement.clear();
        searchElement.sendKeys(keyword);
        searchElement.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

    @Override
    public String getUrl() {
        return Constants.BASE_URL;
    }
}
