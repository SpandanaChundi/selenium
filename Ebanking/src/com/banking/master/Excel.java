package com.banking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static void main(String[] args) throws IOException {
		
		//Instance Class
		
		Library LB=new Library();
		
		LB.openApp("http://103.211.39.246/ranford2");
		LB.AdminLgn("Admin", "TestingMindq");
		
		//To get test data file
		
		FileInputStream Fis=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\testdata\\Roledata.xlsx");
		
		//Workbook
		
		XSSFWorkbook WB=new XSSFWorkbook(Fis);
		
		//Sheets
		
		XSSFSheet WS=WB.getSheet("Roledata");
		
		//Row Count 
		
		int Rcount= WS.getLastRowNum();
		System.out.println(Rcount);
		
		//Multiple iterations---Loop
		
		for (int i =1; i <=Rcount; i++) {
			
			
			//Row
			
			XSSFRow WR=WS.getRow(i);
			
			//Cell
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			XSSFCell WC2=WR.createCell(2);
			
			//Get cell Values
			
			String Rlnme=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();
			
			String Res= LB.Rolecreation(Rlnme);
			System.out.println(Res);
			
			//Results
			
			WC2.setCellValue(Res);
			
			
			
			
			
			
			
			
			
		}
		
		//Results Excel file
		
		FileOutputStream FOS=new FileOutputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\results\\Res_Roledata.xlsx");
		WB.write(FOS);
		WB.close();
		
			
		}
		
		

		
	}
	
	


