package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC90_POM {
	private WebDriver driver; 

	public ELearning_TC90_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 

	@FindBy(xpath="//a[contains(text(),'sel1')]")
	private WebElement crseLink; 

	@FindBy(xpath="//img[@id='toolimage_1614']")
	private WebElement testsIcon; 

	@FindBy(xpath="//img[@title='Create a new test']")
	private WebElement newTestBtn; 

	@FindBy(xpath="//input[@name='exerciseTitle']")
	private WebElement testNameField; 

	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement advSet; 

	@FindBy(xpath="//label[contains(text(),'Enable start time')]")
	private WebElement enableStart; 

	@FindBy(xpath="//input[@id='pass_percentage']")
	private WebElement passPerField;

	@FindBy(xpath="//button[@id='exercise_admin_submitExercise']")
	private WebElement proceedBtn;

	@FindBy(xpath="//img[@title='Multiple choice']")
	private WebElement mulChoice; 

	@FindBy(xpath="//input[@name='questionName']")
	private WebElement qstnField; 
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[1]']")
	private WebElement opt1Field; 	

	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[2]']")
	private WebElement opt2Field; 
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[3]']")
	private WebElement opt3Field;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, answer[4]']")
	private WebElement opt4Field;
	
	@FindBy(xpath="//input[@id='qf_cc0d7a']")
	private WebElement radioBtn;
	
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement addQstn;
	
	@FindBy(xpath="//tr[2]//td[2]//input[1]")
	private WebElement radioBtn2;
	
	@FindBy(xpath="//img[@title='Preview']")
	private WebElement preview;
	
	
	//--------------------------------------------------------//

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement toLogOut; 

	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logout; 

	
	
	@FindBy(xpath="//a[contains(text(),'online quiz')]")
	private WebElement quizSel; 
	

	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement start;
	
	@FindBy(xpath="//input[@id='choice-16-1']")
	private WebElement opt1;
	
	//radio btn selections

	@FindBy(xpath="//input[@id='choice-16-2']")
	private WebElement opt2;

	@FindBy(xpath="//button[@name='save_now']")
	private WebElement end;


//----------------------------------------------------------------------------
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

	public void selCrse() {
		this.crseLink.click(); 
	}

	
	public void selTests() {
		this.testsIcon.click();
	}

	public void newTests() {
		this.newTestBtn.click();
	}

	public void category(String text) {
		this.testNameField.sendKeys(text);
	}

	public void advSettings() {
		this.advSet.click();
	}

	public void enable() {
		this.enableStart.click();
	}

	public void passMarks(String text1) {
		this.passPerField.sendKeys(text1); 
	}


	
	public void proceed() {
		this.proceedBtn.click();
	}
	
	public void mulChoice() {
		this.mulChoice.click();
	}

	public void qstn(String text2) {
		this.qstnField.sendKeys(text2);
	}
	
	public void option1(String text3) {
		this.opt1Field.sendKeys(text3); 
	}


	
	public void option2(String text4) {
		this.opt2Field.sendKeys(text4); 
	}
	
	public void option3(String text5) {
		this.opt3Field.sendKeys(text5); 
	}
	
	public void option4(String text6) {
		this.opt4Field.sendKeys(text6); 
	}
	
	public void radio1() {
		this.radioBtn.click();
	}

	public void addQ() {
		this.addQstn.click();
	}
	
	public void radio2() {
		this.radioBtn2.click();
	}
	
	
	public void preview() {
		this.preview.click();
	}

	
	
//--------------------------------------------------------------
	public void toLogout() {
		this.toLogOut.click(); 
	}

	public void logOut() {
		this.logout.click(); 
	}
	
	
	public void quizSel() {
		this.quizSel.click(); 
	}

	public void startQuiz(){
		this.start.click(); 
	}
	
	public void qstn1ans() {
		this.opt1.click(); 
	}
	
	public void qstn2ans(){
		this.opt2.click(); 
	}
	
	public void endQuiz() {
		this.end.click(); 
	}
	

	
}