package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC56_POM {
	private WebDriver driver; 

	public ELearning_TC56_POM(WebDriver driver) {
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

	@FindBy(xpath="//a[contains(text(),'Sessions categories list')]")
	private WebElement sessions; 

	@FindBy(xpath="//img[@title='Training sessions list']")
	private WebElement trainingSession; 

	@FindBy(xpath="//a[contains(@href, 'add_users_to_session.php?page=session_list.php&id_session=17')]")
	private WebElement suscUsers; 

	@FindBy(xpath="//input[@id='user_to_add']")
	private WebElement portalUserField; 
	
	@FindBy(xpath="//a[contains(text(),'Sarmah Mayuri (mayuri)')]")
	private WebElement selUser; 

	@FindBy(xpath="//button[@name='next']")
	private WebElement clickSusc; 

	//--------------------------------------------------------//

	@FindBy(xpath="//a[contains(text(),'Session list')]")
	private WebElement clickSessionList; 

	@FindBy(xpath="//a[@href='add_courses_to_session.php?page=session_list.php&id_session=17']//img[@title='Add courses to this session']")
	private WebElement addCourses; 

	@FindBy(xpath="//option[@title='selenium1 (SELENIUM1)']")
	private WebElement selectCourse; 

	@FindBy(xpath="//button[@name='add_course']")
	private WebElement arrow; 

	@FindBy(xpath="//button[@name='next']")
	private WebElement courseToAdd; 



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

	public void clickSessions() {
		this.sessions.click(); 
	}

	public void toAddClasses() {
		this.trainingSession.click(); 
	}

	public void clickSuscUser() {
		this.suscUsers.click();
	}


	public void enterUserName(String text) {
		this.portalUserField.sendKeys(text);
	}


	public void clickOnName() {

		//this.selUser.click(); 
		Actions action = new Actions(driver);
		action.moveToElement(selUser).click().build().perform();

	}


	public void clickAdd() {
		this.clickSusc.click(); 
	}

	//---------------------------------------------------//
	public void clickSL() {
		this.clickSessionList.click(); 
	}

	public void clickAddCourses() {
		this.addCourses.click(); 
	}

	public void selectAddCourses() {
		this.selectCourse.click(); 
	}

	public void clickArrow() {
		this.arrow.click(); 
	}

	public void addCourse() {
		this.courseToAdd.click(); 
	}

}
