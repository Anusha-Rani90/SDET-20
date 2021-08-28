package com.vtiger.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
//	It is used to read the data from excel
	public String getDataFromExcel(String Sheet, int rowNum ,int cellNum) throws IOException {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheet);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
//	It is used to get the last used row on specified sheet
	
	public int getRowCount(String sheet) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		wb.close();
		return sh.getLastRowNum();
	}
	
//	It is used to write the data into the excel sheet
	
	public void setDataIntoExcel(String sheet,int rowNum,int cellNum, String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./data.testscript.xlsx") ;
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet(sheet);
		 Row row = sh.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		 cell.setCellValue(data);
		 FileOutputStream fos=new FileOutputStream("./data.testscript.xlsx");
		 wb.write(fos);
		 wb.close();
	}
	
	

}
