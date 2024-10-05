package aurtomation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import aurtomation.AbstractComponents.commonMethods;


public class confirmationPage extends commonMethods{
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		checkOutPage cp = new checkOutPage(driver);	
		return confirmationMessage.getText();
	}
	
}
