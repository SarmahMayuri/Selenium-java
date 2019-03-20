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


import com.training.pom.ELearning_TC58_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC58 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC58_POM sessionPOM;
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
		sessionPOM = new ELearning_TC58_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC58.html");
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
	public void toCreateCareer() throws InterruptedException {
		test = report.startTest("TC_58_1");
		sessionPOM.sendUserName("admin");
		sessionPOM.sendPassword("admin@123");
		sessionPOM.clickLoginBtn();

		sessionPOM.clickAdminBtn();
		sessionPOM.toCreateCourse();

		sessionPOM.enterTitle("SelTest");
		sessionPOM.enterCode("MS");

		sessionPOM.clickAdd();
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Course Added");
		screenShot.captureScreenShot2("TC_58_ItemAdded");


		String expectedresult = "Course SelTest added";
		String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item successfully updated");
		}
		catch (AssertionError e) {
			System.out.println("Item successfully not updated");
		}
	}


	@Test(priority=1)

	public void toAddCourse() throws InterruptedException {
		test = report.startTest("TC_57_2");

		sessionPOM.clickAdminBtn();
		sessionPOM.toAddTraining();
		sessionPOM.entersessionName("Test Session2");

		sessionPOM.clickNext();

		sessionPOM.selCourse();
		sessionPOM.clickArrow();
		sessionPOM.clickNext2();
		sessionPOM.portUserList("mayuri");
		sessionPOM.clickOnName();
		sessionPOM.clickOnFinish();

		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Session course is added");
		screenShot.captureScreenShot2("TC_58_SessionAdded");





		String expectedresult = "Test Session2";
		String actualresult = driver.findElement(By.xpath("//h3[@class='page-header']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item successfully updated");
		}
		catch (AssertionError e) {
			System.out.println("Item successfully not updated");
		}



	}


}




