package testNg_try;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Ng {
	
	      WebDriver driver;

	@BeforeSuite
	public void browserlaunch() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
	//	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		//driver.get("https://www.saucedemo.com/");

	}
	@BeforeTest
	public void login() {

		driver.get("http://www.google.co.in");		

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//input[@id='login-button']")).click();


	}
	@Test
	public void addcart() {

		driver.findElement(By.xpath("//button[text()='ADD TO CART']/following::button[3]")).click();

		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/svg/path")).click();

		driver.findElement(By.xpath("//a[text()='CHECKOUT']")).click();

	}@Test
	public void ccheckout() {

		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("siva");

		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("balaji");

		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("012345");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		driver.findElement(By.xpath("//a[text()='FINISH']")).click();

	}

	@Test
	public void dtakescreenshot() throws IOException {

		TakesScreenshot tc = (TakesScreenshot)driver;

		File output = tc.getScreenshotAs(OutputType.FILE);

		File location = new File("C:\\Users\\Admin\\eclipse-workspace\\TestNg\\src\\test\\java\\screenshot");

		FileUtils.copyDirectory(output, location);

	}

	@Test
	public void elogout() {

		driver.findElement(By.xpath("//button['Open Menu']/following::button")).click();

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

	@AfterClass
	public void browserclose() {

		driver.manage().deleteAllCookies();

		driver.quit();
	}
}
