import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class video64_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		// iterate using enhanced for loop
		for (WebElement option : options) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("India")) {
				System.out.println("Found");
				option.click();
				break;
			}
		}

		// Radio button select
		// one way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		String date2 = driver.findElement(By.id("Div1")).getAttribute("style");
		if (date2.contains("0.5")) { // checks if the string has a value that contains 1
			System.out.println("YES YES");
		} else {
			Assert.assertFalse(true, "Oh No!");
		}

		// using parent child concept for dynamic dropdowns
		// Departure
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']"))
				.click();
		Thread.sleep(1000);

		// Arrival
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// Calendar
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// Selecting passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1500);
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		// Submit
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
	}

}
