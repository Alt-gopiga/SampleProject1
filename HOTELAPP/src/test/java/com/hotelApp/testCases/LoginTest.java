package com.hotelApp.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hotelApp.Pages.LoginPage;

public class LoginTest extends LoginPage {

	@BeforeClass
	public void setValue(){
		dataSheetName="LoginData";
		testName="Login into application";
		description="Login into application with valid data";
	}
	
	@Test(dataProvider="fetchData")
	public void login(String Uname, String Pword){
		enterUserName(Uname);
		enterPassword(Pword);
		clickLogin();
	}
}
