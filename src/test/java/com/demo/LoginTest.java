package com.demo;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.flow.LoginFlow;
import com.demo.param.LoginParamter;

public class LoginTest {

	private HomeFlow homeFlow;

	@Test
	public void loginPass() {
		homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("testUseSele");
		loginParamter.setPassword("!qwer1234!?");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		Assertions.assertThat("GitHub"
				.equals(loginFlow.getEndPage().getTitle()));

		loginFlow.close();
	}

	@Test
	public void loginFailureWithErrorUsername() {
		homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("XXX");
		loginParamter.setPassword("XXX");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		Assertions.assertThat(loginFlow.startPage.getErrorMessage()).isEqualTo(
				"Incorrect username or password.");
		loginFlow.close();
	}

	@Test
	public void loginFailureWithErrorPassword() {
		homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("XXX");
		loginParamter.setPassword("XXX");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		Assertions.assertThat(loginFlow.startPage.getErrorMessage()).isEqualTo(
				"Incorrect username or password.");
		loginFlow.close();
	}

}
