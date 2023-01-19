package Course_content;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class video108_1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		
//		screen shots
//		driver object is casted to taking screen shot object
//		We are asking webdriver to output the ss as a file
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		to see the ss in out machine we need this
		FileUtils.copyFile(src, new File("C:\\Users\\Anik\\Desktop\\ss.png"));
	}

}
