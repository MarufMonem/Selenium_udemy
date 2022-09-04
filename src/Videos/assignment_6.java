package Videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment_6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		Selecting the checkbox
//		driver.findElement(By.) ;
		String labelName = driver.findElement(By.cssSelector("label[for='benz']")).getText() ;
//		Clicking checkbox
		driver.findElement(By.id("checkBoxOption2")).click() ;
//		enter label name
		driver.findElement(By.id("name")).sendKeys(labelName);
//		pressing alert
		driver.findElement(By.id("alertbtn")).click();
//		Handling the alert box
		String contents = driver.switchTo().alert().getText();
		System.out.println("Alert printed: " + contents);
		String expectedContent = "Hello " + labelName+", share this practice page and share your knowledge";
//		assert
		Assert.assertEquals(contents, expectedContent);
		System.out.println("Everything looks good! ");
		
//		Accepting the alert
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		driver.close();

	}

}
