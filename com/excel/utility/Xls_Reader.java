package com.excel.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class Xls_Reader {
	public static void main(String args[]) throws Exception {
	
		File src=new File("/Users/sapnamishra/Documents/TestData/loginData.xls");
		FileInputStream fis=new FileInputStream(src);
		HSSFWorkbook wb=new HSSFWorkbook(fis);//HSSFWorkbook for xls  // XSSFWorkbook for xlxs
		HSSFSheet sheet1=wb.getSheetAt(0);
		String data0= sheet1.getRow(1).getCell(0).getStringCellValue();
		System.out.println("Data from excel --- "+data0);
		String data1= sheet1.getRow(1).getCell(1).getStringCellValue();
		System.out.println("Data from excel --- "+data1);
		wb.close();
		
	
	}

}
