package com.dataDrivenTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.ExcelDataConfig;

public class GoogleSignupTest {
	public static WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en-GB&flowName=GlifWebSignIn&flowEntry=SignUp");
	}
	
	@Test(dataProvider="getTestData")
	public void sigupTest(String firstName, String lastName, String userName, String password, String confirmPassword) {
		driver.findElement(By.xpath("//*[@id='firstName']")).clear();
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='lastName']")).clear();
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(userName);
		driver.findElement(By.name("Passwd")).clear();
		driver.findElement(By.name("Passwd")).sendKeys(password);
		driver.findElement(By.name("ConfirmPasswd")).clear();
		driver.findElement(By.name("ConfirmPasswd")).sendKeys(confirmPassword);
		driver.findElement(By.className("CwaK9")).click();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	@DataProvider(name="getTestData")
	
	public static Object[][] getTestData() throws Exception{
		ExcelDataConfig config=new ExcelDataConfig("/Users/sapnamishra/Documents/workspace/TestJava/src/com/testData/testDataProvider.xls");
		int rows=config.getRowCount(0);
		System.out.println(rows);
		int cols=config.getColCount(0);
		System.out.println(cols);
		
		Object[][] data=new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j= 0; j < cols; j++)
			data[i][j]=config.getData(0, i, j);
			}
		
		return data;
	}
	
}
