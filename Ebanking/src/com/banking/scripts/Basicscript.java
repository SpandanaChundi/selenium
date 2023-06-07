package com.banking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Basicscript {

	public static void main(String[] args) {
		String Expval="Ranford Bank";
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		String Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//compare statement
		
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Application launch sucessfully");
			
		}
		else {
			
			System.out.println("Application failed to launch");
		}
		String tit=driver.getTitle();
		System.out.println(tit);
		
		//Admin login
		
		Expval="Welcome to Admin";
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Mindq@Systems");
		driver.findElement(By.xpath("//*[@id=\'login\']")).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		if (Expval.equalsIgnoreCase(Actval)) {
			
			System.out.println("Admin login succesful");
			
		}
		else {
			System.out.println("Admin login failed");
		}
		
		//Branch creation
		
		Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
		driver.findElement(By.id("BtnNewBR")).click();
		driver.findElement(By.id("txtbName")).sendKeys("mindqsystems4");
		driver.findElement(By.id("txtAdd1")).sendKeys("SR nagar");
		driver.findElement(By.id("txtZip")).sendKeys("56789");
		
		
		//drop downs
		
		Select Ctry=new Select(driver.findElement(By.id("lst_counrtyU")));
		Ctry.selectByVisibleText("INDIA");
		
		Select stt=new Select(driver.findElement(By.id("lst_stateI")));
		stt.selectByVisibleText("Delhi");
		new Select(driver.findElement(By.id("lst_cityI"))).selectByVisibleText("Delhi");
		
		driver.findElement(By.id("btn_insert")).click();
		
		// Alert
		
		Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("Branch created");
			
		}
		else {
			System.out.println("Branch already exist");
		}
		
		driver.switchTo().alert().accept();
		
		//Home
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		//Role creation
		
		Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("spand");
		
		Select roltpe=new Select(driver.findElement(By.id("lstRtypeN")));
		roltpe.selectByVisibleText("C");
		
		driver.findElement(By.xpath("//*[@id=\'btninsert\']")).click();
		
		Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("Role creation sucessful");
			
		}
		else {
			System.out.println("Role creation failed");
		}
		
		driver.switchTo().alert().accept();
		
		//Home
		
		//driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		//Employee creation
		
		Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		driver.findElement(By.id("BtnNew")).click();
		driver.findElement(By.id("txtUname")).sendKeys("Admin4");
		driver.findElement(By.id("txtLpwd")).sendKeys("Mindq@Systems");
		
		Select role=new Select(driver.findElement(By.id("lst_Roles")));
		role.selectByVisibleText("Manager");
		
		Select brn=new Select(driver.findElement(By.id("lst_Branch")));
		brn.selectByVisibleText("mindqsystems4");
		
		driver.findElement(By.id("BtnSubmit")).click();
		
        Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("Employee creation sucessful");
			
		}
		else {
			System.out.println("Employee creation failed");
		}
		
		driver.switchTo().alert().accept();
		
		//Home
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		
		
		
		
		
		
		
		
		
	
		System.out.println("success");

	}
	
}
