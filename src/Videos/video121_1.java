package Videos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class video121_1 {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

//        Above
        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        String output = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(output);

//        Below
        WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();
//        System.out.println(output);

//        :eft of
        WebElement checkBoxInfo = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxInfo)).click();

//        Right of
        WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
        String radioLabel =  driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText();
        System.out.println(radioLabel);

    }

}
