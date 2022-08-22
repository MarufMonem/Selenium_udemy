import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video109_1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		Broken URL
//		Step 1: Get all the URLs
//		Step 2: Use java methods to get the status code
//		Check if the status code is >400
		String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(url). openConnection();
		
		conn.setRequestMethod("HEAD");
		conn.connect();
		int res = conn.getResponseCode();
		System.out.println(res);
		
	
		
	}

}
