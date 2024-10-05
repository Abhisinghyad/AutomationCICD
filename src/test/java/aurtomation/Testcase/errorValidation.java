package aurtomation.Testcase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import aurtomation.TestComponents.baseSetUp;
import aurtomation.TestComponents.retry;
import aurtomation.pageObjects.cartPage;
import aurtomation.pageObjects.checkOutPage;
import aurtomation.pageObjects.confirmationPage;
import aurtomation.pageObjects.loginPage;
import aurtomation.pageObjects.productCatalogue;

public class errorValidation extends baseSetUp {
	String productName = "ZARA COAT 3";

	@Test(groups = {"ErrorHandling"},retryAnalyzer = retry.class)
	public void LoginError() throws IOException, InterruptedException {

		productCatalogue productCatalogue = login.loginApplication("nashika@gmail.com", "Iamking@000");
		Assert.assertEquals("Incrrect email or password.",login.geterrorMessgae());
	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		productCatalogue productCatalogue = login.loginApplication("Abhishek.yadav@gmail.com", "Qwerty@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		cartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

	}
}
