package Videos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video32_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//username
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		//password
		driver.findElement(By.name("inputPassword")).sendKeys("Forget");
		//submit
		driver.findElement(By.className("submit")).click();
		//identify the error
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		//identify forget password
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Sleep
		Thread.sleep(1000);
		//Name input
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
		//Email  input
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Rahul@email.com");
		//Clearing the field
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		//Email input
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Ra@hul.com");	
		//Phone  input
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("012153");
		//reset button
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//get the message
		String returnMsg= driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(returnMsg);
		// Click go to login
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		//fill in the login details
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("Rahul@email.com");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		//Sleep
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		Thread.sleep(2000);
		driver.quit();

	}

}
