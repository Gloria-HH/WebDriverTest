package com.demo.page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.demo.common.Constants;

public class SearchPage extends BasePage {

	@FindBy(name = "q")
	@CacheLookup
	private WebElement search;

	@FindBy(css = "div.d-flex.flex-column.flex-md-row.flex-justify-between.border-bottom.pb-3.position-relative")
	private WebElement resultNum;
	@FindBy(css = "div.blankslate")
	private WebElement noResult;

	public SearchPage() {

	}

	public SearchPage(BasePage parent) {
		super(parent);
	}

	public String getResultNum() {
		return resultNum.getText();
	}

	@Override
	public String getUrl() {
		System.out.println(driver.getCurrentUrl());
		if (StringUtils.isBlank(search.getText())) {
			return Constants.SEARCH;
		}
		return Constants.SEARCH + search.getText();
	}

	public String getNoResultMsg() {
		return noResult.getText();
	}

	public void search(String content) {
		search.sendKeys(content);
		search.sendKeys(Keys.ENTER);
	}

}
