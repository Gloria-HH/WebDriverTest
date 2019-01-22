package com.demo.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(id = "user[login]")
	@CacheLookup
	private WebElement username;

	@FindBy(id = "user[password]")
	@CacheLookup
	private WebElement password;

	@FindBy(css = "a.HeaderMenu-link.no-underline.mr-3")
	@CacheLookup
	private WebElement signIn;

	@FindBy(css = "a.HeaderMenu-link.d-inline-block.no-underline.border.border-gray-dark.rounded-1.px-2.py-1")
	@CacheLookup
	private WebElement signUp;

	@FindBy(name = "q")
	@CacheLookup
	private WebElement search;

	@FindBy(css = "button.btn-mktg.btn-primary-mktg.btn-large-mktg.f4.btn-block")
	@CacheLookup
	private WebElement signUpForGithub;

	public LoginPage navigateToLoginPage() {
		signIn.click();
		return new LoginPage();
	}
	
	public  void search(String keyword) {
		search.sendKeys(keyword);
		search.sendKeys(Keys.ENTER);
	}

}
