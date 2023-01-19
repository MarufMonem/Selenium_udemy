package Course_content;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

public class video119_1{
        public static void main(String[] args) throws MalformedURLException, IOException {
            WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            driver.findElement(By.id("search-field")).sendKeys("app");
           List<WebElement> allResults =  driver.findElements(By.xpath("//tr/td[1]"));

           List<WebElement> desiredItem = allResults.stream()
                   .filter(s-> s.getText()
                           .contains("Apple"))
                   .collect(Collectors.toList());

//           if the filter/serach is broken then both lists would have the same count.
//            This would be our indication that something is broken

            Assert.assertNotEquals(allResults.size(), desiredItem.size());
            
        }
}
