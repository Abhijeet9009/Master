package maven_ajio_base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseClass {
	
public static WebDriver openChromeBrowser () {

	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver",
			"C:\\selenuim\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(option);
	return driver;

}
public static WebDriver openEdgeBrowser () {

	EdgeOptions option = new 	EdgeOptions();
	option.setCapability("--disable-notifications",true);
	System.setProperty("webdriver.edge.driver",
			"C:\\selenuim\\edgedriver_win32\\msedgedriver.exe");
	WebDriver driver = new EdgeDriver(option);
	return driver;

}
}
