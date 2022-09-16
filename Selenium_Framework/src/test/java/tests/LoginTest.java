package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CommonFunctionPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	WebDriver driver;
	LoginPage loginpage;
	CommonFunctionPage commonfunction;
	
	
	public void testcaseinitialize() {	
	driver=BaseTest.fetchDriver();
	loginpage =  new LoginPage(this.driver);
	commonfunction = new CommonFunctionPage(this.driver);
	
	}
	
	@Parameters({"browsertype"})  
	@Test(priority = 1)
	public void LoginLockUserTest(String browsertype) throws InterruptedException {
		testcasesetup(browsertype);
		testcaseinitialize();
		loginpage.sendUsername("locked_out_user");
		loginpage.sendPassword("secret_sauce");
		loginpage.ClickLoginButton();
		loginpage.VerifyLoginErrorMessage("this user has been locked out");		
	}
	
	
	@Parameters({"browsertype"})  
	@Test(priority = 2)
	public void LoginInvalidUserTest(String browsertype) throws InterruptedException {	
		testcasesetup(browsertype);
		testcaseinitialize();
		loginpage.sendUsername("abc");
		loginpage.sendPassword("ss");
		loginpage.ClickLoginButton();
		loginpage.VerifyLoginErrorMessage("Username and password do not match any user in this service");
	}

}
