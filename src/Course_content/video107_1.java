package Course_content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video107_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		maximize window
		driver.manage().window().maximize();
//		delete all the cookies
		driver.manage().deleteAllCookies();
//		delete specific cookie
		driver.manage().deleteCookieNamed("Cookie name");
		
		driver.get("https://google.com/");
		

		
		
	}

}
