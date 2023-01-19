package Course_content;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class video_96 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companions");
//		Due to how slow the website is we are pausing the code for 4 seconds
		Thread.sleep(4000);
//		Clicking on the date input box
		driver.findElement(By.cssSelector("input[id='travel_date']")).click();
//		Checking the current month and printing it
		String monthName = driver.findElement(By.cssSelector("[class=datepicker-days] [class='datepicker-switch']")).getText();
		System.out.println(monthName);
		
//		We are using a while loop to traverse to our desired month
//		Here we checking if the desired month April is Present.class If not then click the next arrow button
		while(!driver.findElement(By.cssSelector("[class=datepicker-days] [class='datepicker-switch']")).getText().contains("April")) {
			driver.findElement(By.cssSelector("[class=datepicker-days] th[class='next']")).click();
			
		}
		
//		driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
//		Get all the dates using the class name that applies to all the dates
		List<WebElement> dates = driver.findElements(By.className("day"));
		for (WebElement date : dates) {
			String number =  date.getText();
			if(number.equalsIgnoreCase( "23")){
				date.click();
				break;
			}
			
		}
		
		
	}

}
