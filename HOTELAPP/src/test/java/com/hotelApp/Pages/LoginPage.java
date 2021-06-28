package com.hotelApp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.hotelApp.basePage.CommonFuntions;

public class LoginPage extends CommonFuntions{

	
	public void enterUserName(String Uname){
		try {
			driver.findElement(By.id(prop.getProperty("LoginPage.username.id"))).sendKeys(Uname);
			Reporter.log("User Name Entered Successfully");
			test.log(Status.INFO, "User Name Entered Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "User Name Is Not Entered");
			Reporter.log("User Name Is Not Entered");
			
		}
		
	}
	
	public void enterPassword(String Uname){
		
		try {
			driver.findElement(By.id(prop.getProperty("LoginPage.password.id"))).sendKeys(Uname);
			test.log(Status.INFO, "Password Entered Successfully");
			Reporter.log("Password Entered Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Password Is Not Entered");
			Reporter.log("Password Is Not Entered");
		}
		
	}
	
	public void clickLogin(){
		
		try {
			driver.findElement(By.className(prop.getProperty("LoginPage.password.className"))).click();
			test.log(Status.INFO, "Login Is Clicked Successfully");
			Reporter.log("Login Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.INFO, "Login Is Not Clicked");
			Reporter.log("Login Is Not Clicked");
		}
		
	}
	
	
}
