package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReaderForLoop {
	public static void main(String args[]) throws Exception {
		
		File src=new File("/Users/sapnamishra/Documents/TestData/loginData.xls");
		FileInputStream fis=new FileInputStream(src);
		HSSFWorkbook wb=new HSSFWorkbook(fis);//HSSFWorkbook for xls  // XSSFWorkbook for xlxs
		HSSFSheet sheet1=wb.getSheetAt(0);
		int rowCnt= sheet1.getLastRowNum();
		System.out.println("Total rows are --- "+rowCnt+1);
		for (int i = 0; i < rowCnt; i++) {
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("test data from row "+i+" is ---"+ data0);
			
		}
		wb.close();
		
	
	}
}
