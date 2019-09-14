package CACTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import util.TestBase;
import util.TestUtils;


public class UserAccountCreation extends TestBase  {
	@Test
	public void navigateToUserAcountCreation () throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		getDriver().findElement(By.name("1732407503934User Manager")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("CSSSELECTOR", "h4.card-title.font-weight-bold.text-secondary", "User Management");
	}
	
	@Test
	public void searchInvalidEmailEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("email")).click();
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys("vnwauwa@seamfix.com");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td", "No data available in table");

	}
	@Test
	public void searchValidEmailEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("email")).click();
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("email")).sendKeys("bodili@seamfix.com");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td[3]", "bodili@seamfix.com");

	}
	
	@Test
	public void searchStatus() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.id("advancedBtn")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//span/span/span")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//span/input")).sendKeys("Active");
		getDriver().findElement(By.xpath("//span/ul/li")).click();
		Thread.sleep(500);
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td[6]/span", "ACTIVE");
		
		getDriver().findElement(By.id("email")).clear();
		getDriver().findElement(By.xpath("//span/span/span")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//span/input")).sendKeys("Inactive");
		getDriver().findElement(By.xpath("//span/ul/li")).click();
		Thread.sleep(500);
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td[6]/span", "INACTIVE");

	}
	
	/*@Test
	public void searchInValidFirstnameEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("firstname")).click();
		getDriver().findElement(By.id("firstname")).clear();
		getDriver().findElement(By.id("firstname")).sendKeys("Robinhood");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td", "No data available in table");

	}
	@Test
	public void searchValidFirstnamelEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("firstname")).click();
		getDriver().findElement(By.id("firstname")).clear();
		getDriver().findElement(By.id("firstname")).sendKeys("Chimezie");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td[3]", "bodili@seamfix.com");

	}
	@Test
	public void searchInValidLastnameEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("lastname")).click();
		getDriver().findElement(By.id("lastname")).clear();
		getDriver().findElement(By.id("lastname")).sendKeys("Caspire");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td", "No data available in table");

	}
	@Test
	public void searchValidLastnameEntry() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(getDriver(),30);
		Thread.sleep(1000);
		getDriver().findElement(By.id("lastname")).click();
		getDriver().findElement(By.id("lastname")).clear();
		getDriver().findElement(By.id("lastname")).sendKeys("Emewulu");
		getDriver().findElement(By.id("searchBtn")).click();
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("loader"), "Please wait."));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("dataTables_processing"), "Processing..." ));
		TestUtils.assertSearchText("XPATH", "//td[3]", "Chimezie");

	}*/



}
