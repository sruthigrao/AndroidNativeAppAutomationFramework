package appPages;

import java.util.Properties;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import util.Helper;

public class Registration extends Helper {
	
	Activity activity;
	
	
	String email = "com.thefloow.thefloowltd.floowdrive.app:id/register_email_address";
	String passwordField = "com.thefloow.thefloowltd.floowdrive.app:id/register_password";
	String repeatPassword = "com.thefloow.thefloowltd.floowdrive.app:id/register_confirm_password";
	String firstNameFld = "com.thefloow.thefloowltd.floowdrive.app:id/register_forename";
	String surNameFld = "com.thefloow.thefloowltd.floowdrive.app:id/register_surname";
	String dateOfBirthFld = "com.thefloow.thefloowltd.floowdrive.app:id/register_dob";
	String zipCode = "com.thefloow.thefloowltd.floowdrive.app:id/register_postcode";
	String acceptTerms = "com.thefloow.thefloowltd.floowdrive.app:id/chk_agree";
	String register = "com.thefloow.thefloowltd.floowdrive.app:id/btn_register";
	String swipeRight1 = "com.thefloow.thefloowltd.floowdrive.app:id/welcome_next_button";
	String swipeRight2 = "com.thefloow.thefloowltd.floowdrive.app:id/btn_next";
	String requestPermission = "com.thefloow.thefloowltd.floowdrive.app:id/request_permissions_btn";
	String popupAllow = "com.android.packageinstaller:id/permission_allow_button";
	String skipContinue = "com.thefloow.thefloowltd.floowdrive.app:id/skip_continue_btn";
	String settingsButton = "com.thefloow.thefloowltd.floowdrive.app:id/settings_btn";
	String pageScrollId = "android:id/content";
	
	
	public Registration(AndroidDriver<MobileElement> driver, Properties properties) throws Exception {
		super(driver, properties);
	}
	
	
	public void submitFormForNewUser(String emailID, String password, String firstName, String surName, String date, String code) throws Exception {
		getElement("id", email).sendKeys(emailID);
		getElement("id", passwordField).sendKeys(password);
		getElement("id", repeatPassword).sendKeys(password);
		getElement("id", firstNameFld).sendKeys(firstName);
		getElement("id", surNameFld).sendKeys(surName);
		scrollAndReturnUsingText(pageScrollId, "Date of birth").click();
		Thread.sleep(3000);
		selectDate(date);
		getElement("id", zipCode).sendKeys(code);
		getElement("id", acceptTerms).click();
		hideMobileKeyBoard();
		scrollAndReturnUsingText(pageScrollId, "Register");
		getElement("id", register).click();

	}
	
	
	public void selectDate(String date) throws Exception {
		getElement("xpath","//android.view.View[@content-desc='"+date+"']").click();
		Thread.sleep(3000);
		getElement("id", "android:id/button1").click();
	}
	
	
	public void skipSteps() {
		getElement("id", swipeRight1).click();
		getElement("id", swipeRight2).click();
	}
	
	
	public void setPermission() {
		getElement("id", requestPermission).click();
		getElement("id", popupAllow).click();
	}
	
	public void configureSettings() throws Exception {
		getElement("id", skipContinue).click();
		getElement("id", settingsButton).click();
		driver.navigate().back();
	}
	
	
	public void verifyHomePage() {
		activity = new Activity(properties.getProperty("appPackage").trim(), properties.getProperty("appActivity").trim());
		activity.setStopApp(false);
		driver.startActivity(activity);
		getElement("xpath","/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.RelativeLayout/android.widget.ImageView");
	}
	
	public void logout() throws Exception {
		getElement("xpath","/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[3]/android.widget.RelativeLayout/android.widget.ImageView").click();
		getElement("id", "com.thefloow.thefloowltd.floowdrive.app:id/list_item_text_id").click();
		getElement("id", "com.thefloow.thefloowltd.floowdrive.app:id/logout").click();
		getElement("id", "com.thefloow.thefloowltd.floowdrive.app:id/fat_button_1").click();
		getElement("id", "com.thefloow.thefloowltd.floowdrive.app:id/branding_logo");
	}
}
