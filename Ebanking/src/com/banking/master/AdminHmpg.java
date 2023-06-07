package com.banking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHmpg {
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
	WebElement Branch;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
	WebElement Role;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
	WebElement Employe;
	
	@FindBy(xpath="//*[@id=\\\"Table_02\\\"]/tbody/tr/td[3]/a/img")
	WebElement Logout;
	
	
	public void Br() {
		
		Branch.click();
		
		
	}
	
	public void Rol() {
		
		Role.click();
	}
	
	public void Empl() {
		
		Employe.click();
		
		
	}
	
	public void Lgout() {
		
		Logout.click();
		
		
	}

}
