package package4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMulipleWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Open New tab or Window
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> str =  driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		driver.get("https://courses.rahulshettyacademy.com/courses");
        String firstCourse = driver.findElement(By.xpath("(//div[@class='course-listing-title'])[2]")).getText();
        System.out.println(firstCourse);
        driver.switchTo().window(parentWindow);
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        //Taken the screenshot of Particular WebElement
        name.sendKeys(firstCourse);
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("name.png"));
        //get the Height & Width of particular WebElement
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        driver.quit();
	}

}
