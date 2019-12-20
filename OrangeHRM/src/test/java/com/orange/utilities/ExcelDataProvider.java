package com.orange.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File file= new File("./TestData/data.xlsx");
		
		try {
			FileInputStream fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel: "+e.getMessage());
		} 
	}
	
	public String getStringData(String sheetName, int rownum, int colnum) {
		
		return wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	
    public String getStringData(int sheetIndex, int rownum, int colnum) {
		
		return wb.getSheetAt(sheetIndex).getRow(rownum).getCell(colnum).getStringCellValue();
	}
	
    public double getNumericData(String sheetName, int rownum, int colnum) {
		
		return wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
	}
    
    public int getIntegerData(String sheetName, int rownum, int colnum) {
		
		return (int)wb.getSheet(sheetName).getRow(rownum).getCell(colnum).getNumericCellValue();
	}

	

}
