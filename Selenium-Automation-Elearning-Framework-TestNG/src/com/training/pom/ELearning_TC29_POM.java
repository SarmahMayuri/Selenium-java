package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC29_POM {
	private WebDriver driver; 

	public ELearning_TC29_POM(WebDriver driver) {
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

	@FindBy(xpath="//tr[@id='164']//img[contains(@title,'Delete')]")
	private WebElement remClasses; 

	//If a simple XPath is not able to find a complicated web element for our test script
	//we can create more specific XPath with 3 functions –Contains    Sibling    Ancestor


	//@FindBy(xpath="//td[contains(@title,'class2')]//following-sibling::td//a//img[@title='Delete']")
	//private WebElement remClasses; 


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

	public void toRemClasses() {
				
		//Actions action = new Actions(driver);	
		//action.moveToElement(this.remClasses).perform();
		//action.sendKeys(Keys.PAGE_DOWN).build().perform();
		this.remClasses.click();
		
	}

}
