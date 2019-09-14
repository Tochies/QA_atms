package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import util.TestBase;
import util.TestUtils;

public class ForgotPassword extends TestBase {

	@Parameters ({"testEnv"})
	@Test (groups = { "Regression" })
	public void forgotPasswordTest(String testEnv) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		File path = null;
		File classpathRoot = new File(System.getProperty("user.dir"));
		if (testEnv.equalsIgnoreCase("StagingData")) {
			path = new File(classpathRoot, "stagingData/data.conf.json");
		} else {
			path = new File(classpathRoot, "prodData/data.conf.json");
		}
		JSONParser parser = new JSONParser();
		JSONObject config = (JSONObject) parser.parse(new FileReader(path));
		JSONObject envs = (JSONObject) config.get("Forgot_Password");

		String email = (String) envs.get("email");
		Thread.sleep(500);
		getDriver().findElement(By.id("forgot-href")).click();
		Assert.assertEquals(getDriver().getTitle(), "ATMS | Login");
		TestUtils.assertSearchText("CSSSELECTOR", "h4.text-dark", "Forgot Password");

		// Empty email
		String empty = "Click Continue button without supplying email";
		Markup m = MarkupHelper.createLabel(empty, ExtentColor.BLUE);
		testInfo.get().info(m);
		Thread.sleep(500);
		getDriver().findElement(By.id("forgot-password-btn")).click();
		Thread.sleep(500);
		WebElement emailField = getDriver().findElement(By.name("email"));
		String validationMessage = emailField.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage, "Please fill out this field.");
		testInfo.get().info("Empty email field: " + validationMessage);

		// Wrong email format
		String emailFormat = "as@wee";
		String wrong = "Click Continue button with wrong email format "+emailFormat;
		Markup w = MarkupHelper.createLabel(wrong, ExtentColor.BLUE);
		testInfo.get().info(w);
		Thread.sleep(500);
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys(emailFormat);
		getDriver().findElement(By.id("forgot-password-btn")).click();
		Thread.sleep(500);
		WebElement wrongFormat = getDriver().findElement(By.name("email"));
		String validationMessage2 = wrongFormat.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage2, "Please match the requested format.");
		testInfo.get().info("Wrong email format: " + validationMessage2);

		// Non existing user
		String nonExistingUser = "as@wee.wer";
		String wrongUser = "Click Continue button with wrong user "+nonExistingUser;
		Markup n = MarkupHelper.createLabel(wrongUser, ExtentColor.BLUE);
		testInfo.get().info(n);
		Thread.sleep(500);
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys(nonExistingUser);
		getDriver().findElement(By.id("forgot-password-btn")).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong")));
		TestUtils.assertSearchText("CSSSELECTOR", "strong", "No account is associated with this email, "+nonExistingUser);
		
		// Valid user
		String validUser = "Click Continue button with valid user "+email;
		Markup v = MarkupHelper.createLabel(validUser, ExtentColor.BLUE);
		testInfo.get().info(v);
		Thread.sleep(500);
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys(email);
		getDriver().findElement(By.id("forgot-password-btn")).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.text-dark")));
		TestUtils.assertSearchText("CSSSELECTOR", "h4.text-dark", "Verification");
		TestUtils.assertSearchText("CSSSELECTOR", "strong", "ATMS sent a verification code to your Mailbox. Code will expire in 5 minutes.");

		// Empty verification code
		String emptyCode = "Click Continue button without supplying verification code";
		Markup c = MarkupHelper.createLabel(emptyCode, ExtentColor.BLUE);
		testInfo.get().info(c);
		Thread.sleep(500);
		getDriver().findElement(By.id("forgot-password-btn")).click();
		WebElement codeField = getDriver().findElement(By.name("verificationCode"));
		String validationMessage3 = codeField.getAttribute("validationMessage");
		Assert.assertEquals(validationMessage3, "Please fill out this field.");
		testInfo.get().info("Empty verification code field: " + validationMessage3);

		// Wrong verification code
		String wrongCode = "Click Continue button with wrong verification code";
		Markup o = MarkupHelper.createLabel(wrongCode, ExtentColor.BLUE);
		testInfo.get().info(o);
		Thread.sleep(500);
		getDriver().findElement(By.id("verificationCode")).sendKeys("091234");
		getDriver().findElement(By.id("forgot-password-btn")).click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("strong")));
		TestUtils.assertSearchText("CSSSELECTOR", "strong", "Unable to validate provided code. Try again or contact support");

		// Back to login
		String loginPage = "Click Login? button to navigate back to login view page";
		Markup l = MarkupHelper.createLabel(loginPage, ExtentColor.BLUE);
		testInfo.get().info(l);
		Thread.sleep(500);
		getDriver().findElement(By.id("login-href")).click();
		Thread.sleep(1000);
		TestUtils.assertSearchText("ID", "login-btn", "Submit");
		

	}
}
