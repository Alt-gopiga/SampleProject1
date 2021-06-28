package com.hotelApp.basePage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class PreCondition extends CommonFuntions{


	public void beforeSuite(){
		extentConfig();
	}
	

	public void beforeTest(){
		ObjectProperties();
	}

	public void beforeMethod() throws IOException{
		launchBrowser();
		startTestCase(testName, description);
		
	}
	
	
	public void afterMethod(){
		tearDown();
	}
	

	public void afterSuite(){
		endResult();
	}
}
