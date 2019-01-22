package com.demo;

import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.flow.LoginFlow;
import com.demo.page.LoginPage;
import com.demo.param.LoginParamter;

public class LoginTest {

	@Test
	public void LoginPass() {
		LoginPage loginPage = new LoginPage();
		loginPage.login("userName", "password");
		loginPage.close();
	}

	@Test
	public void LoginPassUsingFlow() {
		HomeFlow homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("userName");
		loginParamter.setPassword("password");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		loginFlow.close();
	}

}
