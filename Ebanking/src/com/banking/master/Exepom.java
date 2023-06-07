package com.banking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Exepom {
	
	@Test
	public void pom() {
	
	
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://103.211.39.246/ranford2");
	
	//PageFactory
	
	RanfordHomPg RHmp=PageFactory.initElements(driver, RanfordHomPg.class);
	RHmp.login();
	
	AdminHmpg AHmp=PageFactory.initElements(driver, AdminHmpg.class);
	AHmp.Br();
	
	
	
	}

}
