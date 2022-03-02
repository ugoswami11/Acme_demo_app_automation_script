package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;


public class loginPage {
	
	public static WebDriver driver;
	
	@Test(priority = 0)
	@Given("user is navigated to ACME website")
	public void user_is_navigated_to_acme_website() {
		
	    String execPath = System.getProperty("user.dir") + "\\resources\\webDrivers\\chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", execPath);
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    
	    String url = "https://demo.applitools.com/index.html#";
	    driver.get(url);
	    
	    //driver.close();
	    
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Test (priority = 1)
	@When("user enter the login credentials")
	public void user_enter_the_login_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		
	  //  throw new io.cucumber.java.PendingException();
	}
	
	@Test (priority = 2)
	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.id("log-in")).click();
		
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Test (priority = 3)
	@Then("user is navigated to homepage of ACME app")
	public void user_is_navigated_to_homepage_of_acme_app() {
	    // Write code here that turns the phrase above into concrete actions
		TakesScreenshot ss = ((TakesScreenshot)driver);
		
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(System.getProperty("user.dir")+"\\resources\\screenshots\\homepage.png");
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
	    //throw new io.cucumber.java.PendingException();
	}


}
