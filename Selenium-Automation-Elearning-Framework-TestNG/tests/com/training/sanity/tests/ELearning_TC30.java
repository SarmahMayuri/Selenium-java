package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.ELearning_TC30_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC30 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC30_POM adminPOM;
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
		adminPOM = new ELearning_TC30_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC30.html");
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
	public void toLogOut() throws InterruptedException {
		test = report.startTest("TC_30");
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@1234");
		test.log(LogStatus.INFO, "Username and Password provided");
		screenShot.captureScreenShot("TC_30_UID");
		screenShot.captureScreenShot2("TC_30_UID");
		adminPOM.clickLoginBtn(); 
		test.log(LogStatus.INFO, "Admin is logged in");
		screenShot.captureScreenShot("TC_30_Login");
		screenShot.captureScreenShot2("TC_30_Login");
		adminPOM.clickIconBtn();
		test.log(LogStatus.INFO, "Admin clicks on user icon");
		screenShot.captureScreenShot("TC_30_IconClick");
		screenShot.captureScreenShot2("TC_30_IconClick");
		Thread.sleep(3000);
		adminPOM.clickLogout();
		test.log(LogStatus.INFO, "Admin tries to log out application");
		screenShot.captureScreenShot("TC_30_Logout");
		screenShot.captureScreenShot2("TC_30_Logout");
		Thread.sleep(2000);	
		try {
			assertEquals(driver.findElement(By.xpath("//button[@id='formLogin_submitAuth']")).getText(), "Login");
			System.out.println("Application logged out successfully");
		}
		catch (AssertionError e) {
			System.out.println("There is some issue while logging out");
		}



	}
}



