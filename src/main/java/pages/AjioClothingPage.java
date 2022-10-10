package src.main.java.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  AjioClothingPage {

	WebDriverWait wait;

	@FindBy(xpath = "//label[@for='Men']")
	private WebElement clothMenGender;

	@FindBy(xpath = "//label[@for='Men - Tshirts']")
	private WebElement menTshirts;

	@FindBy(xpath = "//label[@for='Men - Jeans']")
	private WebElement menJeans;

	@FindBy(xpath = "(//div[@class='facet-head '])[1]")
	private WebElement pricePlus;

	@FindBy(xpath = "//label[@for='Rs.500-1000']")
	private WebElement priceBetween;

	@FindBy(xpath = "(//body//div//div[@class='contentHolder'])[1]")
	private WebElement product1;

	@FindBy(xpath = "(//body//div//div[@class='contentHolder'])[2]")
	//@FindBy(xpath = "(//a[@target='_blank']//div[@class='contentHolder'])[1]")
	private WebElement product2;

//	@FindBy(xpath = "(//body//div//div[@class='contentHolder'])[3]")
//	private WebElement product3;

	public AjioClothingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	public void clickOnMenGender() {
		clothMenGender.click();
		System.out.println(clothMenGender.getText());
	}

	public void clickOnMenThsirts() {
		menTshirts.click();
		System.out.println(menTshirts.getText());

	}

	public void clickOnMenJeans() {
		wait.until(ExpectedConditions.visibilityOf(menJeans));
		menJeans.click();
		System.out.println(menJeans.getText());
	}

	public void clickOnPricePlusTab() {
		wait.until(ExpectedConditions.visibilityOf(pricePlus));
		pricePlus.click();
		System.out.println(pricePlus.getText());

	}

	public void selectPriceBetween() {
		priceBetween.click();
		System.out.println(priceBetween.getText());
        System.out.println("===================================");


	}

	public void selectProduct1() {
		wait.until(ExpectedConditions.visibilityOf(product1));
		product1.click();
        System.out.println("===================================");


	}

	public void selectProduct2() {
		wait.until(ExpectedConditions.visibilityOf(product2));
		product2.click();
        System.out.println("===================================");


	}

//	public void selectProduct3() {
//		wait.until(ExpectedConditions.visibilityOf(product3));
//		product3.click();
//        System.out.println("===================================");
//
//
//	}

	public void selectRefineByProducts() {
		wait.until(ExpectedConditions.visibilityOf(clothMenGender));
		clothMenGender.click();
		System.out.println(clothMenGender.getText());
		System.out.println("===================================");

		wait.until(ExpectedConditions.visibilityOf(menTshirts));
		menTshirts.click();
		System.out.println(menTshirts.getText());
		System.out.println("===================================");

		wait.until(ExpectedConditions.visibilityOf(menJeans));
		menJeans.click();
		System.out.println(menJeans.getText());
		System.out.println("===================================");

		wait.until(ExpectedConditions.visibilityOf(pricePlus));
		pricePlus.click();
		System.out.println(pricePlus.getText());
		System.out.println("===================================");

		wait.until(ExpectedConditions.visibilityOf(priceBetween));
		priceBetween.click();
		System.out.println(priceBetween.getText());
        System.out.println("===================================");



	}

	public void selectProducts() {

		product1.click();
		wait.until(ExpectedConditions.visibilityOf(product1));
		System.out.println(product1.getText());
        System.out.println("===================================");

		product2.click();
		wait.until(ExpectedConditions.visibilityOf(product2));
		System.out.println(product2.getText());
		System.out.println("===================================");

//		product3.click();
//		wait.until(ExpectedConditions.visibilityOf(product3));
//		System.out.println(product3.getText());
//		System.out.println("===================================");


	}
}
