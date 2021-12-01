package com.TestNg;

import org.testng.annotations.Test;

public class invocationTestCout {

	@Test(invocationCount=5)
	public void sum() {
		int a=10;
		int b=20;
		int sum=a+b;
		System.out.println("Sum of two Numbers= "+sum);
		
				
		
	}
	
}
