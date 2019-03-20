package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC59_POM {
	private WebDriver driver; 

	public ELearning_TC59_POM(WebDriver driver) {
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

	@FindBy(xpath="//input[@id='visual_code']")
	private WebElement codeField; 

	@FindBy(xpath="//span[@class='filter-option pull-left'][contains(text(),'none')]")
	private WebElement category; 
	
	@FindBy(xpath="//span[contains(text(),'Projects (PROJ)')]")
	private WebElement selCategory; 

	@FindBy(xpath="//button[@id='update_course_submit']")
	private WebElement clickCreate; 

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

	public void clickCreateACourse() {
		this.createCourse.click(); 
	}

	public void enterTitle(String text) {
		this.titleField.sendKeys(text);
	}
	
	public void enterCode(String text2) {
		this.codeField.sendKeys(text2);
	}
	public void clickCat() {
		this.category.click(); 
	}

	public void selCat() {
		this.selCategory.click();
	}



	public void clickToCreate() {
		this.clickCreate.click(); 
	}

	//---------------------------------------------------//
	public void clickClasses() {
		this.classes.click(); 
	}

	public void clickAddClasses() {
		this.addClasses.click(); 
	}
	
	public void enterName(String text3) {
		this.nameField.sendKeys(text3);
	}
	
	public void enterDesc(String text4) {
		this.descField.sendKeys(text4);
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
