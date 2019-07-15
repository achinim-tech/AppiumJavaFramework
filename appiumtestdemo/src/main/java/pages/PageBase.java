package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class PageBase {

	protected AndroidDriver driver;

	public static Logger Logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(PageBase.class);

	public PageBase(AndroidDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
