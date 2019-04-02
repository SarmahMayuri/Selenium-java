package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ELearning_TC86_POM {
	private WebDriver driver; 

	public ELearning_TC86_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login")
	private WebElement userName; 

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 

	@FindBy(xpath="//a[contains(text(),'Create a course')]")
	private WebElement createCrse; 

	@FindBy(xpath="//input[@id='title']")
	private WebElement crseField; 

	@FindBy(xpath="//button[@id='advanced_params']")
	private WebElement advSetBtn; 

	@FindBy(xpath="//span[@class='filter-option pull-left'][contains(text(),'none')]")
	private WebElement catBtn; 

	@FindBy(xpath="//span[contains(text(),'Projects (PROJ)')]")
	private WebElement selProj; 

	@FindBy(xpath="//input[@id='add_course_wanted_code']")
	private WebElement crsecodeField; 

	@FindBy(xpath="//button[@id='add_course_submit']")
	private WebElement createCrseBtn;

	@FindBy(xpath="//div[@class='help-course']//a[@title='Add an introduction text']")
	private WebElement introText;

	@FindBy(xpath="//iframe[@title='Rich Text Editor, intro_content']")
	private WebElement textField; 

	@FindBy(xpath="//button[@id='introduction_text_intro_cmdUpdate']")
	private WebElement saveBtn; 
	
	@FindBy(xpath="//img[@id='toolimage_1609']")
	private WebElement crseDescBtn; 	

	@FindBy(xpath="//img[@title='Description']")
	private WebElement descIcon; 
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement titleField;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement contentField;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement save2Btn;
	
	@FindBy(xpath="//img[@title='Objectives']")
	private WebElement objIcon;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement title2Field;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement content2Field;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement save3Btn;
	
	@FindBy(xpath="//img[@title='Topics']")
	private WebElement topicIcon;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement title3Field;
	
	@FindBy(xpath="//iframe[@title='Rich Text Editor, contentDescription']")
	private WebElement content3Field;
	
	@FindBy(xpath="//button[@id='course_description_submit']")
	private WebElement save4Btn;
	
	@FindBy(xpath="//a[contains(text(),'seleniumMS')]")
	private WebElement backToCrse;  //course name in xpath
	
	@FindBy(xpath="//img[@id='toolimage_1629']")
	private WebElement projBtn;
	
	@FindBy(xpath="//img[@title='Create a new project']")
	private WebElement newProj;
	
	@FindBy(xpath="//input[@id='add_blog_blog_name']")
	private WebElement projTitleField;
	
	@FindBy(xpath="//textarea[@id='add_blog_blog_subtitle']")
	private WebElement projSubtitleField;
	
	@FindBy(xpath="//button[@id='add_blog_submit']")
	private WebElement saveProj;

	@FindBy(xpath="//a[contains(text(),'ElearningMS')]")
	private WebElement clickProj; //project name to be given in Xpath
	
	@FindBy(xpath="//img[@title='New task']")
	private WebElement newTask;
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement taskTitleField;
	
	@FindBy(xpath="//button[@id='add_post_save']")
	private WebElement saveTask;
	
	@FindBy(xpath="//img[@title='Roles management']")
	private WebElement rolesMang;
	
	@FindBy(xpath="//a[contains(text(),'Add a new role')]")
	private WebElement addNewRole;
	
	@FindBy(xpath="//input[@name='task_name']")
	private WebElement roleTitleField;
	
	@FindBy(xpath="//button[@name='Submit']")
	private WebElement saveRole;
	
	@FindBy(xpath="//a[contains(text(),'Assign roles')]")
	private WebElement assignRole;
	
	@FindBy(xpath="//button[@id='assign_task_submit']")
	private WebElement valBtn;
	
	@FindBy(xpath="//img[@title='Users management']")
	private WebElement userMang;
	
	@FindBy(xpath="//td[contains(text(),'Mayuri')]//preceding-sibling::td//input[@type='checkbox']")
	private WebElement userCheck;
	
	@FindBy(xpath="//button[contains(text(), 'Validate')]")
	private WebElement valBtn2;

	//--------------------------------------------------------//

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement toLogOut; 

	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logout; 

	@FindBy(xpath="//a[@class='btn btn-primary btn-large']")
	private WebElement crseCat; 

	@FindBy(xpath="//input[@name='search_term']")
	private WebElement searchField; 

	@FindBy(xpath="//button[@type='submit']")
	private WebElement search;

	@FindBy(xpath="//a[@title='Subscribe']")
	private WebElement suscribeBtn;

//-----------------------------------------------------------------------------
	@FindBy(xpath="//a[@title='Reporting']")
	private WebElement reporting;

	@FindBy(xpath="//a[contains(text(),'Followed students')]")
	private WebElement followStud;

	@FindBy(xpath="//input[@id='search_user_keyword']")
	private WebElement keywordField;  //mayuri
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement search2;
	
	@FindBy(xpath="//img[@title='Details mayuri']")
	private WebElement detailsIcon;
	
	@FindBy(xpath="//img[@title='Details']")
	private WebElement detailsCrse;

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

	public void createACrse() {
		this.createCrse.click(); 
	}

	
	public void crseName(String text) {
		this.crseField.sendKeys(text);
	}

	public void advSettings() {
		this.advSetBtn.click();
	}

	public void category() {
		this.catBtn.click();
	}

	public void project() {
		this.selProj.click();
	}

	public void crsecode(String text2) {
		this.crsecodeField.sendKeys(text2);
	}

	public void crseCreate() {
		this.createCrseBtn.click(); 
	}


	
	public void crseDesc() {
		this.crseDescBtn.click();
	}
	
	public void enterText(String text3) {
		this.textField.sendKeys(text3);
	}

	public void save() {
		this.saveBtn.click();
	}
	
	public void crseCreate2() {
		this.createCrseBtn.click(); 
	}


	
	public void introText() {
		this.descIcon.click();
	}
	
	public void enterTitle(String text4) {
		this.titleField.sendKeys(text4);
	}
	
	public void enterContent(String text5) {
		this.contentField.sendKeys(text5);
	}
	
	public void save2() {
		this.save2Btn.click();
	}

	public void objectives() {
		this.objIcon.click();
	}
	
	public void enterTitle2(String text6) {
		this.title2Field.sendKeys(text6);
	}
	
	public void enterContent2(String text7) {
		this.content2Field.sendKeys(text7);
	}
	
	public void save3() {
		this.save3Btn.click();
	}

	public void topics() {
		this.topicIcon.click();
	}
	
	public void enterTitle3(String text8) {
		this.title3Field.sendKeys(text8);
	}
	
	public void enterContent3(String text9) {
		this.content3Field.sendKeys(text9);
	}
	
	public void save4() {
		this.save4Btn.click();
	}
	
	public void backCrse() {
		this.backToCrse.click();  //Crse name to give in Xpath
	}
	
	public void projects() {
		this.projBtn.click();
	}

	
	public void newProjects() {
		this.newProj.click();
	}
	
	public void projTitle(String text10) {
		this.projTitleField.sendKeys(text10);
	}
	
	public void projSubTitle(String text11) {
		this.projSubtitleField.sendKeys(text11);
	}
	
	public void saveProj() {
		this.saveProj.click();
	}

	public void clickProj() {
		this.clickProj.click();  //proj name to give in Xpath
	}
	
	public void tasks() {
		this.newTask.click();
	}
	
	public void taskTitle(String text12) {
		this.taskTitleField.sendKeys(text12);
	}
	
	public void saveTask() {
		this.saveTask.click();
	}

	public void rolesMan() {
		this.rolesMang.click();  
	}
	
	public void newRole() {
		this.addNewRole.click();
	}
	
	public void roleTitle(String text13) {
		this.roleTitleField.sendKeys(text13);
	}
	
	public void saveRole() {
		this.saveRole.click();
	}
	
	public void roleAssign() {
		this.assignRole.click();  
	}
	
	public void validate() {
		this.valBtn.click();
	}
	
	public void userMang() {
		this.userMang.click();  
	}
	
	public void checkboxUser() {
		this.userCheck.click();
	}
	
	public void validate2() {
		this.valBtn2.click();
	}
	
//--------------------------------------------------------------
	public void toLogout() {
		this.toLogOut.click(); 
	}

	public void logOut() {
		this.logout.click(); 
	}
	
	public void crseCatalog() {
		this.crseCat.click(); 
	}

	public void searchField(String text14) {
		this.searchField.sendKeys(text14); 
	}
	
	public void toSearch() {
		this.search.click(); 
	}
	
	public void toSuscribe() {
		this.suscribeBtn.click(); 
	}
	
//-------------------------------------------------
	
	public void reporting() {
		this.reporting.click(); 
	}
	
	public void followSTudents() {
		this.followStud.click(); 
	}

	public void keyword(String text15) {
		this.keywordField.sendKeys(text15); 
	}
	
	public void toSearch2() {
		this.search2.click(); 
	}
	
	public void studDetls() {
		this.detailsIcon.click(); 
	}
	
	public void crseDetls() {
		this.detailsCrse.click(); 
	}



}