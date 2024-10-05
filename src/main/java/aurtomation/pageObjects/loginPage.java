package aurtomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aurtomation.AbstractComponents.commonMethods;


public class loginPage extends commonMethods{
	WebDriver driver;

	public loginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
		//PageFactory
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}


		public  productCatalogue loginApplication(String email, String password) {
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			productCatalogue productCatalogue = new productCatalogue(driver);
			return productCatalogue;
			
		}
		
		public String geterrorMessgae() {
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}

}
