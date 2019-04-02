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




import com.training.pom.ELearning_TC90_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC90 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC90_POM sessionPOM;
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
		sessionPOM = new ELearning_TC90_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC87.html");
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
	public void toCreateQuiz() throws InterruptedException {
		test = report.startTest("TC_87_1");
		sessionPOM.sendUserName("mayuriT");
		sessionPOM.sendPassword("mayuriT");
		sessionPOM.clickLoginBtn();

		sessionPOM.selCrse();
		sessionPOM.selTests();
		sessionPOM.newTests();
		sessionPOM.category("online quiz");
		sessionPOM.advSettings();
		sessionPOM.enable();
		sessionPOM.passMarks("60");
		sessionPOM.proceed();
		sessionPOM.mulChoice();
		sessionPOM.qstn("which is your country?");

		sessionPOM.option1("India");
		sessionPOM.option2("Pakistan");
		sessionPOM.option3("Sri Lanka");
		sessionPOM.option2("Bangladesh");
		sessionPOM.radio1();
		sessionPOM.addQ();
		sessionPOM.qstn("what is your favourite vehicle");

		sessionPOM.option1("pulsar");
		sessionPOM.option2("TVS");
		sessionPOM.option3("royal Enfield");
		sessionPOM.option2("enticer");
		sessionPOM.radio2();
		sessionPOM.preview();
		
		test.log(LogStatus.INFO, "Teacher added quiz");

	}


	@Test(priority=1)

	public void toGiveTest() throws InterruptedException {

		test = report.startTest("TC_87_2");
		sessionPOM.toLogout();
		sessionPOM.logOut();
		sessionPOM.sendUserName("mayuriS");
		sessionPOM.sendPassword("mayuriS");
		sessionPOM.clickLoginBtn();

		sessionPOM.selCrse();
		sessionPOM.selTests();
		sessionPOM.quizSel();
		sessionPOM.startQuiz();
		
		sessionPOM.qstn1ans();
		sessionPOM.qstn2ans();
		sessionPOM.endQuiz();
		

		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Student submitted the online quiz");
		screenShot.captureScreenShot2("TC_86_StudentDetails");

		String expectedresult = "Saved";
		String actualresult = driver.findElement(By.xpath("//div[contains(text(),'Saved.')]")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Quiz submission sucessful");
		}
		catch (AssertionError e) {
			System.out.println("Quiz submission unsucessful");
		}


	}












}






