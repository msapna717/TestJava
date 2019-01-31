package com.dataDrivenTesting;

import com.test.utility.ExcelDataConfig;

public class DataReading {

	public static void main(String[] args) {
		ExcelDataConfig excel=new ExcelDataConfig("/Users/sapnamishra/Documents/workspace/TestJava/src/com/testData/testDataProvider.xls");
		System.out.println(excel.getData(1, 0, 0));

	}

}
