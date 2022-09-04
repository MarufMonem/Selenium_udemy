package Videos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class video104_2 {

	public static void main(String[] args) {
		//Create instance of ChromeOptions Class
		ChromeOptions handlingSSL = new ChromeOptions();
 
		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
				
		//Creating instance of Chrome driver by passing reference of ChromeOptions object
		WebDriver driver = new ChromeDriver(handlingSSL);
		
		//Launching the URL
		driver.get("https://expired.badssl.com/");
		System.out.println("The page title is : " +driver.getTitle());
//		driver.quit();

	}

}
