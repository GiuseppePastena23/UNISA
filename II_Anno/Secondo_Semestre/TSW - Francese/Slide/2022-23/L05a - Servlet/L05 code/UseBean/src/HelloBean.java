package com.example.model;

import java.io.Serializable;

public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	String nameProp;
	
	public HelloBean() {
		nameProp = "TSW";
	}
	
	public String getNameProp() {
		return nameProp;
	}

	public void setNameProp(String nameProp) {
		this.nameProp = nameProp;
	}	
}
