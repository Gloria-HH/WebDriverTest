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


    @FindBy(css = "a.HeaderMenu-link.no-underline.mr-3")
    @CacheLookup
    private WebElement signIn;

    //    @FindBy(name = "q")
//    @CacheLookup
    private WebElement search;

    public HomePage(){
        super();
    }


    public HomePage(WebDriver webDriver){
        super(webDriver);
    }



    public LoginPage navigateToLoginPage() {
        signIn.click();
        return new LoginPage(driver);
    }

    public SearchPage search(String keyword) {
        search = find(By.name("q"));
        search.clear();
        search.sendKeys(keyword);
        search.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    @Override
    public String getUrl() {
        return Constants.BASE_URL;
    }
}
