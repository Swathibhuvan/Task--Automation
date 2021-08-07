package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.base;

public class TestCase extends base{
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	@Test
	
	public void basePageNavigation() throws IOException, InterruptedException
	{


		driver.get(prop.getProperty("url"));
		HomePage hp=new HomePage(driver);
		hp.acceptTerms().click();
		hp.clickShop();
		driver.manage().window().maximize();
		hp.addWishlist().click();
		Thread.sleep(4000);
		hp.addWishlist().click();	
		Thread.sleep(4000);
		hp.addWishlist().click();	
		Thread.sleep(4000);
		hp.addWishlist().click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-150)");

		hp.viewWishlist().click();
		
		//log.info(text);
		
	
		hp.lowToHigh();
		}

	@AfterTest
	public void teardown() throws InterruptedException
	{	
		driver.close();
		
	}

	
}
