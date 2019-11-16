package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	/* Aerowindows */
	By classCloseAeroWindowLocator = By.className("close-layer");
	By classContainerLocator = By.className("ui-window-content");
	/* Imput search */
	By idSearchLocator = By.id("search-key");
	By classIconSearchLocator = By.className("search-button");
	/* Left panel */
	By classCategoriesContainerLocator = By.className("categories-list-box");
	static final String CRITERIA = "Phones & Telecommunications";

	/***
	 * This method enters the product or item to search into the text field, then press on the "magnifying glass" 
	 * icon to make a search.
	 * @param product, this parameter comes from the XML file.And indicates the product  to be searched.
	 * @throws InterruptedException
	 */
	public void inputSearch(String product) throws InterruptedException {
		aeroWindows();
		driver.findElement(idSearchLocator).click();
		driver.findElement(idSearchLocator).sendKeys(product);
		driver.findElement(classIconSearchLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/***
	* This method close the aeroWindows that appears when the page is loaded.
	*/
	public void aeroWindows() {
		if (driver.findElement(classCloseAeroWindowLocator).isDisplayed())
			driver.findElement(classCloseAeroWindowLocator).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/***
	 * This method select an option from the left panel. The option searched comes from CRITERIA
	 */
	public void selectOptionLeftPanel() {
		List<WebElement> childrenElementsDl = null;
		WebElement childrenElemntsbyA = null;
		WebElement childrenContainer = driver.findElement(classCategoriesContainerLocator);
		childrenElementsDl = childrenContainer.findElements(By.tagName("dl"));
		if (!childrenElementsDl.isEmpty()) {
			for (WebElement cell : childrenElementsDl) {
				childrenElemntsbyA = cell.findElement(By.tagName("a"));
				if (childrenElemntsbyA.getText().equals(CRITERIA)) {
					childrenElemntsbyA.click();
					break;
				}
			}

		}
	}
}
