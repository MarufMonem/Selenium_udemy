package Course_content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowActivites_video47_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		//full screen mode
		driver.manage().window().maximize();
		//Go to the website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// Navigating to different  pages while selenium is working or is in a different page
		driver.navigate().to("https://www.google.com");
		//Take the user back to the previous page
		driver.navigate().back();
		//Take user forward
		driver.navigate().forward();

	}

}
