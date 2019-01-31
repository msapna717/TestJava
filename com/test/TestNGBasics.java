package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	//pre-condition annotation
	@BeforeSuite
	public void setUp(){
		System.out.println("@BeforeSuite -- setup system prperty for chrome");
	}
	
	@BeforeTest
	public void launchBrowser(){
		System.out.println("@BeforeTest -- Launch chrome bowser ");
	}
	@BeforeClass
	public void login(){
		System.out.println("@BeforeClass -- Enter login detail");
	}
@BeforeMethod
public void enterUrl(){
	System.out.println("@BeforeMethod -- Enter Url");
}

//test case annotation	
@Test
public void googleTitleTest(){
	
	System.out.println("@Test -- Google title test");
}
@Test
public void searchTest(){
	System.out.println("@Test -- search test");
}
//post conditions annotation
	@AfterMethod
	public void logOut(){
		System.out.println(" @AfterMethod -- logout from app");
	}
	@AfterTest
	public void deleteAllCookies(){
		System.out.println("@AfterTest -- deleteAllCookies");
	}
	@AfterClass
	public void closeBrowser(){
		System.out.println("@AfterClass -- close browser");
	}
	@AfterSuite
	public void generateTestReport(){
		System.out.println("@AfterSuite -- Generate test report");
	}
	
}
