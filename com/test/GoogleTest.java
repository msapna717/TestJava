package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
WebDriver driver;
@BeforeMethod
public void setUp(){
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	}
@Test(priority=1,groups="Title")
public void googleTitleTest(){
	String title= driver.getTitle();
	System.out.println(title);
}
@Test(priority=2,groups="Logo")
public void googleLogoTest(){
	boolean b=driver.findElement(By.xpath("//*[@id='plogo']")).isDisplayed();
	System.out.println("Google logo displayed: "+b);
}
@Test(priority=3)
public void Test1(){
	System.out.println("test1");
}
@AfterMethod
public void tearDown(){
	driver.quit();
}
}
	
	
	
	

