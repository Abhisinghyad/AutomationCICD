package aurtomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class abc {

	public static void main(String[] args) {
	        // Set the path for the WebDriver if it's not in your PATH
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update this path

	        // Initialize the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Open the login page
	        driver.get("https://example.com/login"); // Replace with your login URL

	        // Find the username and password fields and the login button
	        WebElement usernameField = driver.findElement(By.name("username")); // Change the selector as needed
	        WebElement passwordField = driver.findElement(By.name("password")); // Change the selector as needed
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']")); // Change the selector as needed

	        // Enter your credentials
	        usernameField.sendKeys("your_username"); // Replace with your username
	        passwordField.sendKeys("your_password"); // Replace with your password

	        // Click the login button
	        loginButton.click();

	        // Optional: Wait for a while to see the result
	        try {
	            Thread.sleep(5000); // Sleep for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Close the browser
	        driver.quit();
	    
	}
}
