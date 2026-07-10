package Demo;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Project {
  
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver.get("https://barvaskintherapie.com");
  }
  
  @Test
  public void verifyUserLogin() {
	  WebElement login = driver.findElement(By.xpath("//a[@class='header__btn-account d-flex align-items-center position-relative ml-25 ml-lg-15 js-popup-button']"));
		login.click();

		WebElement email = driver.findElement(By.xpath("//input[@id='PopupCustomerEmail']"));
		email.sendKeys("test@example.com");

		WebElement password = driver.findElement(By.xpath("//input[@id='PopupCustomerPassword']"));
		password.sendKeys("dummyPassword");

		WebElement lbtn = driver.findElement(By.xpath("//input[@value='LOGIN']"));
		lbtn.click();
  }
  
  @Test
  public void captureScreenshot() throws IOException {
	  TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File desk = new File("./screenshots/barvaProduct.jpg");
		FileHandler.copy(source, desk);
  }
  
  @Test
  public void verifyProductDetailsAndAddToCart() {
	  WebElement BBcare = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/main[1]/div[9]/div[1]/builder-section[1]/div[1]/div[1]/div[3]/div[1]/a[1]/div[1]/div[1]/img[1]")));
		BBcare.click();

		WebElement skincare = driver.findElement(By.xpath("//a[contains(text(),'Soothing Lemon Aloe Shower Gel - 200ml | PH Balanc')]"));
		skincare.click();

		String title1 = driver.getTitle();
		System.out.println("Title of the page=" + title1);

		WebElement ramt = driver.findElement(By.xpath("//div[@class='product-page-info__price text-center text-md-left mb-25']//span[@class='price'][contains(text(),'MRP')]"));
		WebElement psize = driver.findElement(By.xpath("//p[normalize-space()='Size : 200ml']"));
		WebElement paymento = driver.findElement(By.xpath("//p[normalize-space()='COD is now available on all orders.']"));

		System.out.println("Regular Price = " + ramt.getText());
		System.out.println("Product size = " + psize.getText());
		System.out.println("paymentoption = " + paymento.getText());

		WebElement addtocart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn--full btn--status btn--animated btn--animation-shake']")));
		addtocart1.click();

		WebElement cshopping = driver.findElement(By.xpath("//a[@class='btn btn--text text-left']"));
		cshopping.click();
  }
  
  @Test
  public void verifyLipBalmNavigationAndAddToCart() {
	  
	  WebElement gheeRange = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Ghee Range']")));
		actions.moveToElement(gheeRange).perform();

		WebElement lipBalm = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Lip Balm']")));
		lipBalm.click();

		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Lip Balm")));
		product.click();

		wait.until(ExpectedConditions.titleContains("Lip Balm"));
		System.out.println("Title of the page = " + driver.getTitle());

		// Handle patch test popup
		WebElement patchTest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-link h6 d-flex align-items-center mb-10 js-popup-button'][normalize-space()='PATCH TEST']")));
		patchTest.click();

		// Close popup safely
		WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".popup-size-guide__close")));
		closePopup.click();

		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn--full btn--status btn--animated btn--animation-shake']")));
		addToCart.click();
  }
  
  @Test
  public void verifyProductSearchStockAndAddToCart {
	  WebElement searchbtn = driver.findElement(By.xpath("//a[@class='header__btn-search d-none d-lg-flex align-items-lg-center ml-25 ml-lg-15 js-popup-button']//i//*[name()='svg']"));
		searchbtn.click();

		WebElement search = driver.findElement(By.xpath("//input[@id='Search']"));
		search.sendKeys("pure glycerin soap");

		WebElement product = driver.findElement(By.xpath("//h3[@class='h6 m-0']//a[contains(text(),'Pure Glycerin Soap Set | bath soaps for different ')]"));
		product.click();

		WebElement selectsoap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[3]//div[2]//div[1]//h6[1]//a[1]")));
		selectsoap.click();

		List<String> allwindow = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwindow.get(1));

		try {

		    List<WebElement> soapType = driver.findElements(
		        By.xpath("//*[@id='shopify-section-template--25182174708030__main']//div[contains(@class,'product-form')]//div[4]")
		    );

		    if (soapType.size() > 0) {
		        soapType.get(0).click();
		        System.out.println("Soap variant selected");
		    } else {
		        System.out.println("Variant selection not available");
		    }

		} catch (Exception e) {

		    System.out.println("Variant selection skipped");
		}

		String title3 = driver.getTitle();
		System.out.println("Title of the page=" + title3);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300);");

		List<WebElement> addButtons = driver.findElements(
		    By.xpath("//button[contains(@class,'btn--status')]")
		);

		if(addButtons.size() > 0) {

		    String buttonText = addButtons.get(0).getText().toLowerCase();

		    System.out.println("Button text = " + buttonText);

		    if(buttonText.contains("sold") ||
		       buttonText.contains("out of stock") ||
		       buttonText.contains("unavailable")) {

		        System.out.println("Product is out of stock");
		    } 
		    else {
		        addButtons.get(0).click();
		        System.out.println("Product added to cart");
		    }
		}
		else {
		    System.out.println("Add to cart button not available. Product is out of stock.");
		}
  }

  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
