import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class video89_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
//		Switching to frames
//		Knowing how many iframes are there in the page
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
//		driver.switchTo().frame(0);
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement source1 = driver.findElement(By.id("draggable"));
		WebElement source2 = driver.findElement(By.id("droppable"));

		Actions a = new Actions(driver);
		a.dragAndDrop(source1, source2).build().perform();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(10000);
		driver.close();

	}

}
