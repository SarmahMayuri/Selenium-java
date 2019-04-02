package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.ELearning87DataProvider;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ELearning_TC87_POM;
import com.training.pom.ELearning_TC88_POM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELearning_TC88 {
	private WebDriver driver;
	private String baseUrl;
	private ELearning_TC88_POM addUser;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		addUser = new ELearning_TC88_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = ELearning87DataProvider.class)
	public void loginDBTest(String username, String password, String firstname, String lastname, String email, String phone, String uid, String pwd) throws InterruptedException {
		addUser.sendUserName(username);
		addUser.sendPassword(password);
		addUser.clickLoginBtn();
		addUser.clickAddUser();
		addUser.enterName(firstname);
		addUser.enterTitle(lastname);
		addUser.email(email);
		addUser.phone(phone);
		addUser.uid(uid);
		addUser.pwdRadio();
		addUser.pwd(pwd);
		addUser.submit();
		Thread.sleep(3000);
		
		screenShot.captureScreenShot2("TC_88_error");
		
		String expectedresult = "The email address is not complete or contains some invalid characters";
		String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();

		try {
			assertEquals(actualresult, expectedresult); 
			System.out.println("Data given incorrect");
		}
		catch (AssertionError e) {
			System.out.println("Data correct");
		}
		

	}

}