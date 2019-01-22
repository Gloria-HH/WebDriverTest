package com.demo;

import org.testng.annotations.Test;

import com.demo.flow.HomeFlow;
import com.demo.page.SearchPage;

public class HomeTest {
	
	@Test
	public void HomeSearch() {
		System.out.println("start");
		HomeFlow homeFlow = new HomeFlow();
		SearchPage searchPage=homeFlow.search("test");
		System.out.println("homeSearch:"+searchPage.getResultNum());
		
	}

}
