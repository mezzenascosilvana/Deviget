package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPageObject {

	WebDriver driver;

	public ResultsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	static final int ELEMENT_TO_FIND = 1;
	By classTopContainerLocator = By.className("list-items");
	By classListItemContainerLocator = By.className("list-items");

	/***
	 * This method shows the results of an input searching.
	 * @return true value, if was possible to find a result.
	 */
	public boolean showResultByInpuntSearching() {
		boolean result = false;
		List<WebElement> childrenElements = null;
		List<WebElement> childrenElementsbyClass = null;
		WebElement childrenContainer = driver.findElement(classTopContainerLocator);
		childrenElements = childrenContainer.findElements(By.tagName("li"));
		int j = 0;
		if (!childrenElements.isEmpty()) {
			for (WebElement cell : childrenElements) {
				childrenElementsbyClass = cell.findElements(By.className("spu-info"));
				if (showTheElementSelectByIndex(j++, childrenElementsbyClass)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	/***
	 * This method show in console the element indicated in the position ELEMT_TO_FIN.
	 * @param index 
	 * @param childrenElemntsbyClass: List of WebElement
	 * @return true value, if was possible to find a result.
	 */
	public boolean showTheElementSelectByIndex(int index, List<WebElement> childrenElemntsbyClass) {
		boolean result = false;
		if (index == ELEMENT_TO_FIND) {
			System.out.println(childrenElemntsbyClass.get(0).getText());
			result = true;
		}
		return result;
	}

	/***
	 * This method shows the results if you make a search from the left panel.
	 * @param product: this parameter comes from the XML file.And indicates the product  to be searched.
	 * @return true value, if was possible to find a result.
	 */
	public boolean showResultByLeftPanelSearching(String product) {
		boolean result = false;
		List<WebElement> childrenElements;
		List<WebElement> childrenElementsbyClass;
		WebElement childrenContainer = driver.findElement(classListItemContainerLocator);
		childrenElements = childrenContainer.findElements(By.tagName("li"));
		int j = 0;
		if (!childrenElements.isEmpty()) {
			for (WebElement cell : childrenElements) {
				childrenElementsbyClass = cell.findElements(By.className("item-title-wrap"));
				if (verifyAndShowTheElementSearchedByIndex(j, childrenElementsbyClass, product) ) {
					result = true;
					break;
				}
				if (j>= ELEMENT_TO_FIND)break;
				j++;
			}
		}
		return result;
	}

	/***
	 * This method verifies if the second element showing on the result page is matching with the product searching
	 * @param j: is the index of the list
	 * @param product: this parameter comes from the XML file.And indicates the product  to be searched.
	 * @param childrenElemntsbyClass: List of WebElement
	 * @return true value, if was possible to find a result.
	 */
	public boolean verifyAndShowTheElementSearchedByIndex(int j, List<WebElement> childrenElementsbyClass, String product) {
		boolean result = false;
		String textFromPage = textFromPage = childrenElementsbyClass.get(0).getText();
			if( j == ELEMENT_TO_FIND) {
			if (textFromPage.toLowerCase().contains(product.toLowerCase())) {
				System.out.println(
						"The item " + ELEMENT_TO_FIND + "is related with "+ product + "==> "+ childrenElementsbyClass.get(0).getText());
				result = true;
			} else {
				System.out.println("The item " + ELEMENT_TO_FIND + "is NOT related with "+ product + "==> "+ childrenElementsbyClass.get(0).getText());
			}
			}
		return result;
	}

}
