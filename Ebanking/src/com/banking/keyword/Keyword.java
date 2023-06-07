package com.banking.keyword;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.banking.master.*;
public class Keyword {

	public static void main(String[] args) throws IOException {
		
		Library Lb=new Library();
		String Res=null;
		
		
		
		FileInputStream FIS=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\keyword\\keyword_data.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(FIS);
		
		XSSFSheet ws=wb.getSheet("TestCase");
		XSSFSheet ws1=wb.getSheet("TestSteps");
		
		int tcrc=ws.getLastRowNum();
		System.out.println(tcrc);
		
		int tsrc=ws1.getLastRowNum();
		System.out.println(tsrc);
		
		for (int i=1; i<=tcrc; i++) {
			
			String exe=ws.getRow(i).getCell(2).getStringCellValue();
			if (exe.equalsIgnoreCase("Y")) {
				
				String tcId=ws.getRow(i).getCell(0).getStringCellValue();
				System.out.println(tcId);
				
				//test steps
				
				for (int j=1; j<=tsrc; j++) {
					
					String tstcId=ws1.getRow(j).getCell(0).getStringCellValue();
					if (tcId.equalsIgnoreCase(tstcId)) {
						String Key=ws1.getRow(j).getCell(3).getStringCellValue();
						System.out.println(Key);
						switch (Key) {
						case "RLanch":
							Res=Lb.openApp("http://103.211.39.246/ranford2");
							break;
						case "RLogin":
							Res=Lb.AdminLgn("Admin", "TestingMindq");
							break;
						case "RLogout":
							Res=Lb.Logout();
							break;
						case "RBranch":	
							Res=Lb.Branches("mindqsystems4","SR nagar","56789");
							break;
						case "RRole":
							Res=Lb.Rolecreation("spand");
							break;
						case "RClose":
							Res=Lb.close();
							break;

						default:
							System.out.println("pass a valid Keyword");
							break;
						}
						//results update in the test step sheet
						ws1.getRow(j).createCell(4).setCellValue(Res);
						
						//result update in the test case sheet
						if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail")) {
							
							ws.getRow(i).createCell(3).setCellValue(Res);
							
							
						}
						else {
							ws.getRow(i).createCell(3).setCellValue("Fail");
						}
						
						
						
						
					}
					
					
					
				}
				
				
			}
			else {
				ws.getRow(i).createCell(3).setCellValue("BLOCKED");
			}
			
			
		}
		
		FileOutputStream Fo=new FileOutputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\keyword\\Res_keyword_data.xlsx");
		wb.write(Fo);
		wb.close();
		
		
		

	}

}
