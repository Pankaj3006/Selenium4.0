package package4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLevelAuthentication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\Drivers\\Chrome Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> str = driver.getWindowHandles();
		Iterator<String> itr = str.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//		Use
//		http://username:password@site.com/page
//		instead of
//		http://site.com/page
	}

}
