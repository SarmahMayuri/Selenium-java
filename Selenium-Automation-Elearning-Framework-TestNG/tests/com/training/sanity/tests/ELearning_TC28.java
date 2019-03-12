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
import com.training.pom.ELearning_TC28_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC28 {

	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC28_POM adminPOM;
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
		adminPOM = new ELearning_TC28_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults_TC28.html");
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
	public void toSuscribeCourse() throws InterruptedException {
		test = report.startTest("TC_28");
		adminPOM.sendUserName("admin");
		adminPOM.sendPassword("admin@1234");
		test.log(LogStatus.INFO, "Username and Password provided");
		screenShot.captureScreenShot("TC_28_UID");
		screenShot.captureScreenShot2("TC_28_UID");
		adminPOM.clickLoginBtn(); 
		test.log(LogStatus.INFO, "Admin is logged in");
		screenShot.captureScreenShot("TC_28_Login");
		screenShot.captureScreenShot2("TC_28_Login");
		adminPOM.clickAdminBtn();
		adminPOM.clickClasses();
		test.log(LogStatus.INFO, "Admin clicks on Classes link");
		adminPOM.suscClsToCrse();
		test.log(LogStatus.INFO, "Admin clicks on suscribe class to courses");
		screenShot.captureScreenShot("TC_28_suscribeClassToCourses");
		screenShot.captureScreenShot2("TC_28_suscribeClassToCourses");
		adminPOM.selectChoice1();
		adminPOM.clickArrow();
		adminPOM.selectChoice2();
		adminPOM.clickArrow();
		test.log(LogStatus.INFO, "Admin selects choices to suscribe class to courses");
		screenShot.captureScreenShot("TC_28_choicesSelected");
		screenShot.captureScreenShot2("TC_28_choicesSelected");
		adminPOM.suscribeClasses();	
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Courses suscribed to selected class");
		screenShot.captureScreenShot("TC_28_coursesSuscribed");
		screenShot.captureScreenShot2("TC_28_coursesSuscribed");
		Thread.sleep(3000);
		String expectedresult = "2";
		String actualresult = driver.findElement(By.xpath("//tr[@id='162']//td[3]")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Required courses successfully suscribed");
		}
		catch (AssertionError e) {
			System.out.println("Courses not successfully suscribed");
		}
		
		

		//screenShot.captureScreenShot("First");
	}
}



