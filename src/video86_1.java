import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video86_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows = driver.getWindowHandles(); //this holds the ID for all the windows
		System.out.println(windows);
		Iterator<String> it = windows.iterator(); //storing that in a iterating object
		String parentID= it.next();//stores the first ID
		String childID=it.next(); //stores the 2nd ID
		driver.switchTo().window(childID); //switches to the child window
		
		String email=driver.findElement(By.xpath("//p[@class='im-para red']/strong")).getText();
		System.out.println(email);
		
//		Switiching to the parent page
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(email);
		

	}

}
