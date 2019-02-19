package com.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.flow.LoginFlow;
import com.demo.flow.SearchFlow;
import com.demo.param.LoginParamter;
import com.demo.param.SearchParameter;

public class SearchTest {
	private HomeFlow homeFlow;

	@Test
	public void loginSearchHasResults() {
		homeFlow = new HomeFlow();
		LoginParamter loginParamter = new LoginParamter();
		loginParamter.setUserName("testUseSele");
		loginParamter.setPassword("!qwer1234!?");
		LoginFlow loginFlow = new LoginFlow(loginParamter);
		loginFlow.withStartPage(homeFlow.navigateToLogin()).execute();

		SearchParameter searchParameter = new SearchParameter();
		searchParameter.setSearchContent("test");
		SearchFlow searchFlow = new SearchFlow(searchParameter);
		//searchFlow.withStartPage(loginFlow.getEndPage());

	}

	@AfterClass
	public void after() {
		homeFlow.close();
	}

}
