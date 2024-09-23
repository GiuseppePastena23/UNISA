package com.example.model;

import java.io.Serializable;

public class Calculator implements Serializable {

	private static final long serialVersionUID = 1L;

	long fact;

	public Calculator() {
		fact = 2 + (int)(Math.random() * 10);
	}

	public long getFact() {
		return fact;
	}

	public void setFact(long fact) {
		this.fact = fact;
	}

	public long getFactorial() {
		return factorial(fact);
	}	
	
	long factorial(long n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}
}
