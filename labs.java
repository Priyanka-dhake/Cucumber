package swaglab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class annontation {


	public String baseurl = "https://www.saucedemo.com/";
	String driverpath = "/usr/bin/chromedriver";
	public WebDriver driver;

	@BeforeTest
	public void HomepageTitle() {
		System.out.println("Launching chrome Browser");
		System.setProperty("webdriver.chrome.driver",driverpath);
		driver = new ChromeDriver();
		driver.get(baseurl);

	}
	@Test
	public void VerifyHomepageTitle() throws InterruptedException{
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.name("login-button")).click();
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)");

		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(2000);

		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollBy(0,-350)");

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
		driver.findElement(By.className("product_sort_container")).click();
		Thread.sleep(2000);

		Select obj = new Select(driver.findElement(By.className("product_sort_container")));
		obj.selectByVisibleText("Price (low to high)");


		driver.navigate().to("https://twitter.com/saucelabs");		
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		Thread.sleep(2000);


	}

	@AfterTest
	public void terminateHomepage() {
		driver.close();
	}
}
