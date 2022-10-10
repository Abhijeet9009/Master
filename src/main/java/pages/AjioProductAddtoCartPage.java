package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioProductAddtoCartPage {
	
	@FindBy (xpath="//button[text()='Proceed to shipping']")
	private WebElement proceedbutton;
	
	public AjioProductAddtoCartPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void  clickOnProceedButton () {
		proceedbutton.click();
	}
	
	
}
