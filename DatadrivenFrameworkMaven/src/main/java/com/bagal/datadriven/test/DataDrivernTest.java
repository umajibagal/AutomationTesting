package com.bagal.datadriven.test;

import com.bagal.excel.utility.Xls_Reader;

public class DataDrivernTest {
	public static void main(String[] args) {

		String path = "C:\\amt-eclipse-workspace\\datadrivenframework\\src\\main\\java\\com\\bagal\\testdata\\demo.xlsx";
		Xls_Reader reader = new Xls_Reader(path);

		String sheetName = "test";

		int rowNum = 3;

		String excelHeader[] = new String[reader.getColumnCount(sheetName)];	
		
		for (int i = 0; i < excelHeader.length; i++) {
			excelHeader[i] = reader.getCellData(sheetName, i, 1);
			
		}
		int f=0;
		for (int i = 0; i < excelHeader.length; i++) {
			if(excelHeader[i].equals("status"))
				f=1;
		}
		
		if(f==0)
		{
			reader.addColumn(sheetName, "status");
			System.out.println("col is created");
		}
		else
			System.out.println("col is present");
		
		for (int i = 2; i <= reader.getRowCount(sheetName); i++) {
			for (int j = 0; j < excelHeader.length; j++) {
					if(excelHeader[j].equals("status"))
						reader.setCellData(sheetName, excelHeader[j], i, "pass");
					System.out.print("    " + reader.getCellData(sheetName, excelHeader[j], i));
			}
			System.out.println();
		}
	}
}
