package com.guru99.qa.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileOutputStream fos;
	
	public static int getRowCount(String xlfile, String xlSheet) throws IOException {
		 fis=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(xlSheet);
		 int rowCount=sheet.getLastRowNum();
		 return rowCount;
	}
	
	public static int getCellCount(String xlfile, String xlSheet, int rownum) throws IOException {
		 fis=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(xlSheet);
		 row=sheet.getRow(rownum);
		 int cellcount=row.getLastCellNum();
		 return cellcount;
	}
	
	public static String getcellData(String xlfile, String xlSheet, int rownum, int column) throws IOException {
		 fis=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(xlSheet);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(column);
		 String data;
		 try {
		 DataFormatter formatter=new DataFormatter();
		 String cellData=formatter.formatCellValue(cell);
		 return cellData;
		 }catch(Exception e) {
			 data=""; 
		 }
		 wb.close();
		 fis.close();
		 return data; 
	}
	
	public static void setCellData(String xlfile, String xlSheet, int rownum, int column,String data) throws IOException {
		 fis=new FileInputStream(xlfile);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(xlSheet);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(column);
		 fos=new FileOutputStream(xlfile);
		 wb.close();
		 fis.close();
		 fos.close();
	}

}
