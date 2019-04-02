package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC87_POM {
	private WebDriver driver; 

	public ELearning_TC87_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 

	@FindBy(xpath=" //a[contains(text(),'Add a user')]")
	private WebElement addUser; 

	@FindBy(xpath="//input[@id='firstname']")
	private WebElement nameField; 

	@FindBy(xpath="//input[@id='lastname']")
	private WebElement titleField; 

	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField; 

	@FindBy(xpath="//input[@id='phone']")
	private WebElement phoneField; 

	@FindBy(xpath="//input[@id='username']")
	private WebElement uidField; 

	@FindBy(xpath="//label[contains(text(),'Enter password')]")
	private WebElement radioBtn; 

	@FindBy(xpath="//input[@id='password']")
	private WebElement pwdField;

	@FindBy(xpath="//button[@name='submit']")
	private WebElement submit;



	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}

	public void clickAddUser() {
		this.addUser.click(); 
	}


	public void enterName(String name) {
		this.nameField.sendKeys(name);
	}

	public void enterTitle(String text) {
		this.titleField.sendKeys(text);
	}

	public void email(String text2) {
		this.emailField.sendKeys(text2);
	}

	public void phone(String num) {
		this.phoneField.sendKeys(num); 
	}

	public void uid(String text4) {
		this.uidField.sendKeys(text4); 
	}

	public void pwdRadio() {
		this.radioBtn.click(); 
	}

	public void pwd(String text5) {
		this.pwdField.sendKeys(text5); 
	}	



	public void submit() {
		this.submit.click(); 
	}

}
