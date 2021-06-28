package com.hotelApp.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hotelApp.Pages.HomePage;

public class Login_Cancel_Booking extends HomePage{
	
	@BeforeClass
	public void setValue(){
		dataSheetName="BookHotel";
		testName="Login - Book And Cancel Hotel";
		description="Book And Cancel Hotel";
	}
	
	@Test(dataProvider="fetchData")
	public void SearchHotel(String Uname,String Pword,String FirstName,
                            String LastName,String Address,
                            String CreditCardNo,String CVV)throws InterruptedException{
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
		clickMyItinerary();
		GetCancelId();
		clickGo();
		selectCancelID();
		clickCencel();
		clickLogOut();
		verifyText();
		
	}
	
}
