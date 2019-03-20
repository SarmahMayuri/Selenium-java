package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC58_POM {
	private WebDriver driver; 

	public ELearning_TC58_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 

	@FindBy(xpath="//a[@title='Administration']")
	private WebElement adminBtn; 

	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createCourse; 

	@FindBy(xpath="//input[@id='update_course_title']")
	private WebElement titleField; 
	//SelTest

	@FindBy(xpath="//input[@id='visual_code']")
	private WebElement codeField; 
	//MS

	@FindBy(xpath="//button[@id='update_course_submit']")
	private WebElement addCourse; 

	//--------------------------------------------------------//

	@FindBy(xpath="//a[contains(text(),'Add a training session')]")
	private WebElement addTrainingSes; 

	@FindBy(xpath="//input[@name='name']")
	private WebElement addSesField; 
	// Test Session2

	@FindBy(xpath="//button[@id='add_session_submit']")
	private WebElement clickNext; 

	@FindBy(xpath="//option[@title='SelTest (MS)']")
	private WebElement selCourse2; 

	@FindBy(xpath="//button[@name='add_course']")
	private WebElement arrow; 

	@FindBy(xpath="//button[@name='next']")
	private WebElement clickNext2; 

	@FindBy(xpath="//input[@id='user_to_add']")
	private WebElement portUserField;

	@FindBy(xpath="//a[contains(text(),'Sarmah Mayuri (mayuri)')]")
	private WebElement selportUser;


	@FindBy(xpath="//button[@name='next']")
	private WebElement clickFinish;


	//--------------------------------------------------------//
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

	public void toCreateCourse() {
		this.createCourse.click(); 
	}


	public void enterTitle(String text) {
		this.titleField.sendKeys(text);
	}
	
	public void enterCode(String text2) {
		this.codeField.sendKeys(text2);
	}

	public void clickAdd() {
		this.addCourse.click();
	}

	//---------------------------------------------//

	public void toAddTraining() {
		this.addTrainingSes.click(); 
	}

	public void entersessionName(String text3) {
		this.addSesField.sendKeys(text3);
	}
	public void clickNext() {
		this.clickNext.click(); 
	}

	public void selCourse() {
		this.selCourse2.click(); 
	}
	
	public void clickArrow() {
		this.arrow.click(); 
	}
	
	public void clickNext2() {
		this.clickNext2.click(); 
	}

	

	public void portUserList(String name) {
		this.portUserField.sendKeys(name);
	}
	
	public void clickOnName() {

		
		Actions action = new Actions(driver);
		action.moveToElement(selportUser).click().build().perform();

	}
	
	public void clickOnFinish() {
		this.clickFinish.click(); 
	}


	




}
