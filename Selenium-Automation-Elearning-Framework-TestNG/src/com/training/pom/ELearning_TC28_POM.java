package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC28_POM {
	private WebDriver driver; 

	public ELearning_TC28_POM(WebDriver driver) {
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

	@FindBy(xpath="//a[@href='add_courses_to_usergroup.php?id=162']//img[@title='Subscribe class to courses']")
	private WebElement suscClassCrse; 
	
	@FindBy(xpath="//option[@value='56']")
	private WebElement choice1; 
	
	@FindBy(xpath="//option[@value='135']")
	private WebElement choice2; 
	
	@FindBy(xpath="//td[@valign='middle']//button[1]")
	private WebElement arrow; 
	
	@FindBy(xpath="//button[contains(text(),'Subscribe class to courses')]")
	private WebElement suscribeBtn; 



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

	public void suscClsToCrse() {
		this.suscClassCrse.click(); 
	}
	
	public void selectChoice1() {
		this.choice1.click(); 
	}
	
	public void selectChoice2() {
		this.choice2.click(); 
	}
	
	public void clickArrow() {
		this.arrow.click(); 
	}
	
	public void suscribeClasses() {
		this.suscribeBtn.click(); 
	}

	

}
