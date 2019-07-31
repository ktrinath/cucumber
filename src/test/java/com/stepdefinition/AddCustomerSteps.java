package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCustomerSteps {
	static WebDriver driver;
	@Given("User is in telecom home page")
	public void user_is_in_telecom_home_page() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Trinath\\eclipse-workspace\\cucumber1\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/telecom/");
		driver.manage().window().maximize();
		
	}

	@Given("User click on add customer")
	public void user_click_on_add_customer() {
		driver.findElement(By.xpath("(//a[text()='Add Customer'])[1]")).click();
	}

	/*@When("User filling all the fields")
	public void user_filling_all_the_fields() {
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys("Trinath");
		driver.findElement(By.id("lname")).sendKeys("k");
		driver.findElement(By.id("email")).sendKeys("ktk@gmail.com");
		driver.findElement(By.name("addr")).sendKeys("Hyderabad");
		driver.findElement(By.id("telephoneno")).sendKeys("7981971323");
		
	}*/
	
	/*@When("User filling all the fields.")
	public void user_filling_all_the_fields(DataTable custDatas) {
		List<String> al = custDatas.asList(String.class);
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(al.get(0));
		driver.findElement(By.id("lname")).sendKeys(al.get(1));
		driver.findElement(By.id("email")).sendKeys(al.get(2));
		driver.findElement(By.name("addr")).sendKeys(al.get(3));
		driver.findElement(By.id("telephoneno")).sendKeys(al.get(4));
	}
	*/
	@When("User filling all the field")
	public void user_filling_all_the_field(DataTable cusDatas) {
		
		Map<String, String> asMap = cusDatas.asMap(String.class, String.class);
		
		driver.findElement(By.xpath("//label[@for='done']")).click();
		driver.findElement(By.id("fname")).sendKeys(asMap.get("fname"));
		driver.findElement(By.id("lname")).sendKeys(asMap.get("laname"));
		driver.findElement(By.id("email")).sendKeys(asMap.get("mail"));
		driver.findElement(By.name("addr")).sendKeys(asMap.get("address"));
		driver.findElement(By.id("telephoneno")).sendKeys(asMap.get("phno"));
	   
	}
	

	@When("User click on submit buttom")
	public void user_click_on_submit_buttom() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	}

	@Then("User should get customer unique Id")
	public void user_should_get_customer_unique_Id() {
		Assert.assertTrue(driver.findElement(By.xpath("//td[@align='center'][2]")).isDisplayed());
	   
	}


}
