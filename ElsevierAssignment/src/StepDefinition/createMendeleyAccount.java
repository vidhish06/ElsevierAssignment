package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class createMendeleyAccount {
	
	WebDriver driver;
	
	@Given("^Launched url https://www.mendeley.com in Firefox browser$")
	
	public void Launched_url_https_www_mendeley_com_in_Firefox_browser() throws Throwable {

		System.setProperty("webdriver.gecko.driver", "./src//geckodriver//geckodriver.exe");
		
		
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
		
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mendeley.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Given("^create free account button is clicked$")
	public void create_free_account_button_is_clicked() throws Throwable {
	
		driver.findElement(By.xpath("html/body/div[1]/header/div/div/nav/ul/li[3]/a")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@When("^Entered valid email id and Continue button is clicked$")
	public void Entered_valid_email_id_and_Continue_button_is_clicked() throws Throwable {
		
		driver.findElement(By.id("email")).sendKeys("testMendleyCreateaccount12@gmail.com");
		driver.findElement(By.id("els-continue")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@When("^Entered valid Name, FamilyName and password and Register button is clicked and verify message displayed You are registered with continue to Mendeley button$")
	public void Entered_valid_Name_FamilyName_and_password_and_Register_button_is_clicked_and_verify_message_displayed_You_are_registered_with_continue_to_Mendeley_button() throws Throwable {
		driver.findElement(By.id("givenName")).sendKeys("autotest_givenName");
		driver.findElement(By.id("familyName")).sendKeys("autotest_familyName");
		driver.findElement(By.id("password")).sendKeys("Autotest@1234");
		driver.findElement(By.xpath("html/body/div/form[2]/section/main/button")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.close();
	}
	@Then("^Validated message displayed that You are registered with continue to Mendeley button$")
	public void Validated_message_displayed_that_You_are_registered_with_continue_to_Mendeley_button() throws Throwable {
	
		boolean Error = driver.getPageSource().contains("You are registered");
		
		if (Error == true)
	    {
	     System.out.print("Account is registered successfully");
	    }
	    else
	    {
	     System.out.print("Account is not register successfully");
	    }
		
		driver.close();
	}
}
