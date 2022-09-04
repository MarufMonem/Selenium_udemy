package Videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//getting all the checkboxes
		int count = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Count of checkboxes " + count);
		
		//Selecting the first check box and checking the results
		WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
		checkBox1.click();
		Assert.assertTrue(checkBox1.isSelected());
		
		//un-selecting and checking
		checkBox1.click();
		Assert.assertFalse(checkBox1.isSelected());
		
		

	}

}
