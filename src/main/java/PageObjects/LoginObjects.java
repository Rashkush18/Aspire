package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjects {
	@FindBy(xpath="//input[@id='login']")
	WebElement email_Textbox;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password_Textbox;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement login_Button;
	
	WebDriver driver;
	public LoginObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String Username, String Password) {
		email_Textbox.sendKeys(Username);
		password_Textbox.sendKeys(Password);
		login_Button.click();
	}
	

}
