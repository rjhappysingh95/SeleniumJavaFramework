package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;


public class CommonFunctionPage {
	
	WebDriver driver;

	public CommonFunctionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ReloadUrl(String url) throws InterruptedException {
		Thread.sleep(5000);
		driver.get(url);
		Thread.sleep(5000);
	}
	
	public static void Verifytext(String expected,String actual) throws InterruptedException {
		Thread.sleep(2000);
		//assertEquals(actual, expected);
		assertTrue(expected.contains(actual));
	}
}
