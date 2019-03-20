package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC57_POM {
	private WebDriver driver; 

	public ELearning_TC57_POM(WebDriver driver) {
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

	@FindBy(xpath="//a[contains(text(),'Careers and promotions')]")
	private WebElement carAndPromo; 

	@FindBy(xpath="//img[@title='Careers']")
	private WebElement careerIcon; 

	@FindBy(xpath="//img[@title='Add']")
	private WebElement addIcon; 

	@FindBy(xpath="//input[@id='career_name']")
	private WebElement nameField; 

	@FindBy(xpath="//button[@id='career_submit']")
	private WebElement addCareer; 

	//Item added- assertion

	//--------------------------------------------------------//

	@FindBy(xpath="//a[contains(text(),'Careers and promotions')]")
	private WebElement carPromLink; 

	@FindBy(xpath="//img[@title='Promotions']")
	private WebElement promoIcon; 

	@FindBy(xpath="//img[@title='Add']")
	private WebElement addPromo; 

	@FindBy(xpath="//input[@id='name']")
	private WebElement addNameField; 

	@FindBy(xpath="//button[@id='promotion_submit']")
	private WebElement promoToAdd; 

	//Item added- assertion

	//--------------------------------------------------------//

	@FindBy(xpath="//img[@title='Add a training session']")
	private WebElement addTrainSess; 

	@FindBy(xpath="//input[@name='name']")
	private WebElement sesNameField; 

	@FindBy(xpath="//button[@id='add_session_submit']")
	private WebElement nextClick; 

	@FindBy(xpath="////option[@title='selenium11 (SELENIUM11)']")
	private WebElement selCourse; 

	@FindBy(xpath="//button[@name='add_course']")
	private WebElement clickArrow; 
	
	@FindBy(xpath="//button[@name='next']")
	private WebElement clickNextStep;
	
	@FindBy(xpath="//input[@id='user_to_add']")
	private WebElement portUserField;
	
	@FindBy(xpath="////a[contains(text(),'Sarmah Mayuri (mayuri)')]")
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

	public void clickCareerandPromotions() {
		this.carAndPromo.click(); 
	}

	public void clickCareer() {
		this.careerIcon.click(); 
	}

	public void clickAddIcon() {
		this.addIcon.click();
	}


	public void enterUserName(String text) {
		this.nameField.sendKeys(text);
	}
	
	public void clickAdd2() {
		this.addCareer.click();
	}

//---------------------------------------------//
	
	public void clickCarProm2() {
		this.carPromLink.click(); 
	}

	public void clickPromoIcon() {
		this.promoIcon.click(); 
	}

	public void clickAddIcon2() {
		this.addPromo.click(); 
	}
	
	public void enterpromoName(String text2) {
		this.addNameField.sendKeys(text2);
	}

	public void clickAdd3() {
		this.promoToAdd.click(); 
	}
	
	
//---------------------------------------//	
	
	
	public void clickAddTrainingSession() {
		this.addTrainSess.click(); 
	}

	
	
	public void enterSessionName(String text2) {
		this.sesNameField.sendKeys(text2);
	}

	public void clickNext() {
		this.nextClick.click(); 
	}
	
	
	public void selectCourse() {
		this.selCourse.click(); 
	}
	
	public void clickArrow() {
		this.clickArrow.click(); 
	}
	
	public void clickNext2() {
		this.clickNextStep.click(); 
	}
	
	public void portUserList(String name) {
		this.nameField.sendKeys(name);
	}
	
	public void clickOnName() {

		
		Actions action = new Actions(driver);
		action.moveToElement(selportUser).click().build().perform();

	}
	
	public void clickOnFinish() {
		this.clickFinish.click(); 
	}

	
	

	

}
