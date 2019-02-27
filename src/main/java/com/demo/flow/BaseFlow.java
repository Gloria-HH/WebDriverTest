package com.demo.flow;

import com.demo.page.BasePage;

public abstract class BaseFlow {

	public BasePage startPage;
	public BasePage endPage;

	public abstract BaseFlow withStartPage(BasePage basePage);

	public BasePage getEndPage() {
		return endPage;
	}

	public abstract void execute();

	public abstract void close();


}
