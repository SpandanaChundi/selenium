package stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	WebDriver driver;
	FileInputStream Fis;
	Properties pr;
	
	@Given("^User on Ranford Home Page$")
	public void User_on_Ranford_Home_Page() throws Throwable {
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		
	}
	@When("^User enters valid Username and Password$")
	public void User_enters_valid_Username_and_Password() throws IOException {
		
		Fis=new FileInputStream("C:\\Users\\91817\\eclipse-workspace\\Cucumberproject\\Rep.properties");
		pr.load(Fis);
		
		driver.findElement(By.id(pr.getProperty("Uname"))).sendKeys("Admin");
		driver.findElement(By.id(pr.getProperty("LPswd"))).sendKeys("TestingMindq");
		driver.findElement(By.xpath(pr.getProperty("Lgn"))).click();
		
		
	}
	@Then("^Verifying Admin login validation$")
	public void Verifying_Admin_login_validation() throws Throwable {
		String Expval="Welcome to Admin";
		String Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
        if (Expval.equalsIgnoreCase(Actval)) {
			
			System.out.println("Admin login succesful");
			
		}
		else {
			System.out.println("Admin login failed");
		}
	}
	@When("^User clicks on Logout$")
	public void User_clicks_on_Logout() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\\\"Table_02\\\"]/tbody/tr/td[3]/a/img"));
		
	}

}
