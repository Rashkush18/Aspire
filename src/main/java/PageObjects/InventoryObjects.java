package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryObjects {
	
	@FindBy(xpath="//div[text()='Inventory']")
	WebElement inventory_Icon;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement products_menu;
	
	@FindBy(xpath="//span[text()='Products']")
	WebElement products;
	
	@FindBy(xpath="//button[@accesskey='c']")
	static WebElement create;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement productName_textbox;
	
	@FindBy(xpath="//label[text()='Sales Price']/following::td[1]/div/div/input")
	WebElement sale_price;
	
	@FindBy(xpath="//label[text()='Cost']/following::td[1]/div/div/input")
	WebElement cost;
	
	@FindBy(xpath="//label[text()='Product Category']/following::input[1]")
	WebElement Product_category;
	
	@FindBy(xpath="//label[text()='Unit of Measure']/following::input[1]")
	WebElement measure_Unit;
	
	@FindBy(xpath="//label[text()='Purchase Unit of Measure']/following::input[1]")
	WebElement purchase_unit;
	
	@FindBy(xpath="//span[text()='Update Quantity']")
	WebElement update_Quantity;
	
	@FindBy(xpath="(//div[@class='o_input_dropdown']/input)[1]")
	WebElement location;
	
	@FindBy(xpath="(//div[@class='o_input_dropdown']/input)[2]")
	WebElement package_drop;
	
	@FindBy(xpath="//input[@name='inventory_quantity']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@accesskey='s']")
	WebElement save;
	
	@FindBy(xpath="//span[text()='Create']")
	WebElement createPackage;

	WebDriver driver;
	public InventoryObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct() throws InterruptedException {
		inventory_Icon.click();
		products_menu.click();
		products.click();
		Thread.sleep(3000);
	}
	
	
	public void createProduct(String name, String SalePrice, String costrate, String ProductCategory) throws InterruptedException {
		create.click();
		productName_textbox.sendKeys(name);
		Thread.sleep(2000);
		sale_price.click();
		Thread.sleep(2000);
		sale_price.sendKeys(Keys.CONTROL + "a");
		sale_price.sendKeys(Keys.DELETE);
		sale_price.sendKeys(SalePrice);
		cost.click();
		Thread.sleep(2000);
		cost.sendKeys(Keys.CONTROL + "a");
		cost.sendKeys(Keys.DELETE);
		cost.sendKeys(costrate);
		Thread.sleep(2000);
		measure_Unit.click();
		driver.findElement(By.xpath("(//li[@class='ui-menu-item']/a[text()=\"L\"])[1]")).click();
		Thread.sleep(2000);
	}
	
	public void updateQuantity(String Quantity) throws Exception {
		update_Quantity.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@accesskey='c']")).click();
		Thread.sleep(2000);
		location.click();
		driver.findElement(By.xpath("//li[@class='ui-menu-item']/a[text()='WH/Stock']")).click();
		package_drop.click();
		Thread.sleep(2000);
		package_drop.sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("(//li[@class='ui-menu-item']/a[1])[1]")).click();
		Thread.sleep(2000);
		quantity.clear();
		quantity.sendKeys(Quantity);
		Thread.sleep(2000);
		save.click();
		Thread.sleep(2000);
	}
	


}
