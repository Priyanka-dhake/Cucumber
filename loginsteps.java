package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class sawglabsserach {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step-browser is open");
		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step-user is on google search page");
		driver.navigate().to("https://www.saucedemo.com/");	


	}

	@When("user enters a text in search box") 
	public void user_enters_a_text_in_search_box()  throws InterruptedException{
		System.out.println("Inside Step-user enters a text in search box");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);



	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException{
		System.out.println("Inside Step- hits enter");
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("first-name")).sendKeys("Priyanka");
		driver.findElement(By.id("last-name")).sendKeys("Dhake");
		driver.findElement(By.id("postal-code")).sendKeys("411019");
		Thread.sleep(2000);

		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("finish")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);

	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() throws InterruptedException{
		System.out.println("Inside Step-user is navigated to search results");
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);

		driver.close();
		driver.quit();

	}
}
