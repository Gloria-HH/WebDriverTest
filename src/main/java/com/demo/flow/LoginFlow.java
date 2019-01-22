package com.demo.flow;

import com.demo.page.BasePage;
import com.demo.page.LoginPage;
import com.demo.param.LoginParamter;

public class LoginFlow extends BaseFlow<LoginPage> {

	// private LoginPage loginPage;
	private LoginParamter loginParamter;

	public LoginFlow() {

	}

	public LoginFlow(LoginParamter loginParamter) {
		// this.loginPage = new LoginPage();
		this.loginParamter = loginParamter;
	}

	public void login() {
		startPage.login(loginParamter.getUserName(),
				loginParamter.getPassword());
	}

	@Override
	public void execute() {
		startPage.login(loginParamter.getUserName(),
				loginParamter.getPassword());
	}

	@Override
	public BaseFlow<LoginPage> withStartPage(LoginPage basePage) {
		startPage=basePage;
		return this;
	}

	@Override
	public void close() {
		startPage.close();
	}

	

}
