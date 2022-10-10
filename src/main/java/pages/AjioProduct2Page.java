package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjioProduct2Page {
	WebDriverWait wait;

	@FindBy (xpath="(//div[@class='size-swatch'])[3]")
	private WebElement size;
	
	@FindBy (xpath = "//div[@id='edd']")
	private WebElement pincode;
	
	@FindBy (xpath="//div[@class='btn-gold']")
	private WebElement addtobag;
	
	@FindBy (xpath="//div[@class='btn-cart ']")
	private WebElement gotobag;
	
	@FindBy (xpath="//div[@class='order-summary-container']")
	private WebElement getTextofOrder;
	
	public AjioProduct2Page(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		wait =new WebDriverWait(driver,20);
	}
	
	public void selectSizeOfProduct2 () {
		wait.until(ExpectedConditions.visibilityOf(size));
		size.click();
		System.out.println(size.getText());
	}
	
	public void clickPincode () {
		wait.until(ExpectedConditions.visibilityOf(pincode));
		pincode.click();
		System.out.println(pincode.getText());
	}
	
	public void addProductToBag () {
		
		wait.until(ExpectedConditions.visibilityOf(addtobag));
        addtobag.click();
		System.out.println(addtobag.getText());
	}
	
	public void goToBag () {
		wait.until(ExpectedConditions.visibilityOf(gotobag));
		gotobag.click();
		

		//System.out.println(gotobag.getText());
	}
	
	public void getOrderDetails () {
		getTextofOrder.click();
		System.out.println(getTextofOrder.getText());
	}
}
