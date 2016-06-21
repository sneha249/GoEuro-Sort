package goeuro.search.sort;

import goeuro.page.object.GoEuroResultPage;
import goeuro.page.object.GoEuroSearchPage;
import goeuro.utils.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 



// TODO: Auto-generated Javadoc
/**
 * The Class MainTest.
 */
@Listeners(ListenerUtil.class)
public class MainTest {
	
	/** The log. */
	private static java.util.logging.Logger LOG = LoggingUtil.createLogger(
			MainTest.class, "GoEuroTest", true);
	
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
	 * Launches the URl. Defines the implicit timeout
	 */
	@BeforeTest
	public void setup()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LOG.info("Launching the URL :" + GoEuroConstants.baseURL);
		driver.get(GoEuroConstants.baseURL);
		driver.manage().window().maximize();
		w=new WebDriverWait(driver, 10);
		
	}
	
	
	/**
	 * Search_ for_ flight.
	 *This enters the city details and makes a search
	 * 
	 */
	
	@Test(priority=0,description="Test to validate price sort from low to high")
	public void Test_For_Train_PriceList()
	{
		goeurosearchpage=new GoEuroSearchPage(driver);
		goeuroresultpage= new GoEuroResultPage(driver);
		
		goeurosearchpage.setFromCity(GoEuroConstants.from_Country);
		goeurosearchpage.setToCity(GoEuroConstants.to_Country);
		LOG.info("Entered the from and to cities :" + GoEuroConstants.from_Country +" and " + GoEuroConstants.to_Country);
		
		
		// Issues with click , hence having redundant code. Looks like compatibility issue with the firefox version I am using 45.0.1
		
		w.until(ExpectedConditions.elementToBeClickable(goeurosearchpage.searchButton));
		goeurosearchpage.clickSearch();
		goeurosearchpage.searchButton.click();
		goeurosearchpage.searchButton.sendKeys(Keys.ENTER);
		LOG.info("Clicked Search button");
		
		List<WebElement> elements = goeuroresultpage.getResultGrid();
		price_Validation(elements);
	}
	

	/**
	 * Price_ validation.
	 *This is to validate the prices displayed in the result. The prices should be in ascending order
	 * @param elements the elements
	 */
	public void price_Validation(List<WebElement> elements){
		for(int i=0;i<=elements.size()-2;i++){
			price1 =goeuroresultpage.getPrice(elements.get(i));
			price2 =goeuroresultpage.getPrice(elements.get(i+1));
			LOG.info("The price for row" + (i+1) + " : "+price1);
			int result=Float.compare(price1, price2);
			sft.assertTrue(result == 0 || result < 0 ,"Price for row " +i+" : " + price1 + ". Price for row " + (i+1) +": " +price2 + "Result is : " + result);
		}
		LOG.info("The price for row" +elements.size() + " : "+price2);
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
