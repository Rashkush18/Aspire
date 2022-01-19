package TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

	public WebDriver driver;
	@BeforeClass
	public void setUp() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver",
			path+ "/Drivers/chromedriver.exe"); 
			driver = new ChromeDriver();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("https://aspireapp.odoo.com");
			  driver.manage().window().maximize();
	}
	
	@AfterClass public void tearDown() { 
		driver.close(); 
		driver.quit();
		System.out.println("Testcase Passed"); 
	}

}
