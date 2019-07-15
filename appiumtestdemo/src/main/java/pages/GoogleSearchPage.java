package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class GoogleSearchPage extends PageBase {
	
	public static Logger Logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(GoogleSearchPage.class);

	By txtbox_search = By.name("q");
	By button_search = By.name("btnK");
	By result_link = By.xpath("//cite[text()='appium.io/']");

	public GoogleSearchPage(AndroidDriver driver) {
		super(driver);

	}

	/**
	 * Send search text
	 */
	public void setTextInSearchBox(String text) {

		driver.findElement(txtbox_search).sendKeys(text);
		Logger.info("Enter text search is completed");
	}
	
	/**
	 * Submit search text
	 */

	public void clickSearchButton() {

		driver.findElement(txtbox_search).sendKeys(Keys.ENTER);
		Logger.info("Text search submission is completed");
	}

}
