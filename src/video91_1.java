import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class video91_1 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
//		How many links are there in this page
		System.out.println("Total links in the page: " + driver.findElements(By.tagName("a")).size());
		
//		How many links are there in footer section 
		System.out.println("Total links in the footer section: " + driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());

		WebElement subDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println("Total links in the footer section: " + subDriver.findElements(By.tagName("a")).size() );
		
		System.out.println("col count:" +  subDriver.findElements(By.xpath("//td[1]/ul/li/a")).size());
		
		WebElement columnDriver = subDriver.findElement(By.xpath("//td[1]/ul"));
		System.out.println("Other col count:" +  columnDriver.findElements(By.tagName("a")).size());
		
//		Checking if all the pages are working
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		}
		
//		Go to each and every tab
		Set <String> pages = driver.getWindowHandles();
		Iterator <String> it = pages.iterator();
		
		while(it.hasNext()) { 
			//whether the next is present
			//is there a 0 index?
			driver.switchTo().window(it.next()); // Yes then go 
			System.out.println(driver.getTitle());
		}
		
		Thread.sleep(10000);
		driver.close();

	}

}
