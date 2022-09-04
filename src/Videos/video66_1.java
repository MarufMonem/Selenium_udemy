package Videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video66_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String user = "Maruf";
		driver.findElement(By.id("name")).sendKeys(user);
//		driver.findElement(By.id("alertbtn")).click();
		driver.findElement(By.id("confirmbtn")).click();
		
//		Alerts
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
				
//		-----------------------STOPPER------------------------------------
		Thread.sleep(2000);
		driver.quit();
	}

}
