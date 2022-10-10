package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AjioMainPage {

	Actions a ;
	@FindBy(xpath = "//a[@title='MEN']")
	private WebElement men;

	@FindBy(xpath = "(//span[text()='CLOTHING'])[1]")
	private WebElement clothing;

	public AjioMainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		a = new Actions(driver);
	}

	public boolean moveToMen() {
		
		a.moveToElement(men).perform();
		boolean a=men.isDisplayed();
		return a; 
	}

	public void moveToClothing() {
			a.moveToElement(clothing).click().build().perform();

	
	}

}
