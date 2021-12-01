package com.TestNg;

//import org.junit.BeforeClass;
//import org.junit.Test;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgFirstValidation {

	@BeforeSuite
	public void setup()
	{
	System.out.println("setup system propertyies for chrome browser ");
	}
	
	@BeforeGroups
	public void launchBrowser()
	{
	System.out.println("setup system propertyies for chrome browser ");
	}
	
	@BeforeMethod
	public void enterURL(){
		System.out.println("Enter URL ");
	}
	
	
	@BeforeTest
	public void login(){
		System.out.println("login ");
	}
	
	@org.testng.annotations.Test
	public void googletitleTest(){
		System.out.println("Validation google title ");
	}
	
	
	/*
	@AfterMethod
	
	
	@AfterTest
	
	
	@AfterClass
	
	
	@AfterSuite
	{
		
	}
	
	*/
	
	
	
	
	
	
	
}
