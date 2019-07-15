package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import util.AppiumUtil;


public class GoogleSearchResultPage extends PageBase {
	
	public static Logger Logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(GoogleSearchResultPage.class);

	By result_link = By.xpath("//span[text()='appium.io']");
	By image = By.xpath("//a[text()='Images']");

	public GoogleSearchResultPage(AndroidDriver driver) {
		super(driver);

	}


	/**
	 * Verify navigation of the image result page
	 */
	public void navigatetoImageSearch() {
		AppiumUtil.waitAndGetElement(driver, image);
		driver.findElement(image).click();
		Logger.info("Image search submission is completed");

	}
	
	/**
	 * Navigation of the result web page
	 */
	
	public void navigatetoResultWeblink() {
		AppiumUtil.waitAndGetElement(driver, result_link);
		driver.findElement(result_link).click();
		Logger.info("Result web page navigation is completed");

	}

	/**
	 * Verify navigation of the result web page
	 */
	public String getSearchWebURL() {

		AppiumUtil.waitAndGetElement(driver, result_link);
		String weburl = driver.findElement(result_link).getText();
		Logger.info("Result Search list is displayed");
		return weburl;
	}

}
