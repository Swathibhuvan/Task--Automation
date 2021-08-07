package stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import resources.base;


public class stepDefinition extends base {
		
		
		@Before
		public void openURL() throws IOException {
			driver =initializeDriver();
		  	driver.manage().window().maximize();
		}
		
		@After
		public void closeURL() throws IOException {
				//driver.close();
				
		}
		
		
		
		
	    @Given("^I add four different products to my wish list$")
	    public void i_add_four_different_products_to_my_wish_list() throws Throwable {
			
			driver.get(prop.getProperty("url"));
	    	HomePage hp=new HomePage(driver);
			hp.acceptTerms().click();
			Thread.sleep(2000);
	    	hp.clickShop();   	
			hp.addWishlist().click();
			Thread.sleep(2000);
			hp.addWishlist().click();	
			Thread.sleep(2000);
			hp.addWishlist().click();	
			Thread.sleep(2000);
			hp.addWishlist().click();	

	    }

	    @When("^I view my wishlist table$")
	    public void i_view_my_wishlist_table() throws Throwable {
	    	JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-150)");
			HomePage hp=new HomePage(driver);
			hp.viewWishlist().click();
	    }

	    @When("^I search for lowest price product$")
	    public void i_search_for_lowest_price_product() throws Throwable {
	        throw new PendingException();
	    }

	    @Then("^I find total four selected items in my Wishlist$")
	    public void i_find_total_four_selected_items_in_my_wishlist() throws Throwable {
	        throw new PendingException();
	    }

	    @Then("^I am able to verify the item in my cart$")
	    public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
	        throw new PendingException();
	    }

	    @And("^I am able to add the lowest price item to my cart$")
	    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws Throwable {
	        throw new PendingException();
	    }

}
