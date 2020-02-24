package testScripts;

import org.testng.annotations.Test;

import appPages.Registration;
import util.BaseTest;

public class newMemberRegistration extends BaseTest{
	
	
	Registration registration; 
	
	@Test(priority = 1)
	public void registerNewUser( ) throws Exception {
		registration = new Registration(driver, properties);
		registration.submitFormForNewUser("Alexander@gmail.com", "Test1234", "John", "Snow", "01 January 2002", "625009");
		registration.skipSteps();
		registration.setPermission();
		registration.configureSettings();
		registration.verifyHomePage();
	}
	
	
	@Test(priority=2)
	public void logoutRegisteredUser() throws Exception {
		registration.logout();
	}

}
