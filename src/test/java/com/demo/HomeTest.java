package com.demo;

import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.page.SearchPage;

public class HomeTest {

	private HomeFlow homeFlow;

	@Test
	public void homePageSearchHasResult() {
		homeFlow = new HomeFlow();
		SearchPage searchPage = homeFlow.search("TDD");
		Assertions.assertThat(searchPage.getResultNum()).contains(
				"repository result");
		 homeFlow.close();

	}

	@Test
	public void homePageSearchHasNoResult() {
		homeFlow = new HomeFlow();
		String searchContent = "2523test";
		SearchPage searchPage = homeFlow.search(searchContent);
		Assertions.assertThat(searchPage.getNoResultMsg()).contains(
				searchContent);
		 homeFlow.close();

	}

	@AfterClass
	public void after() {
		homeFlow.close();
	}

}
