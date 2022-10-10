package maven_ajio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.AjioClothingPage;
import pages.AjioEnterPinCode;
import pages.AjioMainPage;
import pages.AjioProduct2Page;

public class VerifyAjioMainPage {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"C:\\selenuim\\chromedriver_win32\\chromedriver.exe");
		
		
				FileInputStream MOCK = new FileInputStream("C:\\Users\\Abhijeet" 
			+ "\\Desktop\\New folder\\MOCK.xlsm");
				for (int i =0; i<=3; i++) {
				String data = WorkbookFactory.create(MOCK)
						.getSheet("sheet2").getRow(i).getCell(0).
						    getStringCellValue();
				System.out.println(data);
				}
//				double data1 = WorkbookFactory.create(MOCK)
//						.getSheet("sheet2").getRow(2).getCell(2).getNumericCellValue();
//				System.out.println(data1);
//		
		//		WebDriver driver = new ChromeDriver(option);
//		driver.get("https://www.ajio.com/");
//
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		AjioMainPage ajioMainPage = new AjioMainPage(driver);
//
//		String urlmainpage = driver.getCurrentUrl();
//		String titlemainpage = driver.getTitle();
//		if (urlmainpage.equals("https://www.ajio.com/")
//				&& titlemainpage.equals("Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO")) {
//			System.out.println("Testcasepass");
//		} else {
//			System.out.println("Testcasefail");
//		}
//
//		ajioMainPage.moveToMen();
//		ajioMainPage.moveToClothing();
//
//		AjioClothingPage AjioClothingPage = new AjioClothingPage(driver);
//		
//		AjioClothingPage.clickOnMenGender();
//		
//		AjioClothingPage.clickOnMenThsirts();
//		
//		AjioClothingPage.clickOnMenJeans();
//		
//		AjioClothingPage.clickOnPricePlusTab();
//		
//		AjioClothingPage.selectPriceBetween();
//		
//		AjioClothingPage.selectProduct1();
//		
//		AjioClothingPage.selectProduct2();
//		
//		//AjioClothingPage.selectProduct3();
//		
//
//		ArrayList<String> s = new ArrayList<String>(driver.getWindowHandles());
//		System.out.println(s);
//		driver.switchTo().window(s.get(2));
//		
//		String url = driver.getCurrentUrl();
//		String title = driver.getTitle();
//		if (url.equals(
//				"https://www.ajio.com/s/clothing-4461-74581?query=%3Arelevance%3Agenderfilter%3AMen%3Al1l3nestedcategory%3AMen%20-%20Tshirts%3Al1l3nestedcategory%3AWomen%20-%20Tshirts%3Apricerange%3ARs.500-1000&curated=true&curatedid=clothing-4461-74581&gridColumns=3")
//				&& title.equals("Clothing")) {
//			System.out.println("Testcasepass");
//		} else {
//			System.out.println("Testcasefail");
//		}
//
//		AjioProduct2Page AjioProduct2Page = new AjioProduct2Page(driver);
//		AjioProduct2Page.selectSizeOfProduct2();
//		
//		AjioProduct2Page.clickPincode();
//		
//		AjioEnterPinCode AjioEnterPinCode = new AjioEnterPinCode(driver);
//		AjioEnterPinCode.enterPinCode();
//		
//		AjioEnterPinCode.clickOnSubmitPinCodeButton();
//		
//		AjioProduct2Page.addProductToBag();
//		
//		
//		AjioProduct2Page.goToBag();
//		
//		AjioProduct2Page.getOrderDetails();
//		

	}

}
                                                                                        