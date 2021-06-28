package com.hotelApp.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hotelApp.Pages.HomePage;

public class Login_BookHotel extends HomePage{

	@BeforeClass
	public void setValues(){
		dataSheetName="BookHotel";
		testName="Login And Book Hotel";
		description="Book Hotel";
	}
	
	@Test(dataProvider="fetchData")
	public void SearchHotel(String Uname,String Pword,String FirstName,
			                String LastName,String Address,
			                String CreditCardNo,String CVV){
	    enterUname(Uname);
	    enterPassword(Pword);
	    clickLoginButton();
		selectLocation();
		selectHotels();
		selectRoomType();
		selectNoOfRooms();
		enterCheckInDate();
		enterCheckOutDate();
		selectAdultPerRoom();
		selectchildernPerRoom();
		clickSearch();
		selectHotelRadio();
		clickContinue();
		enterFirstName(FirstName);
		enterLastName(LastName);
		enterBillingAddress(Address);
		enterCreditCardNo(CreditCardNo);
		selectCartType();
		selectMonth();
		selectYear();
		enterCCV(CVV);
		clickBookNow();	
	}
	
}
