package com.hotelApp.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

public class HomePage extends LoginPage{

	public void selectLocation(){
		selectIndexByXpath(prop.getProperty("Homepage.Location.xpath"), 2);
	}

	public void selectHotels(){
		selectIndexByXpath(prop.getProperty("Homepage.Hotels.xpath"), 1);
	}

	public void selectRoomType(){
		selectIndexByXpath(prop.getProperty("Homepage.RoomType.xpath"), 3);
	}

	public void selectNoOfRooms(){
		selectIndexByXpath(prop.getProperty("Homepage.NoOfRooms.xpath"), 5);
	}

	public void enterCheckInDate(){
		enterByXpath(prop.getProperty("Homepage.CheckInDate.xpath"), "10/05/2021");
	}

	public void enterCheckOutDate(){
		enterByXpath(prop.getProperty("Homepage.CheckOutDate.xpath"), "15/05/2021");
	}

	public void selectAdultPerRoom(){
		selectIndexByXpath(prop.getProperty("Homepage.AdultsperRoom.xpath"), 2);
	}

	public void selectchildernPerRoom(){
		selectIndexByXpath(prop.getProperty("Homepage.ChildrenperRoom.xpath"), 2);
	}

	public void clickSearch(){
		
		try {
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			test.log(Status.PASS, "Search Option Is Clicked Successfully");
			Reporter.log("Search Option Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Search Option Is Not Clicked");
			Reporter.log("Search Option Is Not Clicked");
		}
	}

	public void enterUname(String Uname){
		
		try {
			driver.findElement(By.id(prop.getProperty("LoginPage.username.id"))).sendKeys(Uname);
			test.log(Status.PASS, "Entered UserName Successfully");
			Reporter.log("Entered UserName Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "UserName Is Not Entered");
			Reporter.log("UserName Is Not Entered");
		}
			
	}

	public void enterPword(String Pword){
		try {
			driver.findElement(By.id(prop.getProperty("LoginPage.password.id"))).sendKeys(Pword);;
			test.log(Status.PASS, "Entered Password Successfully");
			Reporter.log("Entered Password Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Password Is Not entered");
			Reporter.log("Password Is Not entered");
		}
	
	}

	public void clickLoginButton(){
		try {
			driver.findElement(By.className(prop.getProperty("LoginPage.password.className"))).click();	
			test.log(Status.PASS, "Login Is Clicked Successfully");
			Reporter.log("Login Button Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Login Option Is Not Clicked");
			Reporter.log("Login Button Is Not Clicked");
		}
	}

	public void selectHotelRadio(){
		try {
			driver.findElement(By.cssSelector("#radiobutton_0")).click();
			test.log(Status.PASS, "Hotel Is Clicked Successfully");
			Reporter.log("Hotel Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Hotel Is Not Clicked");
			Reporter.log("Hotel Is Not Clicked");
		}
		
	}

	public void clickContinue(){
		try {
			driver.findElement(By.cssSelector("#continue")).click();
			test.log(Status.PASS, "Continue Is Clicked Successfully");
			Reporter.log("Continue Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Continue Is Not Clicked");
			Reporter.log("Continue Is Not Clicked");
		}
	}

	public void enterFirstName(String FName){
		enterByXpath(prop.getProperty("BookHotel.FirstName.xpath"), FName);
	}

	public void enterLastName(String LName){
		enterByXpath(prop.getProperty("BookHotel.LastName.xpath"), LName);
	}

	public void enterBillingAddress(String Address){
		enterByXpath(prop.getProperty("BookHotel.BillingAddress.xpath"), Address);
	}

	public void enterCreditCardNo(String CreditCardNo){
		enterByXpath(prop.getProperty("BookHotel.CreditNo.xpath"), CreditCardNo);
	}

	public void selectCartType(){
		selectIndexByXpath(prop.getProperty("BookHotel.CreditType.xpath"), 2);
	}

	public void selectMonth(){
		selectIndexByXpath(prop.getProperty("BookHotel.ExpiryDateMonth.xpath"), 2);
	}

	public void selectYear(){
		selectIndexByXpath(prop.getProperty("BookHotel.ExpiryDateYear.xpath"), 12);
	}

	public void enterCCV (String CVV){
		enterByXpath(prop.getProperty("BookHotel.CVVNumber.xpath"), CVV);
	}

	public void clickBookNow(){
		try {
			driver.findElement(By.xpath(prop.getProperty("BookHotel.BookNow.xpath"))).click();
			test.log(Status.PASS, "BookNow Option Is Clicked Successfully");
			Reporter.log("BookNow Option Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "BookNow Option Is Not Clicked");
			Reporter.log("BookNow Option Is Not Clicked");
		}
	}
	
	public void clickSearchHotel(){
		try {
			driver.findElement(By.xpath(prop.getProperty("BookForm.SearchHotel.xpath"))).click();
			test.log(Status.PASS, "Search Option Is Clicked Successfully");
			Reporter.log("Search Option Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Search Option Is Not Clicked");
			Reporter.log("Search Option Is Not Clicked");
		}
		
	}
	
	public void clickMyItinerary() throws InterruptedException{
		try {
			driver.findElement(By.xpath(prop.getProperty("BookHotel.MyItinerary.xpath"))).click();
			Thread.sleep(2000);
			test.log(Status.PASS, "MyItinerary Option Is Clicked Successfully");
			Reporter.log("MyItinerary Option Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "MyItinerary Option Is Not Clicked");
			Reporter.log("MyItinerary Option Is Not Clicked");
		}
	}

	public void GetCancelId() throws InterruptedException{

		WebElement element=driver.findElement(By.xpath(prop.getProperty("BookForm.GetCanceID.xpath")));
		String Name=element.getAttribute("value");
		System.out.println(" Cancel ID is " + Name);

		String[] ID=Name.split("\\s");

		try {
			 for(int i=1;i<ID.length;i++){
				String cancelID=ID[i];
				Thread.sleep(1000);
				enterByXpath(prop.getProperty("BookForm.SearchID.xpath"), cancelID);
			}
		} catch (Exception e) {

		}

	}
	
	public String GetOrderID(){

		WebElement element=driver.findElement(By.xpath(prop.getProperty("BookForm.OrderID.xpath")));
		String Name=element.getAttribute("value");
		return Name;
	}
	
	public void enterOrderID(){
        String ID=GetOrderID();
        System.out.println(" Order ID Is "+ID);
		enterByXpath(prop.getProperty("BookForm.SearchID.xpath"), ID);
	}
	
	public void clickGo(){
		
		try {
			driver.findElement(By.xpath(prop.getProperty("BookForm.Go.xpath"))).click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Go Option Is Clicked Successfully");
			Reporter.log("Go Option Is Clicked Successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Go Option Is Not Clicked");
			Reporter.log("Go Option Is Not Clicked");
		}
		
	}

	public void selectCancelID(){
		
		try {
			driver.findElement(By.xpath(prop.getProperty("BookForm.CancelID.xpath"))).click();
			Thread.sleep(2000);
			test.log(Status.PASS, "Cancel ID Is Clicked");
			Reporter.log("Cancel ID Is Clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, "Cancel ID Is Not Clicked");
			Reporter.log("Cancel ID Is Not Clicked");
		}
	}
	
	public void clickCencel(){
		
		try {
			driver.findElement(By.xpath(prop.getProperty("BookForm.Cancel.xpath"))).click();
			AlertAccept();
			test.log(Status.PASS, "Cancel option Is Clicked");
			Reporter.log("Cancel option Is Clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, "Cancel option Is Not Clicked");
			Reporter.log("Cancel option Is Not Clicked");
		}
	}
	
	public void clickLogOut(){
	
		try {
			driver.findElement(By.xpath(prop.getProperty("Homepage.Logout.xpath"))).click();
			test.log(Status.PASS, "Logout option Is Clicked");
			Reporter.log("Logout option Is Clicked");
		} catch (Exception e) {
			test.log(Status.FAIL, "Logout option Is Not Clicked");
			Reporter.log("Logout option Is Not Clicked");
		}
	}
	
	public void verifyText(){
		
		WebElement element=driver.findElement(By.xpath(prop.getProperty("Homepage.Verify.xpath")));
		String Actual=element.getText();
		
		try {
			if(Actual.equals(prop.getProperty("Expected"))){
				test.log(Status.PASS, "Actual Result Is " + Actual + " Matched with Expected");
				Reporter.log("Actual Result Is " + Actual + " Matched with Expected");
			}else{
				test.log(Status.FAIL, "Actual Result Is " + Actual + " Not Matched with Expected");
				Reporter.log("Actual Result Is " + Actual + " Not Matched with Expected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
