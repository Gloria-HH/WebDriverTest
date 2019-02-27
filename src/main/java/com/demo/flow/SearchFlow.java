package com.demo.flow;

import com.demo.page.AccoutPage;
import com.demo.page.BasePage;
import com.demo.page.SearchPage;
import com.demo.param.SearchParameter;

public class SearchFlow extends BaseFlow {

	private SearchParameter searchParameter;

	public SearchFlow() {
	}

	public SearchFlow(SearchParameter searchParameter) {
		this.searchParameter = searchParameter;
	}

	@Override
	public BaseFlow withStartPage(BasePage basePage) {
		startPage = basePage;
		return this;
	}

	@Override
	public void execute() {
		if(startPage instanceof AccoutPage ) {
			((AccoutPage)startPage).search(searchParameter.getSearchContent());
		}
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
