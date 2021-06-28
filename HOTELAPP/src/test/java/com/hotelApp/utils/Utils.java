package com.hotelApp.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utils {

	public String dataSheetName;
	
	
	@DataProvider(name="fetchData")
	public Object[][] getdata(){
		return getSheet(dataSheetName);
		
	}
	
	public Object[][] getSheet(String dataSheetName) {

		Object[][] data = null;

		try {
			
			FileInputStream fis = new FileInputStream(new File("./data/"+dataSheetName+".xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];

			for(int i=1; i <rowCount+1; i++){
				XSSFRow row = sheet.getRow(i);
				for(int j=0; j <columnCount; j++)
				{ 		
					String cellValue = row.getCell(j).getStringCellValue();
					data[i-1][j]  = cellValue;
				}
			  }
			fis.close();
			workbook.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return data;		
	}
	}