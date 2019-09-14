package CACTestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import util.TestBase;
import util.TestUtils;


public class SignIn extends TestBase {
	
	@Test
	public void assertLandingPage() throws InterruptedException{
		String landingPage = "Login Form:";
		Markup c = MarkupHelper.createLabel(landingPage, ExtentColor.ORANGE);
		testInfo.get().info(c);
		Thread.sleep (500);
		TestUtils.elementIsPresent("ID","email", "Email Field");
		TestUtils.elementIsPresent("ID","password", "Password Field");
		TestUtils.elementIsPresent("ID","login-btn", "Submit Button");
		TestUtils.elementIsPresent("ID","forgot-href", "Forgot Password link");
		TestUtils.assertSearchText("XPATH", "//h2", "ATMS");
		TestUtils.assertSearchText("XPATH", "//h4", "Login");

	}
	@Test
	public void invalidEmailAndPassword() throws InterruptedException {
		String landingPage = "Invalid Login:";
		Markup c = MarkupHelper.createLabel(landingPage, ExtentColor.ORANGE);
		testInfo.get().info(c);
		Thread.sleep (500);
		getDriver().findElement(By.id("email")).click();
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys("vnwauwa@seamfix.com");
		getDriver().findElement(By.id("password")).click();
		getDriver().findElement(By.id("password")).clear();
		getDriver().findElement(By.id("password")).sendKeys("eunice");
		getDriver().findElement(By.xpath("//button")).click();
		TestUtils.assertSearchText("XPATH", "//strong", "Invalid username or password entered.");
		
	}
	
	@Test
	public static void validEmailAndPassword() throws InterruptedException {
		String landingPage = "Valid Login:";
		Markup c = MarkupHelper.createLabel(landingPage, ExtentColor.ORANGE);
		testInfo.get().info(c);
		Thread.sleep (500);
		getDriver().findElement(By.id("email")).click();
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys("soli@seamfix.com");
		getDriver().findElement(By.id("password")).click();
		getDriver().findElement(By.id("password")).clear();
		getDriver().findElement(By.id("password")).sendKeys("Bankole1!!");
		getDriver().findElement(By.xpath("//button")).click();
		TestUtils.assertSearchText("XPATH", "//p", "Dashboard");

		
	}



}