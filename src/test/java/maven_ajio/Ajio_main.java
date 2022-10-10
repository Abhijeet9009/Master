package maven_ajio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio_main {

	public static void main(String[] args) throws IOException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\selenuim\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.ajio.com/");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement men = driver.findElement(By.xpath("//a[@title='MEN']"));
		Actions a = new Actions(driver);
		a.moveToElement(men).perform();
		System.out.println(men.getText());

		WebElement clothing = driver.findElement(By.xpath("(//span[text()='CLOTHING'])[1]"));
		a.moveToElement(clothing).click().perform();
		// System.out.println(cloth.getText());

		WebElement clothmen = driver.findElement(By.xpath("//label[@for='Men']"));
		a.moveToElement(clothmen).click().perform();
		System.out.println(clothmen.getText());

		WebElement Tshirts = driver.findElement(By.xpath("//label[@for='Men - Tshirts']"));
		a.moveToElement(Tshirts).click().perform();
		System.out.println(Tshirts.getText());

		WebElement jeans = driver.findElement(By.xpath("//label[@for='Men - Jeans']"));
		a.moveToElement(jeans).click().perform();
		System.out.println(jeans.getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement priceplus = driver.findElement(By.xpath("//span[text()='price']"));
		js.executeScript("arguments[0].scrollIntoView(true);", priceplus);
		System.out.println(priceplus.getText());
		priceplus.click();
		
		//WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));//4th version
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Rs.500-1000']")));
		WebElement price = driver.findElement(By.xpath("//label[@for='Rs.500-1000']"));
		a.moveToElement(price).click().perform();
		System.out.println(price.getText());

		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));4th version
		WebDriverWait wait =new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a//div[@class='imgHolder'])[1]")));
		WebElement productlee = driver.findElement(By.xpath("(//a//div[@class='imgHolder'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", productlee);
		productlee.click();

		WebElement netplay = driver.findElement(By.xpath("(//body//div//div[@class='contentHolder'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", netplay);
		netplay.click();

		WebElement full = driver.findElement(By.xpath("(//div[@class=\"brand\"])[25]"));
		js.executeScript("arguments[0].scrollIntoView(true);", full);
		full.click();
//=================================================================================
		ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(s.get(0));
		System.out.println(driver.getCurrentUrl());

		s = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(s.get(1));
		System.out.println(driver.getCurrentUrl());

		driver.switchTo().window(s.get(2));

		WebElement size = driver.findElement(By.xpath("//span[text()='XL']"));
		a.moveToElement(size).click().perform();
	//===================================================================================	
		WebElement pincode = driver.findElement(By.xpath("//span[contains(@class,'edd-pincode-msg-details ')]"));
		a.moveToElement(pincode).click().perform();
		
		WebElement enterpincode = driver.findElement(By.xpath("// input[@class='edd-pincode-modal-text']"));
		a.moveToElement(enterpincode).click().sendKeys("464668").build().perform();
		
		WebElement submitpincode = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		a.moveToElement(submitpincode).click().build().perform();
	//==============================================================================================
		WebElement addtobag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		a.moveToElement(addtobag).click().perform();

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\New folder\\ajio1.jpg");
		FileHandler.copy(source, dest);

		WebElement gotobag = driver.findElement(By.xpath("//span[text()='GO TO BAG']"));
		a.moveToElement(gotobag).click().perform();

		WebElement buttonproceed = driver.findElement(By.xpath("//button[text()='Proceed to shipping']"));
		a.moveToElement(buttonproceed).click().perform();
		
		driver.close();
		
	}

}
