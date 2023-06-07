package com.banking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {

	public static void main(String[] args) throws IOException {
		
		Library lb=new Library();
		lb.openApp("http://103.211.39.246/ranford2");
		lb.AdminLgn("Admin", "TestingMindq");
		
		FileInputStream fis=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\testdata\\BRdata.xlsx");
		
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet xs=wb.getSheet("BRdata");
		int row=xs.getLastRowNum();
		System.out.println(row);
		
		for (int i = 1; i <=row; i++) {
			
			XSSFRow xr=xs.getRow(i);
			
			
			XSSFCell wc=xr.getCell(0);
			XSSFCell wc1=xr.getCell(1);
			XSSFCell wc2=xr.getCell(2);
			
			String brnm=wc.getStringCellValue();
			String addrss=wc1.getStringCellValue();
			String pncd=wc2.getStringCellValue();
			
			lb.Branches(brnm, addrss, pncd);
			
			System.out.println(brnm);
			
			
			
			
		}
		
		wb.close();
		
		 

	}

}
