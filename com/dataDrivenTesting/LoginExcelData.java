package com.dataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.ExcelDataConfig;

public class LoginExcelData {
	static WebDriver driver;
	@Test(dataProvider="loginData")
	public void loginTest(String email, String password) throws Exception{
		System.setProperty("webdriver.gecko.driver", "/Users/sapnamishra/Documents/WebDriver/geckodriver");
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.get("https://github.com/login");
		 driver.findElement(By.id("login_field")).clear();
		 driver.findElement(By.id("login_field")).sendKeys(email);
		 driver.findElement(By.id("password")).clear();
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 Thread.sleep(3000);
		 Assert.assertTrue(driver.getTitle().contains("GitHub"), "User is not able to login-- invalid credentials");
		 System.out.println("Page title verified- user is able to login");
		 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@DataProvider(name="loginData")
	public Object[][] loginData() throws Exception{
		ExcelDataConfig config=new ExcelDataConfig("/Users/sapnamishra/Documents/workspace/TestJava/src/com/testData/loginData.xls");
		int rows=config.getRowCount(1);
		System.out.println(rows);
		Object[][] data=new Object[rows][2];
		for (int i = 1; i < rows; i++) {
			data[i][0]=config.getData(1, i, 0);
			data[i][1]=config.getData(1, i, 1);
			
		}
		
		return data;
	}
	
	}


