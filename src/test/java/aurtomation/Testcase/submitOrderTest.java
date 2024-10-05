package aurtomation.Testcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aurtomation.TestComponents.baseSetUp;
import aurtomation.pageObjects.cartPage;
import aurtomation.pageObjects.checkOutPage;
import aurtomation.pageObjects.confirmationPage;
import aurtomation.pageObjects.loginPage;
import aurtomation.pageObjects.orderPage;
import aurtomation.pageObjects.productCatalogue;


public class submitOrderTest extends baseSetUp {


	@Test(dataProvider = "getdata", groups = { "Purchase" })
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

		productCatalogue productCatalogue = login.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		cartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		checkOutPage checkoutPage = cartPage.goToCheckout();
//		checkoutPage.selectCountry("india");
////		confirmationPage confirmationPage = checkoutPage.submitOrder();
//		String confirmMessage = confirmationPage.getConfirmationMessage();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		String productName = "ZARA COAT 3";
		//"ZARA COAT 3";
		productCatalogue productCatalogue = login.loginApplication("anshika@gmail.com", "Iamking@000"); // "anshika@gmail.com", "Iamking@000"
		orderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay("ZARA COAT 3"));
		
}

//	@DataProvider
//	public Object[][] getdata() throws IOException
//	{
//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "anshika@gmail.com");
//		map.put("password", "Iamking@000");
//		map.put("productName", "ZARA COAT 3");
////		List<HashMap<String,String>> data = getDataToMap(System.getProperty("user.dir")+"//src//test//java//aurtomation//data//PurchaseOrder.json");
//		return new Object[][]  {{map}};
//		
//	}
	
	
	 @DataProvider
	  public Object[][] getdata() throws IOException 
	  {
		 
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//aurtomation//data//PurchaseOrder.json");
	    return new Object[][]  {{data.get(0)},{data.get(1)}};
	    
	  }
	 
	 
	
	 //qwerty1998@gmail.com,Qwerty@123
	 
}
