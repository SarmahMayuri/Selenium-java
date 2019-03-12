package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.ELearning_TC29_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC29 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC29_POM adminPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminPOM = new ELearning_TC29_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC29.html");
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	@Test
	public void toDeleteClass() throws InterruptedException {
		test = report.startTest("TC_29");
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@1234");
		test.log(LogStatus.INFO, "Username and Password provided");
		screenShot.captureScreenShot("TC_29_UID");
		screenShot.captureScreenShot2("TC_29_UID");
		adminPOM.clickLoginBtn(); 
		test.log(LogStatus.INFO, "Admin is logged in");
		screenShot.captureScreenShot("TC_29_Login");
		screenShot.captureScreenShot2("TC_29_Login");
		adminPOM.clickAdminBtn();
		adminPOM.clickClasses();
		test.log(LogStatus.INFO, "Admin clicks on Classes link");
		adminPOM.toRemClasses();
		test.log(LogStatus.INFO, "Admin clicks on delete icon for the class to be removed");
		screenShot.captureScreenShot("TC_29_deleteAlertMessage");
		screenShot.captureScreenShot2("TC_29_deleteAlertMessage");
		Alert alert = driver.switchTo().alert();
		String actualresult = alert.getText();
		String expectedresult = "Please confirm your choice";
		alert.accept();
		test.log(LogStatus.INFO, "Selected class deleted");
		screenShot.captureScreenShot("TC_29_classDeleted");
		screenShot.captureScreenShot2("TC_29_classDeleted");

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item deleted successfully");
		}
		catch (AssertionError e) {
			System.out.println("Item not deleted successfully");
		}



	}
}



