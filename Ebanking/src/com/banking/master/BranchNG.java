package com.banking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNG extends Base{
	@Test(dataProvider="Brdata")
	public void Brnch(String Bn,String Adrs,String pin) {
		
		LB.Branches(Bn, Adrs, pin);
	}
	
@DataProvider
	
	public Object[][] Brdata(){
		
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="Mqsystm";
		obj[0][1]="SR nagar";
		obj[0][2]="45678";
		
		obj[1][0]="Mqsystm1";
		obj[1][1]="hyderabad";
		obj[1][2]="12345";
		
		obj[2][0]="Mqsystm2";
		obj[2][1]="vizag";
		obj[2][2]="67891";
		
		return obj;
		
	}


}
