package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC60_POM {
	private WebDriver driver; 

	public ELearning_TC60_POM(WebDriver driver) {
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

	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement addUser; 

	@FindBy(xpath="//input[@id='firstname']")
	private WebElement fnameField; 

	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lnameField; 

	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField; 

	@FindBy(xpath="//input[@id='phone']")
	private WebElement phField; 

	@FindBy(xpath="//input[@id='username']")
	private WebElement loginField;

	@FindBy(xpath="//label[contains(text(),'Enter password')]")
	private WebElement selPwd;

	@FindBy(xpath="//input[@id='password']")
	private WebElement pwdField; 

	@FindBy(xpath="//button[@name='submit']")
	private WebElement addBtn; 

	//--------------------------------------------------------//

	@FindBy(xpath="//a[contains(text(),'Classes')]")
	private WebElement classes; 

	@FindBy(xpath="//img[@title='Add classes']")
	private WebElement addClasses; 

	@FindBy(xpath="//input[@id='usergroup_name']")
	private WebElement nameField; 

	@FindBy(xpath="//textarea[@id='usergroup_description']")
	private WebElement descField; 

	@FindBy(xpath="//span[@class='filter-option pull-left']")
	private WebElement groupPerm;

	@FindBy(xpath="//span[contains(text(),'Open')]")
	private WebElement clickOpen;

	@FindBy(xpath="//button[@id='usergroup_submit']")
	private WebElement clickAdd;

	@FindBy(xpath="//img[@title='Subscribe users to class']")
	private WebElement suscUsersToClass;

	@FindBy(xpath="//option[contains(text(), 'Mayuri Sarmah (mayuri) ')]")
	private WebElement selUser;

	@FindBy(xpath="//button[contains(text(),'Subscribe users to class')]")
	private WebElement suscUser;

	@FindBy(xpath="//img[@title='Subscribe class to courses']")
	private WebElement suscClassToCourses;

	@FindBy(xpath="//option[contains(text(), 'SelTest (MS)')]")
	private WebElement selCourse;

	@FindBy(xpath="//button[contains(@class, 'btn btn-default')]//parent::td//button[1]")
	private WebElement arrow;

	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement suscCourse;


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

	public void clickAddUser() {
		this.addUser.click(); 
	}

	public void enterFName(String text) {
		this.fnameField.sendKeys(text);
	}

	public void enterLName(String text2) {
		this.lnameField.sendKeys(text2);
	}

	public void enterMailID(String text3) {
		this.emailField.sendKeys(text3);
	}

	public void enterPhNum(String text4) {
		this.phField.sendKeys(text4);
	}

	public void enterLogin(String text5) {
		this.loginField.sendKeys(text5);
	}

	public void selRadioPwd() {
		this.selPwd.click(); 
	}


	public void enterPwd(String text6) {
		this.pwdField.sendKeys(text6);
	}


	public void clickAdd() {
		this.addBtn.click();
	}



	//---------------------------------------------------//
	public void clickClasses() {
		this.classes.click(); 
	}

	public void clickAddClasses() {
		this.addClasses.click(); 
	}

	public void enterName(String text7) {
		this.nameField.sendKeys(text7);
	}

	public void enterDesc(String text8) {
		this.descField.sendKeys(text8);
	}

	public void selectGroup() {
		this.groupPerm.click(); 
	}

	public void selectOpen() {
		this.clickOpen.click(); 
	}

	public void clickOnAdd() {
		this.clickAdd.click(); 
	}

	public void suscUsers() {
		this.suscUsersToClass.click(); 
	}


	public void selectUsers() {
		this.selUser.click(); 
	}

	public void suscUsersCom() {
		this.suscUser.click(); 
	}

	public void suscClass() {
		this.suscClassToCourses.click(); 
	}

	public void selectCourse() {
		this.selCourse.click(); 
	}

	public void clickArrow() {
		this.arrow.click(); 
	}

	public void suscCourseCom() {
		this.suscCourse.click(); 
	}

}
