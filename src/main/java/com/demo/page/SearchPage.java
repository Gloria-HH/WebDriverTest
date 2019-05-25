package com.demo.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.demo.common.Constants;

public class SearchPage extends BasePage {

//	@FindBy(name = "q")
//	@CacheLookup
//	private WebElement search;
//
//	@FindBy(css = "div.d-flex.flex-column.flex-md-row.flex-justify-between.border-bottom.pb-3.position-relative")
//	private WebElement resultInfo;
//	@FindBy(css = "div.blankslate")
//	private WebElement noResult;

    private By keywords = By.name("q");
    private By resultInfo = By.xpath("//div[contains(@class,'d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative')]");
    private By noResult = By.xpath("//div[@class='blankslate']");


    public SearchPage() {
        super();
    }

    public String getResult() {
        return find(resultInfo).getText();
    }

    public String getNoResultMsg() {
        return find(noResult).getText();
    }

    public void search(String content) {
        WebElement webElement = find(keywords);
        webElement.sendKeys(content);
        webElement.sendKeys(Keys.ENTER);
    }

}
