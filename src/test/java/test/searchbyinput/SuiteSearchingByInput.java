package test.searchbyinput;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import pageObject.BasePage;
import pageObject.HomePageObject;
import pageObject.ResultsPageObject;

public class SuiteSearchingByInput extends BasePage {

	/***
	 * Search an specific produc by categories
	 * @param product
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Parameters({ "product" })
	@Test
	public void findProductByInput(String product) throws InterruptedException, IOException {
		
		setup();
		System.out.println("//******Staring SuiteTestSearchingByImput suite**********************//");
		HomePageObject d = new HomePageObject(driver);
		d.inputSearch(product);
		System.out.println("--------------------------------------");
	}

	/***
	 * Shows a results  entering a product into text field.
	 */
	@Test(dependsOnMethods = { "findProductByInput" })
	public void showsResultsByInput() {

		ResultsPageObject r = new ResultsPageObject(driver);
		assertTrue(r.showResultByInpuntSearching());
		System.out.println("--------------------------------------");
	}

	/***
	 * Close all browsers and selenium web drivers
	 */
	@AfterTest
	public void cleanUp() {

		try {
			System.out.println("//******End SuiteTestSearchingByImput suite**********************//");
		} finally {
			finish();
		}
	}

}
