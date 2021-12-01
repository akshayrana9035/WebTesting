package com.TestNg;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	@Test(invocationTimeOut=7000)
	public void infiteLoopTest() {
		int i =1;
		while(i==1) {
		System.out.println(i);
		}
		
		
	}

}
