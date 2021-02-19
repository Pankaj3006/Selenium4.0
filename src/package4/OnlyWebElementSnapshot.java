package package4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlyWebElementSnapshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("firstCourse");
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("name.png"));   
	}

}
