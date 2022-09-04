package Videos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		driver.findElement(By.);
		System.out.println("Rows: " +  driver.findElements(By.cssSelector("table[name='courses'] tr")).size());
		System.out.println("Columns: " +  driver.findElements(By.cssSelector("table[name='courses'] tr th")).size());
		
		int target = 2;
		int count = 0;
//		all the elements
		List<WebElement> allItems = driver.findElements(By.cssSelector("table[name='courses'] tr"));
		for (WebElement item : allItems) {
			if(count == target) {
				List<WebElement> itemsInRow = item.findElements(By.cssSelector("td"));
				for (WebElement row : itemsInRow) {
					System.out.println(row.getText());
				}
				break;
			}
			count++;
		}
	}

}

//table[name='courses'] tr:nth-child(1) th
