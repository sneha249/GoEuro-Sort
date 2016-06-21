package goeuro.page.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * The Class GoEuroResultPage.
 */
public class GoEuroResultPage {
	
	/** The driver. */
	WebDriver driver;
	
	/** The price table. */
	@FindBy(xpath=".//*[@id='results-train']")
	public WebElement priceTable;
	
	/**
	 * Gets the result grid.
	 *
	 * @return the result grid
	 */
	public List<WebElement> getResultGrid(){
	return priceTable.findElements(By.cssSelector(".result"));
	}
	
	/**
	 * Gets the price.
	 *
	 * @param element the element
	 * @return the price
	 */
	public float getPrice(WebElement element){
		return Float.parseFloat(element.findElement(By.cssSelector(".currency-beforecomma")).getText()+"."+ element.findElements(By.cssSelector(".currency-decimals")).get(1).getText());
	}
	
	/**
	 * Instantiates a new go euro result page.
	 *
	 * @param driver the driver
	 */
	public GoEuroResultPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
