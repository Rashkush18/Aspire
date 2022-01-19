package Tests;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.InventoryObjects;
import PageObjects.LoginObjects;
import PageObjects.ManufactoringObjects;
import TestBase.TestBase;

public class TestClass extends TestBase {
	long currentTimestamp = Instant.now().toEpochMilli();
	String ProductName = "Product_"+currentTimestamp;
	
	@Test(priority=0)
	@Parameters({"username","password"})
	public void Login(String username,  String password) throws InterruptedException {
		LoginObjects login = new LoginObjects(driver);
		login.Login(username, password);
		Thread.sleep(3000);
		
	}
	@Test(priority=1)
	public void CreateProductsInInventory() throws Exception {
		InventoryObjects inventory = new InventoryObjects(driver);
		inventory.selectProduct();
		inventory.createProduct(ProductName, "1000", "500", "All / Saleable");
		inventory.updateQuantity("15");
	}
	
	@Test(priority=2)
	public void NavigateToManufacturing() throws Exception {
		ManufactoringObjects manufactor = new ManufactoringObjects(driver);
		manufactor.navigatToManufactoring();
	}
	
	@Test(priority=3)
	public void CreateManufacturing() throws Exception {
		ManufactoringObjects manufactor = new ManufactoringObjects(driver);
		manufactor.CreateManufactoring(ProductName, "20", "20");
		manufactor.validateDetails();
	}

}
