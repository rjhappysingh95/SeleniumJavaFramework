package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver = null;
	private static String url = "https://www.saucedemo.com/";

	@BeforeSuite
	public void init() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	
	public void testcasesetup(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		  driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);	
		driver.manage().window().maximize();
        driver.get(url);		
	}
	
	
	@AfterMethod
	public void closetest() {
		driver.quit();
	}
	
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		System.out.println("Our Test Run complete");
	}
	
	public static WebDriver fetchDriver() {
		return driver;
	}

}
