package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

public class video115_1 {
    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver", "X:\\Self improvement\\Selenium Udemy\\driver\\103.0.5060.53\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

//        Click on the column name
//        it would get sorted
        driver.findElement(By.xpath("//span[text()= 'Veg/fruit name']")).click();

//        Capture all the names/webElement
//        get all the text from the webElements into list (original list)
        List<WebElement> elements =  driver.findElements(By.xpath("//tr/td[1]"));
//      Printing the results
        for (WebElement element:elements) {
            System.out.println(element.getText());
        }
//      Get all the veg/fruit names using streams and store it in a list
        List <String> originalValues = elements.stream()
                .map(s-> s.getText())
                .collect(Collectors.toList());

//        Apply sort in the list (new list)
        List <String> sortedValues = originalValues.stream().sorted().collect(Collectors.toList());
//        if both lists are equal then the sort is working fine
        Assert.assertEquals(sortedValues, originalValues);

//      close the driver
        driver.quit();
    }
}
