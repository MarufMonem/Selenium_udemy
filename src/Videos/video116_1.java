package Videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

public class video116_1 {
    public static String getPrice(WebElement s){
      return  s.findElement(By.xpath("following-sibling:: td[1]")).getText();
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<WebElement> tableContents = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> value = tableContents.stream()
                .filter(s-> s.getText().contains("Rice"))
                .map(s-> getPrice(s))
                .collect(Collectors.toList());

        value.forEach(a-> System.out.println(a));
        driver.quit();

    }
}
