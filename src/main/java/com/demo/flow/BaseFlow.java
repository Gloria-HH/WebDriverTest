package com.demo.flow;

import com.demo.page.BasePage;

public abstract class BaseFlow<T> {

	public T startPage;
	private BasePage endPage;

	public abstract BaseFlow<T> withStartPage(T basePage);

	public BasePage getEndPage() {
		return endPage;
	}

	public abstract void execute();

	public abstract void close();
	
	public void setEndPage(BasePage basePage) {
		endPage =basePage;
	}

}
