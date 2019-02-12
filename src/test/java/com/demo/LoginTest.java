package com.demo;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.flow.LoginFlow;
import com.demo.page.BasePage;
import com.demo.page.LoginPage;
import com.demo.param.LoginParamter;

public class LoginTest {

	@Test
	public void loginPass() {
		HomeFlow homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("testUseSele");
		loginParamter.setPassword("!qwer1234!?");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		
		loginFlow.close();
	}
	
	@Test
	public void loginFailureWithErrorUsername() {
		HomeFlow homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("testUseSe");
		loginParamter.setPassword("!qwer1234!?");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		Assertions.assertThat(loginFlow.startPage.getErrorMessage()).isEqualTo("Incorrect username or password.");
		loginFlow.close();
	}
	
	@Test
	public void loginFailureWithErrorPassword() {
		HomeFlow homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("testUseSele");
		loginParamter.setPassword("!qwer1234");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();
		Assertions.assertThat(loginFlow.startPage.getErrorMessage()).isEqualTo("Incorrect username or password.");
		loginFlow.close();
	}

}
