package com.banking.master;

import java.io.IOException;

public class Exelibry {

	public static void main(String[] args) throws IOException {
		//Instance class
		
		Library LB=new Library();
		
		String Rtnv=LB.openApp("http://103.211.39.246/ranford2");
		System.out.println(Rtnv);
		LB.AdminLgn("Admin","TestingMindq");
		LB.Branches("mindqsystems4","SR nagar","56789");
		LB.Rolecreation("spand");
		LB.Employeecreation("Admin4","Mindq@Systems");
		LB.Logout();
		LB.close();

	}

}
