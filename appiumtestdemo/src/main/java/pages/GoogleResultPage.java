package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;
import util.AppiumUtil;


public class GoogleResultPage extends PageBase {

	public static Logger Logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(GoogleResultPage.class);
	
	By result_page_element = By.xpath("//a[text()='Appium']");
	
	public GoogleResultPage(AndroidDriver driver) {
		super(driver);

	}

	/**
	 * Verify navigation of the result page
	 */
	public String getResultWebText() {

		AppiumUtil.waitAndGetElement(driver, result_page_element);
		String weburl = driver.findElement(result_page_element).getText();
		Logger.info("Result Page navigation is completed");
		return weburl;
	}


}
