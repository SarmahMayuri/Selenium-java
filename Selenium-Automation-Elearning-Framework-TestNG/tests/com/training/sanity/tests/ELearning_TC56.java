package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;

import com.training.pom.ELearning_TC56_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC56 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC56_POM sessionPOM;
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
		sessionPOM = new ELearning_TC56_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC56.html");
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
	public void toSusccribeUser() throws InterruptedException {
		test = report.startTest("TC_56_1");
		sessionPOM.sendUserName("admin");
		sessionPOM.sendPassword("admin@123");
		sessionPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Admin is logged in");

		sessionPOM.clickAdminBtn();
		sessionPOM.clickSessions();
		test.log(LogStatus.INFO, "Admin lands on SessionCategories List");
		sessionPOM.toAddClasses();
		sessionPOM.clickSuscUser();
		test.log(LogStatus.INFO, "Admin lands on Subscribe users to this session");
		screenShot.captureScreenShot2("TC_56_SuscUserScreen");
		sessionPOM.enterUserName("mayuri");
		sessionPOM.clickOnName();
		sessionPOM.clickAdd();
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "User is Subscribed");
		screenShot.captureScreenShot2("TC_56_SuscUserDone");
	}

	
	@Test(priority=1)
	public void toAddCourse() throws InterruptedException {
		test = report.startTest("TC_56_2");
		sessionPOM.clickSL();
		sessionPOM.clickAddCourses();
		test.log(LogStatus.INFO, "Admin to add courses to the session");
		sessionPOM.selectAddCourses();
		test.log(LogStatus.INFO, "Admin selects the course to add");

		sessionPOM.clickArrow();
		sessionPOM.addCourse();
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Selected course is added");
		screenShot.captureScreenShot2("TC_56_CourseAdded");

		Thread.sleep(2000);
		screenShot.captureScreenShot2("TC_56_Sessionupdated");



		String expectedresult = "Update successful";
		String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item successfully updated");
		}
		catch (AssertionError e) {
			System.out.println("Item successfully not updated");
		}



	}

	 
}




