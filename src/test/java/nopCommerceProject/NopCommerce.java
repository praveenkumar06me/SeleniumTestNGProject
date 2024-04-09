package nopCommerceProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NopCommerce {

	
	//Note: Every time before run the code, Please change the email ID in both positions.
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports Extent_Reports;
	ExtentTest Extent_Test;
	
	
	@BeforeClass 
	public void ReportConfiguration() {
		  
		  
	    Extent_Reports = new ExtentReports(System.getProperty("user.dir")
			                   +"//SeleniumTestNGProject/NopCommerce.html");
	  
	    Extent_Test = Extent_Reports.startTest("NopCommerce"); }
	
	
	@BeforeTest
	public void PreRequisites() {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//URL of the WebPage
		driver.get("https://demo.nopcommerce.com/register");
		
	}
	
	
	@Test(priority = 1)
	public void Registration() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Selecting Gender
		WebElement Gender = driver.findElement(By.id("gender-male"));
		Gender.click();
		
		//FirstName
		WebElement FirstName = driver.findElement(By.id("FirstName"));
		FirstName.sendKeys("Superman");
		
		//LastName
		WebElement LastName = driver.findElement(By.id("LastName"));
		LastName.sendKeys("Sharma");
		
		//Selecting Date
		WebElement Day = driver.findElement(By.name("DateOfBirthDay"));
		Select select1 = new Select(Day);
		select1.selectByValue("4");
		
		//Selecting Month
		WebElement Month = driver.findElement(By.name("DateOfBirthMonth"));
		Select select2 = new Select(Month);
		select2.selectByValue("11");
		
		//Selecting Year
		WebElement Year = driver.findElement(By.name("DateOfBirthYear"));
		Select select3 = new Select(Year);
		select3.selectByValue("1996");
		
		//EmailId
		WebElement Email = driver.findElement(By.id("Email"));
		Email.sendKeys("SupermanSharma7@universe.com");
		
		//Company Name
		WebElement Company = driver.findElement(By.id("Company"));
		Company.sendKeys("DC Universe");
		
		//Password
		driver.findElement(By.id("Password")).sendKeys("InvalidPassword@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("InvalidPassword@123");
		
		//Clicking on Register Button
		WebElement Register = driver.findElement(By.id("register-button"));
		Register.click();
		
		//Clicking on continue Button
		WebElement Continue = driver.findElement(By.xpath("//a[@class='button-1 register-continue-button']"));
		Continue.click();
		
		Extent_Test.log(LogStatus.PASS, "Registered All the Details Successfully");
		
	}
	
	@Test(priority = 2)
	public void Books() {
		
		//Clicking on Books Option
		driver.findElement(By.xpath("(//a[.='Books '])[1]")).click();
		
		//Clicking on the Product and add to cart
		driver.findElement(By.xpath("(//button[.='Add to cart'])[1]")).click();
		
		//Moving to Shopping Cart
		driver.findElement(By.xpath("//span[.='Shopping cart']")).click();
		
		Extent_Test.log(LogStatus.PASS, "Book added to cart Successfully");
	}
	
	@Test(priority = 3)
	public void Checkout() {
		
		//Clicking on Terms of service CheckBox
		driver.findElement(By.id("termsofservice")).click();
		
		//Click on Checkout
		driver.findElement(By.name("checkout")).click();
		
		//Click on Checkout as Guest
		driver.findElement(By.xpath("//button[.='Checkout as Guest']")).click();
		
		Extent_Test.log(LogStatus.PASS, "Logged In Successfully");
	}
	
	@Test(priority = 4)
	public void BillingAddress() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//FirstName
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Superman");
		
		
		//LastName
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Sharma");
		
		//Email
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Supermansharma7@Universe.com");
		
		//Company
		driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("DC Universe");
		
		//Country
		WebElement Country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		
		Select select4 = new Select(Country);
		select4.selectByValue("133");
		
		//State
		WebElement State = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		
		Select select5 = new Select(State);
		select5.selectByValue("0");
		
		//City
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Hypothetic City");
		
		//Add 1
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Sector A");
		
		//Add2
		driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Infinity Tower");
		
		//ZIP Code
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123456");
		
		//Phone Number
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9876543210");
		
		//FAX Number
		driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("12345");
		
		//Clicking on continue
		driver.findElement(By.xpath("(//button[.='Continue'])[1]")).click();
		
		Extent_Test.log(LogStatus.PASS, "Billing Address Entered Successfully");
		
		
		}
	
	@Test(priority = 5)
	public void Confirmations() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Clicking on continue
		driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
		
		//Clicking on continue
		driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
		
		//Clicking on the continue
		driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
		
		//Clicking on the confirm
		driver.findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']")).click();
		
		Extent_Test.log(LogStatus.PASS, "All the mode of Payment, mode of delivery & Address confirmed");
		
		System.out.println("Your Order has been Successfully Processed!");
		
	}
	
	@AfterTest
	public void Teardown() throws InterruptedException {
		
		
		Thread.sleep(3000);
		driver.close();
		
		
	}
	
	@AfterClass 
	public void ReportFlush() {
		  
		  
	    Extent_Reports.endTest(Extent_Test);
	  
	    Extent_Reports.flush(); }
	
}
