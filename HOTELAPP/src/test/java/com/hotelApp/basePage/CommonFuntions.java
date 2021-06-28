package com.hotelApp.basePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hotelApp.utils.Utils;

public class CommonFuntions extends Utils{
	
	public WebDriver driver;
	public static Properties prop;
	public String Driver, Url, BrowserName;
	public WebDriverWait wait;
	public int WaitTime=10;
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports extent;
	public ExtentTest test;
	public String testName,description;

	@BeforeSuite
	public void launchBrowser() throws IOException{

		loadProperties();
		Driver=prop.getProperty("driverlocation");
		Url=prop.getProperty("url");
		BrowserName=prop.getProperty("browser");

		if(BrowserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",Driver);
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",Driver);
		}

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get(Url);

	}

	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	@BeforeTest
	public void extentConfig(){

		htmlReport=new ExtentHtmlReporter("extent.html");
		htmlReport.config().setReportName("Automation Testing");
		htmlReport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReport.config().setChartVisibilityOnOpen(true);
		htmlReport.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(htmlReport);

	}

	public void startTestCase(String testName,String description){
		test=extent.createTest(testName, description);
	}
	
	@AfterSuite
	public void endResult(){		
		extent.flush();
	}
	
	public Properties loadProperties() throws IOException{
		try {
			prop=new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
		} catch (FileNotFoundException e) {
		}
		return prop;

	}

	@BeforeMethod
	public void ObjectProperties(){
		startTestCase(testName,description);
		try {
			prop=new Properties();
			prop.load(new FileInputStream(new File("objects.properties")));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void selectIndexByXpath(String Xpath, int Value){

		try {
			new Select(driver.findElement(By.xpath(Xpath))).selectByIndex(Value);
			Reporter.log("The Element With " +Xpath+ " Is Selected Index Values is " + Value);
			test.log(Status.PASS, "The Element With " +Xpath+ " Is Selected Index Values is " + Value);
		} catch (Exception e) {
			Reporter.log("The index: "+Xpath+" could not be selected.");
			test.log(Status.FAIL, "The index: "+Xpath+" could not be selected.");
		}

	}

	public void enterByXpath(String Xpath, String Value){

		try {
			wait=new WebDriverWait(driver, WaitTime);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
			element.clear();
			element.sendKeys(Value);
			Reporter.log("The data: "+Value+" entered successfully in field :"+Xpath);
			test.log(Status.PASS, "The data: "+Value+" entered successfully in field :"+Xpath);
		} catch (Exception e) {
			Reporter.log("The data: "+Value+" could not be entered in the field :"+Xpath);
			test.log(Status.FAIL, "The data: "+Value+" could not be entered in the field :"+Xpath);
		}	
	}

	public void AlertAccept(){

		try {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {

		}
	}

	public void AlertDismiss(){

		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {

		}
	}

}
