package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbutton = By.id("login-button");
	By loginerrortext = By.xpath("//h3[@data-test='error']");
	
	public void sendUsername(String usr) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(usr);
	}
	
	public void sendPassword(String pass) {		
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	
	public void ClickLoginButton() {
		driver.findElement(loginbutton).click();
	}
	
	public void VerifyLoginErrorMessage(String msg) throws InterruptedException {
		String text = driver.findElement(loginerrortext).getText();
		CommonFunctionPage.Verifytext(text,msg);
	}
}
