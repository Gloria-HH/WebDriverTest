package com.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.demo.common.Constants;

public class LoginPage extends BasePage {

	@FindBy(id = "login_field")
	@CacheLookup
	private WebElement username;

	@FindBy(id = "password")
	@CacheLookup
	private WebElement password;

	@FindBy(name = "commit")
	@CacheLookup
	private WebElement signIn;

	@FindBy(className = "flash-error")
	WebElement errorBox;
	

	@Override
	public String getUrl() {
		return Constants.LOGIN;
	}

	public LoginPage() {

	}

	public LoginPage(BasePage parent) {
		super(parent);
	}

	public AccoutPage login(String userName, String password) {
		this.username.sendKeys(userName);
		this.password.sendKeys(password);
		this.signIn.click();
		return new AccoutPage(this);

	}

	public String getErrorMessage() {
		return errorBox.getText();
	}

}
