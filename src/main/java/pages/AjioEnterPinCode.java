package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjioEnterPinCode {

	@FindBy(xpath = "// input[@class='edd-pincode-modal-text']")
	private WebElement enterpincode;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement submitpincode;

	public AjioEnterPinCode(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void enterPinCode() {

		enterpincode.click();
		enterpincode.sendKeys("464668");
	}

	public void clickOnSubmitPinCodeButton() {

		submitpincode.click();

	}

}
