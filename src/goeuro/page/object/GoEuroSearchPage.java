package goeuro.page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// TODO: Auto-generated Javadoc
/**
 * The Class GoEuroSearchPage.
 */
public class GoEuroSearchPage {
	
	/** The driver. */
	WebDriver driver;
	
	/** The from location. */
	@FindBy(id="from_filter")
	public WebElement fromLocation;
	
	/** The to location. */
	@FindBy(id="to_filter")
	public WebElement toLocation;
	
	/** The search button. */
	@FindBy(xpath="//div[3]/div[2]/input")
	public WebElement searchButton;
	
	/**
	 * Instantiates a new go euro search page.
	 *
	 * @param driver the driver
	 */
	public GoEuroSearchPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Sets the from city.
	 *
	 * @param fromCity the new from city
	 */
	public void setFromCity(String fromCity){
		fromLocation.clear();
		fromLocation.sendKeys(fromCity);
	}
	
	/**
	 * Sets the to city.
	 *
	 * @param toCity the new to city
	 */
	public void setToCity(String toCity){
		toLocation.clear();
		toLocation.sendKeys(toCity);
	}
	
	/**
	 * Click search.
	 */
	public void clickSearch(){
		searchButton.submit();;
	}

}