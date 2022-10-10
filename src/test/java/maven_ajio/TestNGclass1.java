package maven_ajio;

import java.io.File;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import maven_ajio_base.BaseClass;
import pages.AjioClothingPage;
import pages.AjioEnterPinCode;
import pages.AjioMainPage;
import pages.AjioProduct2Page;
import pages.AjioProductAddtoCartPage;
import pages.LoginwithFacebookAccount;
import utils.Utility;


public class TestNGclass1 extends BaseClass {

	private WebDriver driver;
	private ArrayList<String> s;
	private AjioProduct2Page AjioProduct2Page;
	private AjioClothingPage AjioClothingPage;
	private AjioEnterPinCode AjioEnterPinCode;
	private AjioMainPage ajioMainPage;
	private AjioProductAddtoCartPage AjioProductAddtoCartPage;
	private LoginwithFacebookAccount loginwithFacebookAccount;
	private String data;
	int testID;
	@BeforeSuite
	public void beforeMethod() {
		System.out.println("before suit");
	}
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browsername) {

		if (browsername.equals("chrome")) 
		{
			driver = openChromeBrowser();
		}
		if (browsername.equals("edge")) 
		{
			driver = openEdgeBrowser();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeClass
	public void createPOMObjects()
	{
		AjioClothingPage = new AjioClothingPage(driver);
		AjioProduct2Page = new AjioProduct2Page(driver);
		AjioEnterPinCode = new AjioEnterPinCode(driver);
		ajioMainPage = new AjioMainPage(driver);
		AjioProductAddtoCartPage = new AjioProductAddtoCartPage(driver);
		loginwithFacebookAccount = new LoginwithFacebookAccount(driver);
		s = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("before class");
		driver.get("https://www.ajio.com/");

	}
	@BeforeMethod 
	public void goToProductpage()
	{
		System.out.println("before method========");
	}

	@Test(priority = 1, enabled=false)//
	public void loginWithFb() throws InterruptedException, EncryptedDocumentException, IOException {
		testID=11;
		WebElement signup = driver.findElement(By.xpath("//span[text()='Sign In / Join AJIO']"));
		signup.click();
		loginwithFacebookAccount.clickOnfacebook();
		Thread.sleep(3000);
		s = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(s.get(1));
		// driver.switchTo().window(s.get(3));
		Thread.sleep(4000);
		data=Utility.getExcelldata("sheet2",2,2);
		System.out.println(data);
		loginwithFacebookAccount = new LoginwithFacebookAccount(driver);
		loginwithFacebookAccount.enter_email_username(data);
		data=Utility.getExcelldata("sheet2",3,1);
		System.out.println(data);
		loginwithFacebookAccount.enter_password(data);
		loginwithFacebookAccount.ClickOnCheckbox();
		loginwithFacebookAccount.ClickOnlogin();
		Thread.sleep(5000);
		// driver.switchTo().window(s.get(0));
	}

	@Test(priority = 2)
	public void test1AjioHomePage() {
		testID=112;
		System.out.println("test");

		String urlmainpage = driver.getCurrentUrl();
		String titlemainpage = driver.getTitle();
		
		String url="https://www.ajio.com/";
		String title="Online Shopping for" + " Women, Men, Kids – Clothing, Footwear | AJIO";
		Assert.assertEquals(urlmainpage, url,"invalid url homepage");
		Assert.assertEquals(titlemainpage, title,"invalid title homepage");
		System.out.println(urlmainpage);
		System.out.println(titlemainpage);
		ajioMainPage.moveToMen();
		ajioMainPage.moveToClothing();

	}
	@Test(priority = 3)
	public void hoverToMen() {
		System.out.println("test");
		testID=113;
		boolean a= ajioMainPage.moveToMen();
		Assert.assertEquals(a,true);
		System.out.println(a);
		ajioMainPage.moveToClothing();
		
	}
	@Test(priority = 4)
	public void selectProductsWithFilters() {
		testID=114;
		AjioClothingPage.selectRefineByProducts();
		AjioClothingPage.selectProducts();
	}
	@Test(priority = 5 )//dependsOnMethods = "selectProductsWithFilters"
	public void openProductListingPage() throws InterruptedException {
		testID=115;
		s = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(3000);
		driver.switchTo().window(s.get(1));
		Thread.sleep(3000);
		AjioProduct2Page.selectSizeOfProduct2();
		AjioProduct2Page.clickPincode();
	}
	@Test(priority = 6)//, dependsOnMethods = "openProductListingPage"
	public void enterPincode() throws InterruptedException {
		testID=116;
		AjioEnterPinCode.enterPinCode();
		AjioEnterPinCode.clickOnSubmitPinCodeButton();
		Thread.sleep(3000);
	}
	@Test(priority = 7, dependsOnMethods = "enterPincode")
	public void gotTOBag() throws IOException, InterruptedException {
		testID=117;
		AjioProduct2Page.addProductToBag();
		AjioProduct2Page.goToBag();
		AjioProductAddtoCartPage.clickOnProceedButton();
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
	if (ITestResult.FAILURE==result.getStatus())
		{
		System.out.println("After method");
	     Utility.takeScreenshot(driver,testID);
		}
	}
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass method");
	}
	@AfterTest
	public void closeBrowser () {
		System.out.println("After test");
		driver.quit();
		driver=null;
		System.gc();
	}
	@AfterSuite
	public void afterMethodbefore() {
		System.out.println("After suit");
	}

}
