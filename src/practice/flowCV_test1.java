package practice;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.netty.util.internal.ThreadLocalRandom;

public class flowCV_test1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Random random = new Random();  
		int x=0;

		Thread.sleep(15*60*1000);

		for(int i = 0; i<34; i++) {

			x = ThreadLocalRandom.current().nextInt(20, 45 + 1);
			String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
			System.out.println("The next run would start after: " + x + " minutes  ----> Current time is: " + timeStamp);

			//			maruf
			driver.get("https://flowcv.com/invite/frl7vnmba6");

			Thread.sleep(4000);

			//			Tamjid
			driver.get("https://flowcv.com/invite/n3ldguo5h5");
			//
			driver.manage().deleteAllCookies();
			Thread.sleep(x*60*1000);

		}


	}

}
