package Course_content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		
		int size = driver.findElements(By.tagName("frame")).size();
		System.out.println("Outer frame count: " + size);
		
		driver.switchTo().frame(0);
		size = driver.findElements(By.tagName("frame")).size();
		System.out.println("Inner frame count: " + size);
		driver.switchTo().frame(1);
		String middle = driver.findElement(By.id("content")).getText();
		System.out.println(middle);
		
		Thread.sleep(10000);
		driver.close();
		
	}

}
