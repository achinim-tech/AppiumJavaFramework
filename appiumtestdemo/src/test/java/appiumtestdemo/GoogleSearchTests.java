package appiumtestdemo;

import org.testng.annotations.Test;

import common.ConfigurationProvider;
import pages.GoogleResultPage;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

public class GoogleSearchTests extends TestBase {
	
	/**
	 * Search a text in Google
	 */

	@Test(priority = 1)
	public void googleTextSearch() {
		String url = ConfigurationProvider.getConfigurationByKey("config.url");
		driver.get(url);
		GoogleSearchPage GoolgeTestObject = new GoogleSearchPage(driver);
		GoogleSearchResultPage GoogleSearchResultPageObject = new GoogleSearchResultPage(driver);	
		
		GoolgeTestObject.setTextInSearchBox(ConfigurationProvider.getConfigurationByKey("config.searchText"));
		GoolgeTestObject.clickSearchButton();
		
		String weburl = GoogleSearchResultPageObject.getSearchWebURL();
		softAssert.assertEquals(weburl, ConfigurationProvider.getConfigurationByKey("config.resulturl"));
		Logger.info("Google Search is successful");
	}

	/**
	 * Navigate to image list of the Google Search
	 */
	@Test(priority = 2)
	public void googleNavigatetoImagesSearchList() {

		GoogleSearchResultPage GoogleSearchResultPageObject = new GoogleSearchResultPage(driver);
		GoogleSearchResultPageObject.navigatetoImageSearch();

		Logger.info("Google image Search is successful");
	}
	
	/**
	 * Search a text and navigate to the searched web site
	 */
	@Test(priority = 3)
	public void navigatetoSearchResult() {
		String url = ConfigurationProvider.getConfigurationByKey("config.url");
		driver.get(url);
		GoogleSearchPage GoolgeTestObject = new GoogleSearchPage(driver);
		GoogleSearchResultPage GoogleSearchResultPageObject = new GoogleSearchResultPage(driver);
		GoogleResultPage GoogleResultPageObject = new GoogleResultPage(driver);

		GoolgeTestObject.setTextInSearchBox(ConfigurationProvider.getConfigurationByKey("config.searchText"));
		GoolgeTestObject.clickSearchButton();

		GoogleSearchResultPageObject.navigatetoResultWeblink();
		String weburl = GoogleResultPageObject.getResultWebText();
		Logger.info(weburl);
		softAssert.assertEquals(weburl, ConfigurationProvider.getConfigurationByKey("config.resultPageText"));
		Logger.info("Navigation to result web Page is successful");
	}
}
