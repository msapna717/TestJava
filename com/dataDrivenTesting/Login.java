package com.dataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	static WebDriver driver;
	@Test(dataProvider="loginData")
	public void loginTest(String email, String password) {
		System.setProperty("webdriver.gecko.driver", "/Users/sapnamishra/Documents/WebDriver/geckodriver");
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get("https://github.com/login");
		 driver.findElement(By.id("login_field")).clear();
		 driver.findElement(By.id("login_field")).sendKeys(email);
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@value='Sign In')]")).click();
		 Assert.assertTrue(driver.getTitle().contains("#inbox"),"User is not able to login-- invalid credentials");
		 System.out.println("Page title verified- user is able to login");
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider(name="loginData")
	public Object[][] getData(){
		Object[][] data=new Object[2][2];
		data[0][0]="admin1";
		data[0][1]="demo1";
		data[1][0]="admin2";
		data[1][1]="demo2";
		
		
		return data;
	}
	
	
	
	
	
}
