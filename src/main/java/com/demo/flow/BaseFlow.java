package com.demo.flow;


public abstract class BaseFlow<T> {

	public T startPage;
	public T endPage;


	abstract BaseFlow<T> withStartPage(T basePage) ;

	public T getEndPage() {
		return endPage;
	}

	public abstract void execute();
	
	public abstract void close();
	

}
