package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {

	
	public WebDriver driver;
	 
	//By termsAndConditions = By.xpath("//a[contains(text(),'Accept all')]");
	By termsAndConditions = By.linkText("Accept all");
	By shopIcon=By.xpath("//a[contains(text(),'Shop')]");
	By wish1 = By.linkText("Add to wishlist");
	By wishlist = By.xpath("//*[@id=\"blog\"]/div[3]/div[1]/div/div/div[3]/div[3]/a/i");
	By wholeWishlist = By.xpath("//*[@id='yith-wcwl-form']/table");
	By unitPrice = By.xpath("//span[contains(text(),'Unit price')]");
			
	public HomePage(WebDriver driver) {

		this.driver=driver;
		
	}


	
	public WebElement acceptTerms()
	{
		return driver.findElement(termsAndConditions);
	}
	
	public WebElement clickShop()
	{
		return driver.findElement(shopIcon);
	}
	public WebElement addWishlist()
	{
		return driver.findElement(wish1);
	}
	
	public WebElement viewWishlist()
	{
		return driver.findElement(wishlist);
	}
	
	public void lowToHigh() throws InterruptedException

	  {         
	        
	        driver.findElement(wholeWishlist).click();
	        
	        Thread.sleep(5000);
	        List<WebElement> price = driver.findElements(By.xpath("//tbody/tr[contains(@id,'yith-wcwl-row')]/td[4]/ins[1]/span[1]"));
	        List<WebElement> price1 = driver.findElements(By.xpath("//tbody/tr[contains(@id,'yith-wcwl-row')]/td[4]/span[2]"));
	        
	        price.addAll(price1);
	        System.out.println(price.size());
	    
	        for (int i = 0; i<price.size(); i=i+1) 
	        {
	        System.out.println(price.get(i).getText());          
	        }   
	        
	        
	        ArrayList<Float> priceList = new ArrayList<Float>();
		    for (int i = 0; i<price.size(); i=i+1) {
		       priceList.add(Float.parseFloat(price.get(i).getText().replace('£', ' ').trim())); 
		    }  
		    Collections.sort(priceList);
		    
		    float low_price = priceList.get(0);
		    System.out.println(low_price);
		    
		    By tablerows = By.xpath("//tbody");
		  //  WebElement e = driver.findElement(By.xpath("//*[@contains(text(),'"+low_price+"')]"));
		    
		    
		    WebElement e = driver.findElement(By.xpath("//*[text()='"+low_price+"0']"));
		    
		    
		    WebElement parent = e.findElement(By.xpath("./.."));
		    
			System.out.println(e);
		    
		    
	  }
	
	
	
}
