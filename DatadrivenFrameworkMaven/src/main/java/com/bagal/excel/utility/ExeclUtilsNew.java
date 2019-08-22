package com.bagal.excel.utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclUtilsNew {

	public void ReadExcel(String Filename, String FilePath, String Sheetname) throws IOException {

		File file = new File(FilePath + "\\" + Filename);
		FileInputStream in = new FileInputStream(file);

		Workbook read = null;

		// getting filename extension

		String fileExtension = Filename.substring(Filename.indexOf("."));
		System.out.println("FileName Extension\t" + fileExtension);

		// check condition as per file extension

		if (fileExtension.equals(".xlsx")) {
			read = new XSSFWorkbook(in);

		} else {
			read = new HSSFWorkbook(in);

		}

		// Read the sheet
		org.apache.poi.ss.usermodel.Sheet sRead = read.getSheet(Sheetname);

		// get number of rows

		int rowCount = sRead.getLastRowNum() - sRead.getFirstRowNum();

		for (int i = 1; i <= rowCount; i++) {

			Row row = sRead.getRow(i);
			// String srow = row.toString();
			// System.out.println(srow);
			for (int j = 1; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}
			System.out.println();
		}
		// System.out.println();

	}

	public void WriteExcel(String Filename, String FilePath, String Sheetname, String[] dWrite) throws IOException {

		Workbook writeExcel = null;
		File file = new File(FilePath + "\\" + Filename);
		System.out.println(file.toString());
		FileInputStream in = new FileInputStream(file);

		String fileExtensionName = Filename.substring(Filename.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			writeExcel = new XSSFWorkbook(in);

		} else {

			writeExcel = new HSSFWorkbook(in);

		}

		org.apache.poi.ss.usermodel.Sheet sRead = writeExcel.getSheet(Sheetname);
		int rowCount = sRead.getLastRowNum() - sRead.getFirstRowNum();
		System.out.println(rowCount);
		Row nRow = sRead.getRow(0);
		Row nwRow = sRead.createRow(rowCount + 1);
		// System.out.println(nRow.getLastCel);
		for (int j = 0; j < nRow.getLastCellNum(); j++) {
			// System.out.println("inside");
			Cell cell = nwRow.createCell(j);
			// System.out.println(dWrite[j]);
			cell.setCellValue(dWrite[j]);

		}

		in.close();

		FileOutputStream out = new FileOutputStream(file);
		writeExcel.write(out);
		out.close();

	}

	public void WriteExcelRow(String Filename, String FilePath, String Sheetname, int row, int Column, String Data)
			throws IOException {
		{

			Workbook writeExcel = null;
			File file = new File(FilePath + "\\" + Filename);
			System.out.println(file.toString());
			FileInputStream in = new FileInputStream(file);

			String fileExtensionName = Filename.substring(Filename.indexOf("."));

			// Check condition if the file is xlsx file
			if (fileExtensionName.equals(".xlsx")) {

				writeExcel = new XSSFWorkbook(in);

			} else {

				writeExcel = new HSSFWorkbook(in);

			}

			org.apache.poi.ss.usermodel.Sheet sRead = writeExcel.getSheet(Sheetname);
			
			Row rRow = sRead.getRow(row);
			Cell sCell = rRow.getCell(Column);
			if  (sCell == null)
			{
				
				Cell cCell = rRow.createCell(Column);
				cCell.setCellValue(Data);
				
			}
			else
			{
				sCell.setCellValue(Data);
				
			}
			
			in.close();

			FileOutputStream out = new FileOutputStream(file);
			writeExcel.write(out);
			out.close();


			
		}
	}
}