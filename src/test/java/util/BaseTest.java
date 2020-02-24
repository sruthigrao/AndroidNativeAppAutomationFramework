package util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	
	public AndroidDriver<MobileElement> driver;
	public Properties properties = new Properties();
	
	
	@BeforeSuite
	public void setup( ) throws Exception {
		properties.load(new FileInputStream(new File("src/test/resources/application.properties")));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", properties.getProperty("device").trim());
		capabilities.setCapability("udid", properties.getProperty("udid").trim());
		capabilities.setCapability("platformName", properties.getProperty("platformName").trim());
		capabilities.setCapability("platformVersion", properties.getProperty("platformVersion").trim());
		capabilities.setCapability("appPackage", properties.getProperty("appPackage").trim());
		capabilities.setCapability("appActivity", properties.getProperty("appActivity").trim());
		driver = new AndroidDriver<MobileElement>(new URL(properties.getProperty("appURL").trim()), capabilities);
	}
	
	
	@AfterSuite
	public void tearDown( ) {
		driver.closeApp();
	}

}
