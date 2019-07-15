package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppiumUtil {

	private AppiumUtil() {
	}

	public static WebElement waitAndGetElement(AndroidDriver driver, By elementLocator) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}

}
