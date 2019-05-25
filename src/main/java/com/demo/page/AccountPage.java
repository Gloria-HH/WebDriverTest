package com.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AccountPage extends BasePage {
    private By detailInfo = By.xpath("//div[contains(@class,'Header-item position-relative mr-0')]");
    private By userName = By.xpath("//strong[@class='css-truncate-target']");
    private By logout = By.xpath("//button[@class='dropdown-item dropdown-signout']");
    private By search = By.name("q");


    public AccountPage() {
        super();
    }


    public String getUserName() {
        find(detailInfo).click();
        return find(userName).getText();
    }

    public void logout() {
        find(detailInfo).click();
        find(logout).click();
    }

    public SearchPage search(String keyword) {
        WebElement searchElement = find(search);
        searchElement.clear();
        searchElement.sendKeys(keyword);
        searchElement.sendKeys(Keys.ENTER);
        return new SearchPage();
    }


}
