package appiumtestdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import common.ConfigurationProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;

public class TestBase {

	protected AndroidDriver driver;

	protected SoftAssert softAssert;
	protected static Logger Logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(TestBase.class);

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,
				ConfigurationProvider.getConfigurationByKey("config.deviceName"));
		cap.setCapability(MobileCapabilityType.UDID, ConfigurationProvider.getConfigurationByKey("config.udid"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,
				ConfigurationProvider.getConfigurationByKey("config.platformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,
				ConfigurationProvider.getConfigurationByKey("config.platformversion"));
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,
				ConfigurationProvider.getConfigurationByKey("config.browser"));

		URL url = new URL(ConfigurationProvider.getConfigurationByKey("config.appiumserverurl"));
		driver = new AndroidDriver<MobileElement>(url, cap);
		Logger.info("Appium server started");

	}

	@BeforeMethod
	public void commonTestSetUp() {
		softAssert = new SoftAssert();
	}

	@AfterClass
	public void closeDriver() {
		driver.quit();
		Logger.info("Appium server stopped");

	}

}
