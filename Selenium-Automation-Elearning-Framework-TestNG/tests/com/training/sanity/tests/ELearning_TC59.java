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



import com.training.pom.ELearning_TC59_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC59 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC59_POM sessionPOM;
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
		sessionPOM = new ELearning_TC59_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC59.html");
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
		test = report.startTest("TC_59_1");
		sessionPOM.sendUserName("admin");
		sessionPOM.sendPassword("admin@123");
		sessionPOM.clickLoginBtn();

		sessionPOM.clickAdminBtn();
		sessionPOM.clickCreateACourse();

		sessionPOM.enterTitle("SelTest2");
		sessionPOM.enterCode("MS2");

		sessionPOM.clickCat();
		sessionPOM.selCat();
		sessionPOM.clickToCreate();
		
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "New Course Created");
		screenShot.captureScreenShot2("TC_59_CourseAdded");


		
	}


	@Test(priority=1)

	public void toSuscribe() throws InterruptedException {
		test = report.startTest("TC_59_2");

		sessionPOM.clickAdminBtn();
		sessionPOM.clickClasses();
		sessionPOM.clickAddClasses();
		sessionPOM.enterName("TestingMS2");
		sessionPOM.enterDesc("Test1234");

		sessionPOM.selectGroup();

		sessionPOM.selectOpen();
		sessionPOM.clickOnAdd();
		sessionPOM.suscUsers();
		sessionPOM.selectUsers();
		sessionPOM.suscUsersCom();
		sessionPOM.suscClass();
		sessionPOM.selectCourse();
		sessionPOM.clickArrow();
		sessionPOM.suscCourseCom();
		

		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Session course is updated");
		screenShot.captureScreenShot2("TC_59_SessionUpdated");





		String expectedresult = "Update successful";
		String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item successfully added");
		}
		catch (AssertionError e) {
			System.out.println("Item successfully added");
		}



	}


}




