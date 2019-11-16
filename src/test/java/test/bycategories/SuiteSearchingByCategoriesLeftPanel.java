package test.bycategories;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;

import pageObject.BasePage;
import pageObject.HomePageObject;
import pageObject.ResultsPageObject;

public class SuiteSearchingByCategoriesLeftPanel extends BasePage {

	/***
	 * Search an specific produc by categories
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void findProductByCategories() throws InterruptedException, IOException {	
		setup();
		System.out.println("//******Staring SuiteTestSearchingByCategoriesLeftPanel suite**********************//");
		HomePageObject d = new HomePageObject(driver);
		d.aeroWindows();
		d.selectOptionLeftPanel();
		System.out.println("--------------------------------------");
	}

	/***
	 * Show the results by categories.
	 */
	@Parameters({ "product" })
	@Test(dependsOnMethods = { "findProductByCategories" })
	public void showsResultsByCategories(String product) {

		ResultsPageObject r = new ResultsPageObject(driver);
		assertTrue(r.showResultByLeftPanelSearching(product));
		System.out.println("--------------------------------------");
	}

	/***
	 * Close all browsers and selenium web drivers
	 */
	@AfterTest
	public void cleanUp() {
		try {
			System.out.println("//******End SuiteTestSearchingByCategoriesLeftPanel suite**********************//");
		} finally {
		  finish();
		}
	}

}
