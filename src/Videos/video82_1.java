package Videos;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class video82_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		
//		Fluent wait is a class and its implementing wait interface
//		Here we are giving a 30 second timeout 
//		with a interval of 3 seconds
//		So it would loop through it 10 times
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				   .withTimeout(Duration.ofSeconds(30))
				   .pollingEvery(Duration.ofSeconds(3))
				   .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     
			   //the following is trying to find the element. If not found then its returning an error
			   // that helps fluent wait understand that i need to wait more
			   public WebElement apply(WebDriver driver) { 
			       if( driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
			    	   return driver.findElement(By.cssSelector("[id='finish'] h4"));
			       }else {
			    	   return null;
			       }
			     }
			   
		   });

		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
