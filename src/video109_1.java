import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class video109_1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert sa = new SoftAssert();
		
		for (WebElement link : links) {
//			Getting the url link
			String url = link.getAttribute("href");
//			The link name
			String urlText = link.getText();
//			Creating the HTTP connection 
			HttpURLConnection conn= (HttpURLConnection)new URL(url). openConnection();
			conn.setRequestMethod("HEAD");
//			Connecting using head method
			conn.connect();
//			Getting the response code
			int res = conn.getResponseCode();
			System.out.println("Response: " + res + " --- " + urlText + " ---> " + url );
//			Assert when fail - soft assertion
			sa.assertTrue(res<400, "Failed! Response: " + res + " --- " + urlText + " ---> " + url);

			
		}
		sa.assertAll();
	
	}

}
