package Videos;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class video77_1 {
	public static void addItems(WebDriver driver, String veggies[] ) {
		//		get all the elements
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int matched=0;
		outerloop:
			for(int i = 0; i< products.size(); i++) {
				System.out.println("i=" + i + " -  " +products.get(i).getText());
				innerloop:
					for (int j=matched; j<veggies.length;) {
						if(products.get(i).getText().contains(veggies[j])) {
							System.out.println("-----------------Found it at: " + i + "--------------------");
							driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
							matched++;
						}
						break innerloop;
					}
				if(matched==veggies.length) {
					break outerloop;
				}
			}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		String veggies[] = {"Brocolli", "Cucumber", "Beetroot" };
		addItems(driver, veggies);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
	
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("promoBtn")));
		//		-----------------------STOPPER------------------------------------
		Thread.sleep(20000);
		driver.quit();

	}
}
