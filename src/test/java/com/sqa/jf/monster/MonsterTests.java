package com.sqa.jf.monster;

import static org.testng.Assert.*;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class MonsterTests {
	private boolean acceptNextAlert = true;
	private String baseUrl;
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://my.monster.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testMonsterTests() throws Exception {
		this.driver.get(this.baseUrl + "/Login/SignOut?fwr=true");
		this.driver.findElement(By.linkText("Sign In")).click();
		this.driver.findElement(By.xpath("(//input[@value='Sign In'])[2]")).click();
		this.driver.findElement(By.id("ctl00__powerSearchControl__ptbKeywords")).clear();
		this.driver.findElement(By.id("ctl00__powerSearchControl__ptbKeywords")).sendKeys("java devloper");
		this.driver.findElement(By.id("ctl00__powerSearchControl__btnSearch")).click();
		this.driver.findElement(By.cssSelector("a[title=\"Sign Out\"]")).click();
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
