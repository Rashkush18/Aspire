package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufactoringObjects {
	@FindBy(xpath="//a[@title='Applications']")
	WebElement application;
	
	@FindBy(xpath="//div[text()='Manufacturing']")
	WebElement Manufacturing;
	
	@FindBy(xpath="//label[text()='Product']/following::input[1]")
	WebElement product_name;
	
	@FindBy(xpath="(//input[@name='product_qty'])[1]")
	WebElement product_quantity;
	
	@FindBy(xpath="(//a[text()='Add a line'])[1]")
	WebElement addALine;
	
	@FindBy(xpath="(//div[@name='product_id']/div/input)[2]")
	WebElement Product_addLine;
	
	@FindBy(xpath="//input[@name='product_uom_qty']")
	WebElement Consume_quantity;
	
	@FindBy(xpath="//button[@name='action_confirm']")
	WebElement confirm;
	
	@FindBy(xpath="//span[@placeholder='Manufacturing Reference']")
	WebElement manufacture_number;
	
	@FindBy(xpath="//input[@name='qty_producing']")
	WebElement producing_qty;
	
	@FindBy(xpath="//span[text()='Validate']")
	WebElement validate;
	
	@FindBy(xpath="//span[text()='Mark as Done']")
	WebElement MarkAsDone;
	
	@FindBy(xpath="//li[@class='breadcrumb-item o_back_button']")
	WebElement Back;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement Search;
	
	@FindBy(xpath="//span[text()='Filters']")
	WebElement Filters;
	
	@FindBy(xpath="(//li[@class='o_menu_item'])[1]")
	WebElement uncheckFilter;
	
	@FindBy(xpath="//span[@name='state']")
	WebElement StateValidation;
	
	WebDriver driver;
	public ManufactoringObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigatToManufactoring() throws InterruptedException {
		application.click();
		Thread.sleep(2000);
		Manufacturing.click();
	}
	
	public void CreateManufactoring(String ProductName ,String Quantity, String ConsumeQuantity) throws InterruptedException {
		InventoryObjects.create.click();
		Thread.sleep(2000);
		product_name.sendKeys(ProductName);
		Thread.sleep(1000);
		product_name.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		product_quantity.click();
		product_quantity.clear();
		product_quantity.sendKeys(Quantity);
		Thread.sleep(2000);
		addALine.click();
		Thread.sleep(2000);
		Product_addLine.sendKeys(ProductName);
		Thread.sleep(1000);
		Product_addLine.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Consume_quantity.click();
		Consume_quantity.clear();
		Consume_quantity.sendKeys(ConsumeQuantity);
		Thread.sleep(1000);
		confirm.click();
		Thread.sleep(2000);
		
		producing_qty.click();
		producing_qty.clear();
		producing_qty.sendKeys(ConsumeQuantity);
		Thread.sleep(5000);
		//validate.click();
		String Manufactureno= manufacture_number.getText();
		System.out.println("Manufactureno:"+Manufactureno);
		Thread.sleep(2000);
		MarkAsDone.click();
		Thread.sleep(2000);
		Back.click();
		Thread.sleep(2000);
		Filters.click();
		uncheckFilter.click();
		Thread.sleep(2000);
		Filters.click();
		Thread.sleep(2000);
		Search.sendKeys(Manufactureno);
		Thread.sleep(1000);
		Search.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	public void validateDetails() {
		String state=StateValidation.getText();
		if(state.equalsIgnoreCase("Done")) {
			System.out.println("Manufactoring status is done");
		}else {
			System.out.println("Manufactoring status is not done");
		}
	}
}
