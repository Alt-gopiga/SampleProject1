package com.hotelApp.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hotelApp.Pages.HomePage;

public class Login_SearchHotel extends HomePage {

	@BeforeClass
	public void setValue(){
		dataSheetName="LoginData";
		testName="Login And Search Hotel";
		description="Search Hotel";
	}
	
	@Test(dataProvider="fetchData")
	public void SearchHotel(String Uname,String Pword){
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
		
	}
}
