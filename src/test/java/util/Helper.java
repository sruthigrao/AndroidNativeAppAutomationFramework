package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Helper {
	
	
	public AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	public Properties properties;
	
	
	public Helper(AndroidDriver<MobileElement> driverObj, Properties prop) throws Exception {
		this.driver = driverObj;
		this.properties = prop;
		wait = new WebDriverWait(driver, 15);
	}

	public WebElement getElement(String locator,  String value) {
		WebElement element = null;
		if(locator.equalsIgnoreCase("id")) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value))); 
		}
		else if(locator.equalsIgnoreCase("xpath")) {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		}
		return element;
	}
	
	
	
	public MobileElement scrollAndReturnUsingText(String scrollElement, String elementToFind) {
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+scrollElement+"\")).scrollIntoView("
						+ "new UiSelector().text(\""+elementToFind+"\"));"));
		return element;
						
	}
	
	public void hideMobileKeyBoard() throws Exception {
		driver.hideKeyboard();
		Thread.sleep(5000);
	}
	
}
