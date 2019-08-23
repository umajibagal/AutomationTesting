package com.nichethyself.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		
		try {
			File file = new File("./TestData/TestData.xlsx");
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read excel file"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Unable to read excel file"+e.getMessage());
		}
	}
	
	public String getStringData(int sheetIndex,int row,int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericDdata(String sheetName,int row,int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
}
