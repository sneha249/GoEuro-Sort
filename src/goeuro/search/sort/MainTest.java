package goeuro.search.sort;

import goeuro.page.object.GoEuroResultPage;
import goeuro.page.object.GoEuroSearchPage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// TODO: Auto-generated Javadoc
/**
 * The Class MainTest.
 */
public class MainTest {
	
	/** The driver. */
	WebDriver driver;
	
	/** The goeurosearchpage. */
	GoEuroSearchPage goeurosearchpage;
	
	/** The goeuroresultpage. */
	GoEuroResultPage goeuroresultpage;
	
	/** The w. */
	WebDriverWait w;
	
	/** The sft. */
	SoftAssert sft=new SoftAssert();
	
	/** The price1. */
	Float price1;
	
	/** The price2. */
	Float price2;
	
	/**
	 * Setup.
	 */
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(GoEuroConstants.baseURL);
		driver.manage().window().maximize();
		w=new WebDriverWait(driver, 10);
		
	}
	
	
	/**
	 * Search_ for_ flight.
	 *
	 * 
	 */
	@Test(priority=0,description="Test to validate price sort from low to high")
	public void Test_For_Train_PriceList()
	{
		goeurosearchpage=new GoEuroSearchPage(driver);
		goeuroresultpage= new GoEuroResultPage(driver);
		
		goeurosearchpage.setFromCity(GoEuroConstants.from_Country);
		goeurosearchpage.setToCity(GoEuroConstants.to_Country);
		
		// Issues with click , hence having redundant code
		
		w.until(ExpectedConditions.elementToBeClickable(goeurosearchpage.searchButton));
		goeurosearchpage.clickSearch();
		goeurosearchpage.searchButton.click();
		goeurosearchpage.searchButton.sendKeys(Keys.ENTER);
		
		List<WebElement> elements = goeuroresultpage.getResultGrid();
		price_Validation(elements);
	}
	

	/**
	 * Price_ validation.
	 *
	 * @param elements the elements
	 */
	public void price_Validation(List<WebElement> elements){
		//System.out.println(Arrays.toString(elements.toArray()));
		
		for(int i=0;i<=elements.size()-2;i++){
			price1 =goeuroresultpage.getPrice(elements.get(i));
			price2 =goeuroresultpage.getPrice(elements.get(i+1));
			System.out.println("The price for row" + (i+1) + " : "+price1);
			int result=Float.compare(price1, price2);
			sft.assertTrue(result == 0 || result < 0 ,"Price for row " +i+" : " + price1 + ". Price for row " + (i+1) +": " +price2 + "Result is : " + result);
		}
		System.out.println("The price for row" +elements.size() + " : "+price2);
		sft.assertAll();
	}
		
		/**
		 * Tear down.
		 */
		@AfterTest(alwaysRun=true)
		public void tearDown(){
			driver.close();
			driver.quit();
		}
		
		
		
	
	

}
