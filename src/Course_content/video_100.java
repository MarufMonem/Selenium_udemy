package Course_content;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class video_100 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		to scroll we need the help of JS
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		List<WebElement> amounts = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
		int sum = 0;
		for (WebElement amount : amounts) {
			System.out.println(amount.getText());
			int amountInt = Integer.parseInt(amount.getText());
			sum = sum + amountInt;
		}
		System.out.println("Total: " + sum);
		String[] message = driver.findElement(By.className("totalAmount")).getText().split(": ");
		System.out.println(message[1]);
		
		
		Assert.assertEquals(sum,Integer.parseInt(message[1]));
		System.out.println("Looks good");
	}
	


}
