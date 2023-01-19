package Course_content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class video84_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
//		driver.findElement(By.cssSelector("//span[text()= \"Don't Change\"]")).click();
		
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		Actions a =new Actions(driver);
		a.moveToElement(move).contextClick().build().perform();
		
//		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		
		


	}

}
