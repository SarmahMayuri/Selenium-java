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
import com.training.pom.ELearning_TC27_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC27 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC27_POM adminPOM;
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
		adminPOM = new ELearning_TC27_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC27.html");
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
	public void toSuscribeUser() throws InterruptedException {
		test = report.startTest("TC_27");
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@1234");
		test.log(LogStatus.INFO, "Username and Password provided");
		screenShot.captureScreenShot("TC_27_UID");
		screenShot.captureScreenShot2("TC_27_UID");
		adminPOM.clickLoginBtn(); 
		test.log(LogStatus.INFO, "Admin is logged in");
		screenShot.captureScreenShot("TC_27_Login");
		screenShot.captureScreenShot2("TC_27_Login");
		adminPOM.clickAdminBtn();
		adminPOM.clickClasses();
		test.log(LogStatus.INFO, "Admin clicks on Classes link");
		adminPOM.suscUserToClasses();
		test.log(LogStatus.INFO, "Admin clicks on suscribe users to class");
		screenShot.captureScreenShot("TC_27_suscribeUserToClass");
		screenShot.captureScreenShot2("TC_27_suscribeUserToClass");
		adminPOM.selectChoice1();
		adminPOM.clickArrow();
		adminPOM.selectChoice2();
		adminPOM.clickArrow();
		test.log(LogStatus.INFO, "Admin selects choices to suscribe users to class");
		screenShot.captureScreenShot("TC_27_choicesSelected");
		screenShot.captureScreenShot2("TC_27_choicesSelected");
		adminPOM.suscribeUsers();
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Users suscribed to selected class");
		screenShot.captureScreenShot("TC_27_userSuscribed");
		screenShot.captureScreenShot2("TC_27_userSuscribed");
		Thread.sleep(3000);
		String expectedresult = "2";
		String actualresult = driver.findElement(By.xpath("//tr[@id='165']//td[2]")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Required users successfully suscribed");
		}
		catch (AssertionError e) {
			System.out.println("Users not successfully suscribed");
		}



	}
}



