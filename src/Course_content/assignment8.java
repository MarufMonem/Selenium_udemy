package Course_content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("ban");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li //div[text() = 'Bangladesh']")).click();
		System.out.println("input val is: " + driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}

}
