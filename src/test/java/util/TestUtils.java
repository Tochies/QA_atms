package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import enums.TargetTypeEnum;

/**
 * @author soli@seamfix.com
 */
public class TestUtils extends TestBase {

    /**
     * @param driver
     * @param screenshotName
     * @return
     * @throws IOException
     * @description to take a screenshot
     */
    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";

        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    /**
     * @param type
     * @param element
     * @throws InterruptedException
     * @description to scroll to a particular element on the page.
     */
    public static void scrollToElement(String type, String element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        WebElement scrollDown = null;

        TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(type);
        switch (targetTypeEnum) {
            case ID:
                scrollDown = getDriver().findElement(By.id(element));
                break;
            case NAME:
                scrollDown = getDriver().findElement(By.name(element));
                break;
            case CSSSELECTOR:
                scrollDown = getDriver().findElement(By.cssSelector(element));
                break;

            case XPATH:
                scrollDown = getDriver().findElement(By.xpath(element));
                break;

            default:
                scrollDown = getDriver().findElement(By.id(element));
                break;
        }

        jse.executeScript("arguments[0].scrollIntoView();", scrollDown);
        Thread.sleep(3000);
    }

    /**
     * @param type
     * @param element
     * @param value
     * @throws InterruptedException
     * @description to check if the expected text is present in the page.
     */
    public static void assertSearchText(String type, String element, String value) throws InterruptedException {

        StringBuffer verificationErrors = new StringBuffer();
        TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(type);
        String ttype = null;

        switch (targetTypeEnum) {
            case ID:
                ttype = getDriver().findElement(By.id(element)).getText();
                break;
            case NAME:
                ttype = getDriver().findElement(By.name(element)).getText();
                break;
            case CSSSELECTOR:
                ttype = getDriver().findElement(By.cssSelector(element)).getText();
                break;

            case XPATH:
                ttype = getDriver().findElement(By.xpath(element)).getText();
                break;

            default:
                ttype = getDriver().findElement(By.id(element)).getText();
                break;
        }

        try {
            Assert.assertEquals(ttype, value);
            testInfo.get().log(Status.INFO, value + " found");
        } catch (Error e) {
            verificationErrors.append(e.toString());
            String verificationErrorString = verificationErrors.toString();
            testInfo.get().error(value + " not found");
            testInfo.get().error(verificationErrorString);
        }
    }

    /**
     * @return number
     * @description to generate a 11 digit number.
     */
    public static String generatePhoneNumber() {

        long y = (long) (Math.random() * 100000 + 0333330000L);
        String Surfix = "080";
        String num = Long.toString(y);
        String number = Surfix + num;
        return number;

    }

    /**
     * @return number
     * @description to generate a 7 digit number
     */
    public static String generateSerialNumber() {

        long y = (long) (Math.random() * 100000 + 1000000L);
        String num = Long.toString(y);
        return num;

    }

    /**
     * @param value
     * @return string value.
     * @throws InterruptedException
     * @description to convert string value to int value for calculations
     */
    public static Integer convertToInt(String value) throws InterruptedException {
        Integer result = null;
        String convertedString = value.replaceAll("[^0-9]", "");
        if (validateParams(convertedString)) {
            try {
                return result = Integer.parseInt(convertedString);
            } catch (NumberFormatException e) {
                testInfo.get().error("convertToInt  Error converting to integer ");
                testInfo.get().error(e);
            }
        }
        return result;

    }

    public static Long convertToLong(String value) {
        Long result = null;
        String convertedString = value.replaceAll("[^0-9]", "");
        if (validateParams(convertedString)) {
            try {
                return result = Long.parseLong(convertedString);
            } catch (NumberFormatException e) {
                testInfo.get().error("ConvertToLong  Error converting to long");
                testInfo.get().error(e);
            }
        }
        return result;
    }

    public static boolean validateParams(Object... params) {

        for (Object param : params) {
            if (param == null) {
                return false;
            }

            if (param instanceof String && ((String) param).isEmpty()) {
                return false;
            }

            if (param instanceof Collection<?> && ((Collection<?>) param).isEmpty()) {
                return false;
            }

            if (param instanceof Long && ((Long) param).compareTo(0L) == 0) {
                return false;
            }
            if (param instanceof Double && ((Double) param).compareTo(0D) == 0) {
                return false;
            }

            if (param instanceof Integer && ((Integer) param).compareTo(0) == 0) {
                return false;
            }

        }

        return true;
    }

    public static String addScreenshot() {

        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String encodedBase64 = null;
        FileInputStream fileInputStreamReader = null;
        try {
            fileInputStreamReader = new FileInputStream(scrFile);
            byte[] bytes = new byte[(int) scrFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "data:image/png;base64," + encodedBase64;
    }

    public static boolean isAlertPresents() {
        try {
            getDriver().switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }

    public static boolean isLoaderPresents() {
        try {
            getDriver().findElement(By.className("dataTables_processing")).isDisplayed();
            return true;
        }// try
        catch (Exception e) {
            return false;
        }// catch
    }

    public static void clickElement(String type, String element) {
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        WebElement clickThis = null;
        TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(type);
        switch (targetTypeEnum) {
            case ID:
                clickThis = getDriver().findElement(By.id(element));
                break;
            case NAME:
                clickThis = getDriver().findElement(By.name(element));
                break;
            case CSSSELECTOR:
                clickThis = getDriver().findElement(By.cssSelector(element));
                break;
            case XPATH:
                clickThis = getDriver().findElement(By.xpath(element));
                break;
            default:
                clickThis = getDriver().findElement(By.id(element));
        }
        ex.executeScript("arguments[0].click()", clickThis);
    }

    public static String DeviceIDs() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("droid-007-lag-eti-854784", "WIN-AG003-LAG-ETI-01012", "droid-ag003-lag-osh-1234", "WIN-AG003-LAG-IBL-117424");

        int randomIndex = rand.nextInt(givenList.size());
        String randomElement = givenList.get(randomIndex);

        return randomElement;

    }

    public static String state() {
        Random rand = new Random();
        List<String> givenList = Arrays.asList("ENUGU", "LAGOS", "TARABA", "KANO");

        int randomIndex = rand.nextInt(givenList.size());
        String randomElement = givenList.get(randomIndex);

        return randomElement;

    }

    public static String deviceID1;

    public static String getDeviceID() {

        deviceID1 = getDriver().findElement(By.id("kitDeviceId")).getText();

        return deviceID1;
    }

    public static String setDeviceID() {

        return TestUtils.deviceID1;
    }

    public static Calendar yyyymmddToDate(String dateString) {
        Calendar dateDate = Calendar.getInstance();

        try {
            String[] dateArray = dateString.split("-");
            int year = Integer.valueOf(dateArray[0]);
            int month = Integer.valueOf(dateArray[1]) - 1;
            int day = Integer.valueOf(dateArray[2]);

            dateDate.set(year, month, day);
        } catch (NumberFormatException e) {
            String[] dateArray = dateString.split("/");
            int year = Integer.valueOf(dateArray[0]);
            int month = Integer.valueOf(dateArray[1]) - 1;
            int day = Integer.valueOf(dateArray[2]);

            dateDate.set(year, month, day);
        }

        return dateDate;
    }
    
    public static Calendar mmddyyyyToDate(String dateString) {
        Calendar dateDate = Calendar.getInstance();

        try {
            String[] dateArray = dateString.split("-");
            int month = Integer.valueOf(dateArray[0])- 1;
            int day = Integer.valueOf(dateArray[1]) ;
            int year = Integer.valueOf(dateArray[2]);

            dateDate.set(month, day, year);
        } catch (NumberFormatException e) {
            String[] dateArray = dateString.split("/");
            int month = Integer.valueOf(dateArray[0]) - 1;
            int day = Integer.valueOf(dateArray[1]);
            int year = Integer.valueOf(dateArray[2]);

            dateDate.set(year, month, day);
        }

        return dateDate;
    }

    public static void checkDateBoundary(String start, String end, String verify) {
        Calendar startDate = mmddyyyyToDate(start);
        Calendar endDate = mmddyyyyToDate(end);
        Calendar verifyDate = yyyymmddToDate(verify);

        if (verifyDate.before(startDate) && verifyDate.after(endDate)) {
        	testInfo.get().error("Record not within date range");
        } else {
        	testInfo.get().info("Record within date range");
        }
    }
    
    public static void checkDateyYMDBoundary(String start, String end, String verify) {
        Calendar startDate = yyyymmddToDate(start);
        Calendar endDate = yyyymmddToDate(end);
        Calendar verifyDate = yyyymmddToDate(verify);

        if (verifyDate.before(startDate) && verifyDate.after(endDate)) {
        	testInfo.get().error("Record not within date range");
        } else {
        	testInfo.get().info("Record within date range");
        }
    }

    public static void assertDivAlert(WebElement alert_element, String expected_message) {
        if (alert_element.getText().contains(expected_message)) {
            testInfo.get().info(expected_message + " found");
        } else {
            testInfo.get().error(expected_message + " not found");
            testInfo.get().error("Expected " + expected_message + " but found " + alert_element.getText());
        }
    }
    
    public static String CheckBrowser() {
  	  //Get Browser name and version.
  	  Capabilities caps = ((RemoteWebDriver) getDriver()).getCapabilities();
  	  String browserName = caps.getBrowserName();
  	  String browserVersion = caps.getVersion();
  	  
  	  //return browser name and version.
  	  String os = browserName + " "+ browserVersion;
  	  
  	  return os;
  	 } 
    
    public static boolean isElementPresent(String elementType, String locator){

        WebElement elementPresent = null;

         TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(elementType);
         switch (targetTypeEnum) {
             case ID:
                 try{
                     elementPresent = getDriver().findElement(By.id(locator));
                 }catch (Exception e){}
                 break;
             case NAME:
                 try{
                     elementPresent = getDriver().findElement(By.name(locator));
                 }catch (Exception e){}
                 break;
             case CSSSELECTOR:
                 try{
                     elementPresent = getDriver().findElement(By.cssSelector(locator));
                 }catch (Exception e){}
                 break;
             case XPATH:
                 try{
                     elementPresent = getDriver().findElement(By.xpath(locator));
                 }catch (Exception e){}
                 break;
             default:
                 try{
                     elementPresent = getDriver().findElement(By.id(locator));
                 }catch (Exception e){}
         }
         if(elementPresent != null){
             return true;
         }
         else {
             return false;
         }
     }
    
    public static ExtentTest elementIsPresent(String elementType, String locator, String message){

        WebElement elementPresent = null;

         TargetTypeEnum targetTypeEnum = TargetTypeEnum.valueOf(elementType);
         switch (targetTypeEnum) {
             case ID:
                 try{
                     elementPresent = getDriver().findElement(By.id(locator));
                 }catch (Exception e){}
                 break;
             case NAME:
                 try{
                     elementPresent = getDriver().findElement(By.name(locator));
                 }catch (Exception e){}
                 break;
             case CSSSELECTOR:
                 try{
                     elementPresent = getDriver().findElement(By.cssSelector(locator));
                 }catch (Exception e){}
                 break;
             case XPATH:
                 try{
                     elementPresent = getDriver().findElement(By.xpath(locator));
                 }catch (Exception e){}
                 break;
             default:
                 try{
                     elementPresent = getDriver().findElement(By.id(locator));
                 }catch (Exception e){}
         }
         if(elementPresent != null){
             return testInfo.get().log(Status.INFO, message+" is present");

         }
         else {
             return testInfo.get().fail(message+" is not present");
         }
     }
}
