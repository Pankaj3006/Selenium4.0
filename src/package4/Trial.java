package package4;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Trial {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Actions a = new Actions(driver);
		By link = By.xpath("//a[contains(text(),'Gmail')]");
		//String key = Keys.chord(Keys.CONTROL, Keys.ENTER);
		a.moveToElement(driver.findElement(link)).keyDown(Keys.CONTROL).click().build().perform();
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		while(itr.hasNext())
		{
			System.out.println(driver.switchTo().window(itr.next()).getTitle());
		}
	}

}
