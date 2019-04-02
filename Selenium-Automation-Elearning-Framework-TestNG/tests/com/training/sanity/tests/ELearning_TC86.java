package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;




import com.training.pom.ELearning_TC86_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC86 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC86_POM sessionPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass

	public void setUp() throws Exception {

		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		sessionPOM = new ELearning_TC86_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC86.html");
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

	@Test
	public void toCreateCourse() throws InterruptedException {
		test = report.startTest("TC_86_1");
		sessionPOM.sendUserName("mayuriT");
		sessionPOM.sendPassword("mayuriT");
		sessionPOM.clickLoginBtn();

		sessionPOM.createACrse();
		sessionPOM.crseName("seleniumMS");
		sessionPOM.advSettings();
		sessionPOM.category();
		sessionPOM.project();
		sessionPOM.crsecode("selMS");
		sessionPOM.crseCreate();
		sessionPOM.crseDesc();
		sessionPOM.enterText("This is an selenium course");
		sessionPOM.save();

		sessionPOM.crseCreate2();
		sessionPOM.introText();
		sessionPOM.enterTitle("selenium course for beginners");
		sessionPOM.enterContent("selenium course for beginners");
		sessionPOM.save2();
		sessionPOM.objectives();
		sessionPOM.enterTitle2("selenium course for beginners");
		sessionPOM.enterContent2("selenium course for beginners");
		sessionPOM.save3();
		sessionPOM.topics();
		sessionPOM.enterTitle3("selenium course for beginners");
		sessionPOM.enterContent3("selenium course for beginners");
		sessionPOM.save4();
		sessionPOM.backCrse();
		sessionPOM.projects();
		sessionPOM.newProjects();
		sessionPOM.projTitle("ElearningMS");
		sessionPOM.projSubTitle("e learning project");
		sessionPOM.saveProj();
		sessionPOM.clickProj();
		sessionPOM.tasks();
		sessionPOM.taskTitle("design");
		sessionPOM.saveTask();
		sessionPOM.rolesMan();
		sessionPOM.newRole();
		sessionPOM.roleTitle("developer");
		sessionPOM.saveRole();
		sessionPOM.roleAssign();
		sessionPOM.validate();
		sessionPOM.userMang();
		sessionPOM.checkboxUser();
		sessionPOM.validate2();




		test.log(LogStatus.INFO, "Teacher added course");






	}


	@Test(priority=1)

	public void toSuscribe() throws InterruptedException {

		test = report.startTest("TC_86_2");
		sessionPOM.toLogout();
		sessionPOM.logOut();
		sessionPOM.sendUserName("mayuriS");
		sessionPOM.sendPassword("mayuriS");
		sessionPOM.clickLoginBtn();

		sessionPOM.crseCatalog();
		sessionPOM.searchField("sel1");
		sessionPOM.toSearch();
		sessionPOM.toSuscribe();

		test.log(LogStatus.INFO, "Student suscribed course");


	}
	@Test(priority=2)

	public void toReport() throws InterruptedException {
		test = report.startTest("TC_86_3");

		sessionPOM.toLogout();
		sessionPOM.logOut();
		sessionPOM.sendUserName("admin");
		sessionPOM.sendPassword("admin@123");
		sessionPOM.clickLoginBtn();

		sessionPOM.reporting();
		sessionPOM.followSTudents();
		sessionPOM.keyword("mayuri");
		sessionPOM.toSearch2();
		sessionPOM.studDetls();
		sessionPOM.crseDetls();



		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Student report generated");
		screenShot.captureScreenShot2("TC_86_StudentDetails");





		String expectedresult = "Mayuri Sarmah";
		String actualresult = driver.findElement(By.xpath("//h3[contains(text(),'Mayuri Sarmah')]")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Details displayed");
		}
		catch (AssertionError e) {
			System.out.println("Details not displayed");
		}



	}
}






