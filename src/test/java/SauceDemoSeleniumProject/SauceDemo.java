package SauceDemoSeleniumProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



    public class SauceDemo {

	
	    WebDriver driver;
	    WebDriverWait wait;
	    ExtentReports Extent_Reports;
	    ExtentTest Extent_Test;
	
	
	
	@BeforeClass public void ReportConfiguration() {
	  
	  
	    Extent_Reports = new ExtentReports(System.getProperty("user.dir")
			  +"//SeleniumTestNGProject/SauceDemo.html");
	  
	    Extent_Test = Extent_Reports.startTest("SauceDemo"); }
	 
	
	
	@BeforeTest
	public void PreRequisites() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//URL of Sauce Demo WebSite.
		driver.get("https://www.saucedemo.com/");
		
		
		
	}
	
	@Test(priority = 1)
	public void Login() {
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		//UserName
		WebElement UserName = driver.findElement(By.id("user-name"));
		UserName.sendKeys("standard_user");
		
		wait.until(ExpectedConditions.visibilityOf(UserName));
		
		//Password
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("secret_sauce");
		
		//LoginButton
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();
		
		
		Extent_Test.log(LogStatus.PASS, "Logged In Successfully");
	}
	
	@Test(priority = 2)
	public void AddToCart() {
		
		//Adding the Product to the Cart.
		WebElement Add_To_Cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		Add_To_Cart.click();
		
		
		Extent_Test.log(LogStatus.PASS, "Product Added to Cart Successfully");
	}
	
	
	@Test(priority = 3)
	public void GoToCart() {
		
		//Go to Cart
		WebElement Go_To_Cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		Go_To_Cart.click();
		
		
		Extent_Test.log(LogStatus.PASS, "Entered in Cart Successfully");
	}
	
	
	@Test(priority = 4)
	public void Checkout() {
		
		//Checkout the product.
		WebElement Check_Out = driver.findElement(By.name("checkout"));
		Check_Out.click();
		
		
		Extent_Test.log(LogStatus.PASS, "Product checked out Successfully");
	}
	
	
	@Test(priority = 5)
	public void CheckOutDetails() {
		
		//First Name
		WebElement FirstName = driver.findElement(By.id("first-name"));
		FirstName.sendKeys("Praveen");
		
		//Last Name
		WebElement LastName = driver.findElement(By.id("last-name"));
		LastName.sendKeys("Patra");
		
		//ZipCode
		WebElement ZipCode = driver.findElement(By.id("postal-code"));
		ZipCode.sendKeys("827012");
		
		//Click on Continue
		WebElement Continue = driver.findElement(By.id("continue"));
		Continue.click();
		
		//Click on Finish
		WebElement Finish = driver.findElement(By.id("finish"));
		Finish.click();
		
		//Printing “Thank you for your order!” in the console.
		System.out.println("𝕋𝕙𝕒𝕟𝕜 𝕪𝕠𝕦 𝕗𝕠𝕣 𝕪𝕠𝕦𝕣 𝕠𝕣𝕕𝕖𝕣!");
		
		
		Extent_Test.log(LogStatus.PASS, "Customer Details Filled and Order Successful message Printed");
	}
	
	
	@Test(priority = 6)
	public void ScreenShot() throws IOException {
		
		//Casting driver to TakeScreenshot Interface.
		TakesScreenshot Screen_Shot = (TakesScreenshot)driver;
		
		//Calling getScreenshotAs() and taking a Screenshot and storing it inside source.
		File source = Screen_Shot.getScreenshotAs(OutputType.FILE);
		
		//Creating a new file in local machine.
		File destination = new File("C:\\Users\\prave\\OneDrive\\Desktop\\Selenium Project\\ThankYou.png");
		
		//Copying the file from source to destination.
		FileUtils.copyFile(source, destination);
		
			
		
		Extent_Test.log(LogStatus.PASS, "Screenshot taken Successfully");
	}
	
	
	@AfterTest
	public void TearDown() throws InterruptedException {
		
		driver.navigate().refresh();
		//driver.navigate().back();
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}
	
	
	
	@AfterClass public void ReportFlush() {
	  
	  
	    Extent_Reports.endTest(Extent_Test);
	  
	    Extent_Reports.flush(); }
	 
	
}
