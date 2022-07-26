import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows = driver.getWindowHandles(); //this holds the ID for all the windows
		Iterator<String> it = windows.iterator(); //storing that in a iterating object
		String parentID= it.next();//stores the first ID
		String childID=it.next(); //stores the 2nd ID
		driver.switchTo().window(childID); //switches to the child window
		
		String secondWindowText = driver.findElement(By.className("example")).getText();
		System.out.println(secondWindowText);
		
		driver.switchTo().window(parentID); //switches to the child window
		System.out.println(driver.findElement(By.tagName("h3")).getText());
	}

}
