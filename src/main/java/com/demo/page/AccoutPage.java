package com.demo.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccoutPage extends BasePage {

	@FindBy(css = "strong.css-truncate-target")
	private WebElement userName;
	@FindBy(name = "q")
	@CacheLookup
	private WebElement search;

	public AccoutPage() {
		super();
	}

	public AccoutPage(BasePage basePage) {
		super(basePage);
	}

	public String getUserName() {
		return userName.getText();
	}

	public void search(String content) {
		search.sendKeys(content);
		search.sendKeys(Keys.ENTER);
	}

}
