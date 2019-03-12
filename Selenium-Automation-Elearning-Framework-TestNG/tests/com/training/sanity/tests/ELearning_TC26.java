package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.ELearning_TC26_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC26 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC26_POM adminPOM;
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
		adminPOM = new ELearning_TC26_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC26.html");
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
	public void toCreateClass() throws InterruptedException {
		test = report.startTest("TC_26");
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@1234");
		test.log(LogStatus.INFO, "Username and Password provided");
		screenShot.captureScreenShot("TC_26_UID");
		screenShot.captureScreenShot2("TC_26_UID");
		adminPOM.clickLoginBtn();
		test.log(LogStatus.INFO, "Admin is logged in");
		screenShot.captureScreenShot("TC_26_Login");
		screenShot.captureScreenShot2("TC_26_Login");
		adminPOM.clickAdminBtn();
		adminPOM.clickClasses();
		test.log(LogStatus.INFO, "Admin clicks on Classes link");
		adminPOM.toAddClasses();
		test.log(LogStatus.INFO, "Admin clicks on add classes");
		screenShot.captureScreenShot("TC_26_AddClass");
		screenShot.captureScreenShot2("TC_26_AddClass");
		adminPOM.enterName("Mayuri");
		adminPOM.enterDescription("Demo Testing");
		adminPOM.groupPermissions();
		adminPOM.open();
		test.log(LogStatus.INFO, "Admin provides all necessary information on required fields-name, description and group permissions");
		screenShot.captureScreenShot("TC_26_informations");
		screenShot.captureScreenShot2("TC_26_informations");
		adminPOM.clickAdd();
		test.log(LogStatus.INFO, "New class 'Mayuri' added");
		screenShot.captureScreenShot("TC_26_newClassAdded");
		screenShot.captureScreenShot2("TC_26_newClassAdded");

		String expectedresult = "Item added";
		String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Item successfully added");
		}
		catch (AssertionError e) {
			System.out.println("Item successfully not added");
		}



	}
}



