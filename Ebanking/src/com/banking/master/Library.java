package com.banking.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	public static WebDriver driver;
	public static String Expval,Actval;
	public static FileInputStream FIS;
	public static Properties PR;
	
	public String openApp(String URL) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\91817\\eclipse-workspace\\Ebanking\\geckodriver.exe");
		
		FIS=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Ebanking\\src\\com\\banking\\properties\\Rep.properties");
		PR=new Properties();
		PR.load(FIS);
		
		Expval="Ranford Bank";
		driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		 Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//compare statement
		
		if (Expval.equalsIgnoreCase(Actval)) {
			System.out.println("Application launch sucessfully");
			
		}
		else {
			
			System.out.println("Application failed to launch");
		}
		String tit=driver.getTitle();
		System.out.println(tit);
		
		return "pass";
		
		
	}
	
	public String AdminLgn(String Un,String Pwd) {
		
        Expval="Welcome to Admin";
		
		driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("LPswd"))).sendKeys(Pwd);
		driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		if (Expval.equalsIgnoreCase(Actval)) {
			
			System.out.println("Admin login succesful");
			
		}
		else {
			System.out.println("Admin login failed");
		}
		return "pass";
		   
		
		
	}
	public String Branches(String Brn,String Addr,String Pwd) {

		Expval="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
		driver.findElement(By.id(PR.getProperty("NBbtn"))).click();
		driver.findElement(By.id(PR.getProperty("TextNm"))).sendKeys(Brn);
		driver.findElement(By.id(PR.getProperty("Addrs"))).sendKeys(Addr);
		driver.findElement(By.id(PR.getProperty("Zip"))).sendKeys(Pwd);
		
		
		//drop downs
		
		Select Ctry=new Select(driver.findElement(By.id(PR.getProperty("Country"))));
		Ctry.selectByVisibleText("INDIA");
		
		Select stt=new Select(driver.findElement(By.id(PR.getProperty("State"))));
		stt.selectByVisibleText("Delhi");
		new Select(driver.findElement(By.id(PR.getProperty("City")))).selectByVisibleText("Delhi");
		
		driver.findElement(By.id(PR.getProperty("Submtbutn"))).click();
		
		// Alert
		
		Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("Branch created");
			
		}
		else {
			System.out.println("Branch already exist");
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath(PR.getProperty("BakHom"))).click();
		return "pass";
		
		
		
	}
	
	public String Rolecreation(String Rln) {
		
        Expval="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("RleBtn"))).click();
		driver.findElement(By.id(PR.getProperty("NwRle"))).click();
		driver.findElement(By.id(PR.getProperty("TxtRn"))).sendKeys(Rln);
		
		Select roltpe=new Select(driver.findElement(By.id(PR.getProperty("RleTyp"))));
		roltpe.selectByVisibleText("C");
		
		driver.findElement(By.xpath("//*[@id=\'btninsert\']")).click();
		
		Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("New Role created");
			
		}
		else {
			System.out.println("Role existed");
		}
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		return "success";
		
		
		
	}
	
	public String Employeecreation(String Un,String Pwd) {
		
        Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
          //driver.findElement(By.xpath(PR.getProperty("Empbtn"))).click();
        
        driver.findElement(By.id(PR.getProperty("NwEmp"))).click();
		driver.findElement(By.id(PR.getProperty("EmNme"))).sendKeys(Un);
		driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
		
		Select role=new Select(driver.findElement(By.id(PR.getProperty("RolNme"))));
		role.selectByVisibleText("Manager");
		
		Select brn=new Select(driver.findElement(By.id(PR.getProperty("Brnch"))));
		brn.selectByVisibleText("mindqsystems4");
		
		driver.findElement(By.id(PR.getProperty("EmBttn"))).click();
		
        Actval=driver.switchTo().alert().getText();
		
		if (Actval.contains(Expval)) {
			
			System.out.println("New Employee created ");
			
		}
		else {
			System.out.println("Employee existed");
		}
		
		driver.switchTo().alert().accept();
		
		//Home
		
		driver.findElement(By.xpath(PR.getProperty("BakHom"))).click();
		
		return "success";
		
		
		
		
		
		
	}
	
	public String Logout() {
		
		//driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		driver.findElement(By.xpath(PR.getProperty("Logout"))).click();
		return "pass";
		
		
	}
	
	public String close() {
		
		driver.close();
		return "pass";
		
	}

}
