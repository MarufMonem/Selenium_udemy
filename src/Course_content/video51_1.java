package Course_content;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class video51_1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//Selecting passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1500);
		int i =0;
		while( i< 4) {
			System.out.println(i);
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//Departure
//		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//		Thread.sleep(1000);
//		//Arrival
//		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
//		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		//using parent child concept for dynamic dropdowns
		//Departure
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(1000);
		
		//Arrival
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//iterate using enhanced for loop
		for(WebElement option: options) {
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("India")) {
				System.out.println("Found");
				option.click();
				break;
			}
		}
		//using checkboxes
		//using name
//		driver.findElement(By.name("ctl00$mainContent$chk_friendsandfamily")).click();
		//css selector and regex(because the name is very big)
		driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		//checking if the check box is selected or not
		Boolean result = driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).isSelected();
		if(result == true) {
			System.out.println("the checkbox is selected");
		}else {
			System.out.println("the checkbox is not selected");
		}
//		Assertion
//		the following is saying that if the item provided gives a false that is expected. if true then the test would fail
//		Assert.assertFalse(result);
//		This is for true
		Assert.assertTrue(result);
		
		
//		Getting all the check boxes
		int countCheckbox = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Count:" + countCheckbox);
		
		//Radio button select
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		String date2 = driver.findElement(By.id("Div1")).getAttribute("style");
		if(date2.contains("1")) {  //checks if the string has a value that contains 1
			System.out.println("YES YES");
		}else {
			Assert.assertFalse(true, "Oh No!");
		}
		
//		We also have another form of assertion
//		Assert equals that compares the values
		Assert.assertEquals(countCheckbox, 6);
//		Calendar
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		
		
//		-----------------------STOPPER------------------------------------
		Thread.sleep(2000);
		driver.quit();
	}

}
