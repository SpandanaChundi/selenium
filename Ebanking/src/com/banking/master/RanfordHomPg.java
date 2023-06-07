package com.banking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHomPg {
	
	//element properties
	
	@FindBy (id="txtuId")
	WebElement Uname;
	
	@FindBy (id="txtPword")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id=\'login\']")
	WebElement Lgn;
	
	//element Methods
	
	public void login() {
		
		Uname.sendKeys("Admin");
		pwd.sendKeys("Mindq@Systems");
		Lgn.click();
	}
	
	
	

	

}
