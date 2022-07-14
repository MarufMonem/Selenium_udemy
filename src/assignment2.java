import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\chromedriver.exe");
		WebDriver  driver = new ChromeDriver (); 
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
//		driver.findElement(By.(""));
		
//		Name
		driver.findElement(By.name("name")).sendKeys("Rahul");
//		Email
		driver.findElement(By.name("email")).sendKeys("Rahul@google.com");
//		Password 
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Rahul");
//		Check box
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
//		Gender Drop-down
		WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("Female");
//		Radio
		driver.findElement(By.id("inlineRadio1")).click();
//		DOB
		driver.findElement(By.name("bday")).sendKeys("05/05/1985");
//		Submit
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
//		Success MSG
		System.out.println(driver.findElement(By.className("alert-success")).getText());

	}

}
