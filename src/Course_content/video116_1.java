package Course_content;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<String> value;
        do {
            List<WebElement> tableContents = driver.findElements(By.xpath("//tr/td[1]"));

            value = tableContents.stream()
                    .filter(s-> s.getText().contains("Apple"))
                    .map(s-> getPrice(s))
                    .collect(Collectors.toList());


            if(value.size()>0){
                value.forEach(a-> System.out.println(a));
            }else{
                driver.findElement(By.xpath("//a[@aria-label = 'Next']")).click();

            }
        }while (value.size()<1);


        driver.quit();

    }
}
