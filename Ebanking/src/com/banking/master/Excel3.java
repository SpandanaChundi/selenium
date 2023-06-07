package com.banking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel3 {

	public static void main(String[] args) throws IOException {
		
		Library lb=new Library();
		lb.openApp("http://103.211.39.246/ranford2");
		lb.AdminLgn("Admin", "Mindq@Systems");
		
		FileInputStream fis=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\testdata\\BRdata.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Empdata");
		
		int rcount=ws.getLastRowNum();
		System.out.println(rcount);
		
		for (int i = 0; i <=rcount; i++) {
			
			XSSFRow xr=ws.getRow(i);
			
			XSSFCell xc=xr.getCell(0);
			XSSFCell xc1=xr.getCell(1);
			XSSFCell xc2=xr.createCell(2);
			
			String emlnme=xc.getStringCellValue();
			String paswd=xc1.getStringCellValue();
			
			
			String res=lb.Employeecreation(emlnme, paswd);
			System.out.println(res);
			
			xc2.setCellValue(res);
			
			
			
		}
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\results\\Res_Empldata.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
		

	}

}
