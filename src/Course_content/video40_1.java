package Course_content;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class video40_1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Collect the password
		//password
		String dynamicPassword = getPassword(driver);
		//Go to the website
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		//username
		String username = "Rahul";
		//Send username
		driver.findElement(By.id("inputUsername")).sendKeys(username);

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(dynamicPassword);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//Selenium is too fast arghhh
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		//Check if the hello message is correct or not
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+ username+",");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
	}
	public static String getPassword(WebDriver  driver ) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//identify forget password
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Sleep
		Thread.sleep(1000);
		//reset button
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//get the message
		String returnMsg= driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(returnMsg);
		String returnMsg1[]= returnMsg.split("'"); //returns an array
		String returnMsg2[]=returnMsg1[1].split("'");
		System.out.println(returnMsg2[0]);
		return returnMsg2[0];
		
	}
}
