package com.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccoutPage extends BasePage {

	@FindBy(css = "strong.css-truncate-target")
	private WebElement userName;

	public AccoutPage() {
		super();
	}

	public AccoutPage(BasePage basePage) {
		super(basePage);
	}

	public String getUserName() {
		return userName.getText();
	}

}
