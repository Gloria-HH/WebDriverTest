package com.demo.flow;

import com.demo.page.BasePage;
import com.demo.page.HomePage;
import com.demo.page.LoginPage;
import com.demo.page.SearchPage;

public class HomeFlow extends BaseFlow {

	private HomePage homePage = new HomePage();

	public HomeFlow() {

	}

	public LoginPage navigateToLogin() {
		return homePage.navigateToLoginPage();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public BaseFlow withStartPage(BasePage basePage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		if (homePage != null)
			homePage.close();
	}

	public SearchPage search(String keyword) {
		homePage.search(keyword);
		return new SearchPage(homePage);
	}
}
