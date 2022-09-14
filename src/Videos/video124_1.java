package Videos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class video124_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windows =  driver.getWindowHandles();
        Iterator<String> it = windows.iterator(); // We use iterator to traverse through the set
        String parentID = it.next(); // The first iteration gives the parent ID
        String childID = it.next(); // the second iteration  gives the child ID

        driver.switchTo().window(childID); // Switching to the child window
        driver.get("https://rahulshettyacademy.com/");

//       There are multiple courses so we get all that matches the link and from there select the first one
        String courseTitle =  driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText();
        System.out.println(courseTitle);

//        Switch to parent
        driver.switchTo().window(parentID);
        driver.findElement(By.name("name")).sendKeys(courseTitle);
//        driver.quit();

    }
}
