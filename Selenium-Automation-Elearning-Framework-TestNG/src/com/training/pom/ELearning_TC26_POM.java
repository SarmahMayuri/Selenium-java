package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC26_POM {
	private WebDriver driver; 

	public ELearning_TC26_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="formLogin_submitAuth")
	private WebElement loginBtn; 

	@FindBy(xpath="//a[@title='Administration']")
	private WebElement adminBtn; 

	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement classes; 

	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement addClasses; 

	@FindBy(xpath="//input[@name='name']")
	private WebElement nameField; 

	@FindBy(xpath="//textarea[@id='usergroup_description']")
	private WebElement descriptionField; 

	@FindBy(xpath="//span[@class='filter-option pull-left']")
	private WebElement groupField; 
	
	@FindBy(xpath="//div[@class='dropdown-menu open']/ul/li/a")
	private WebElement openField; 
	
	@FindBy(xpath="//button[@id='usergroup_submit']")
	private WebElement addBtn; 



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

	public void clickAdminBtn() {
		this.adminBtn.click(); 
	}

	public void clickClasses() {
		this.classes.click(); 
	}

	public void toAddClasses() {
		this.addClasses.click(); 
	}

	public void enterName(String name) {
		this.nameField.sendKeys(name);
	}

	public void enterDescription(String text) {
		this.descriptionField.sendKeys(text);
	}

	public void groupPermissions() {
		this.groupField.click(); 
	}
	
	public void open() {
		this.openField.click(); 
	}

	/*public void enterGroup() {

		Select option= new Select(groupField);
		option.selectByVisibleText("Open");
		
	}
	*/
	
	public void clickAdd() {
		this.addBtn.click(); 
	}

}
