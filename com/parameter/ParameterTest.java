package com.parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
@Test 
@Parameters({ "env","browser","url","sUsername","sPassword" })

public void gitLoginTest (String env, String browser, String url, String sUsername, String sPassword ){
	System.out.println("---------- Environment is -------  "+env);
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver =new ChromeDriver();
	}
	else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "/Users/sapnamishra/Documents/WebDriver/geckodriver");
		driver =new FirefoxDriver();
	}
	
	driver.get(url);
	driver.findElement(By.xpath("//*[@id='login_field']")).clear();
	driver.findElement(By.xpath("//*[@id='login_field']")).sendKeys(sUsername);
	driver.findElement(By.xpath("//*[@id='password']")).clear();
	driver.findElement(By.xpath("//*[@id='password']")).sendKeys(sPassword);
	driver.findElement(By.xpath("//*[@value='Sign in']")).click();
	driver.quit();
	System.out.println("--------- Login successfull ---------");
	
	
}
}
