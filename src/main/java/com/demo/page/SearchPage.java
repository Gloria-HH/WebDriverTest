package com.demo.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.demo.common.Constants;

public class SearchPage extends BasePage {

	@FindBy(name = "q")
	@CacheLookup
	private WebElement search;

	@FindBy(css = "div.d-flex.flex-column.flex-md-row.flex-justify-between.border-bottom.pb-3.position-relative")
	private WebElement resultInfo;
	@FindBy(css = "div.blankslate")
	private WebElement noResult;


	public SearchPage(WebDriver webDriver) {
		super(webDriver);
	}

	public String getResult() {
		return resultInfo.getText();
	}

	@Override
	public String getUrl() {
		return Constants.SEARCH;
//		if (StringUtils.isBlank(search.getText())) {
//			return Constants.SEARCH;
//		}
//		return Constants.SEARCH + search.getText();
	}

	public String getNoResultMsg() {
		return noResult.getText();
	}

	public void search(String content) {
		search.sendKeys(content);
		search.sendKeys(Keys.ENTER);
	}

}
