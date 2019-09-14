package util;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class Assertion extends TestBase{
	
	public static void userDetailsFormAssertion() throws Exception {
		  
		  	String firstName = getDriver().findElement(By.id("firstName")).getAttribute("value");
		    String lastName = getDriver().findElement(By.id("lastName")).getAttribute("value");
		    String otherName =getDriver().findElement(By.id("otherName")).getAttribute("value");
		    String email  = getDriver().findElement(By.id("email")).getAttribute("value");
		    String mobile = getDriver().findElement(By.id("mobile")).getAttribute("value");
		    String gender = getDriver().findElement(By.id("select2-gender-container")).getText();
		    String role = getDriver().findElement(By.xpath("//span/ul")).getText();
	        String NA = "EMPTY";

	        String[] toList = {"First Name:" + firstName, "Last Name:" + lastName, "Other Name:" + otherName, "Email:" + email,
	                "Mobile:" + mobile, "Gender:" + gender, "Role:" + role};
	        for (String field : toList) {
	            String name = "";
	            String val = NA;
	            if(field.endsWith(":")) {
	            	field=field + val;
           }
	            try {
	                String[] fields = field.split(":");
	                name = fields[0];
	                val = fields[1];
	                Assert.assertNotEquals(val, NA);
	                testInfo.get().log(Status.INFO, name + " : " + val);
	            } catch (Error e) {
	                testInfo.get().error(name + " : " + val);
	            }
	        }
	    }
	
	public static void vendorDetailsFormAssertion() throws Exception {
		  
	  	String dealerName = getDriver().findElement(By.id("dealerName")).getAttribute("value");
	    String dealerCode = getDriver().findElement(By.id("dealerCode")).getAttribute("value");
	    String mobile =getDriver().findElement(By.id("mobile")).getAttribute("value");
	    String email  = getDriver().findElement(By.id("email")).getAttribute("value");
	    String address = getDriver().findElement(By.id("address")).getText();
        String NA = "EMPTY";

        String[] toList = {"Dealer Name:" + dealerName, "Dealer Code:" + dealerCode, "Mobile Number:" + mobile, "Email:" + email,
                 "Address:" + address};
        for (String field : toList) {
            String name = "";
            String val = NA;
            if(field.endsWith(":")) {
            	field=field + val;
       }
            try {
                String[] fields = field.split(":");
                name = fields[0];
                val = fields[1];
                Assert.assertNotEquals(val, NA);
                testInfo.get().log(Status.INFO, name + " : " + val);
            } catch (Error e) {
                testInfo.get().error(name + " : " + val);
            }
        }
    }

	public static void viewDetailApprovedLicense() throws Exception {
		    
			String NA = "EMPTY";
	    	
			String agentName = getDriver().findElement(By.id("agentName")).getAttribute("value");
			String approvedBy = getDriver().findElement(By.id("approvedBy")).getAttribute("value");
			String kitTag = getDriver().findElement(By.id("kitTag")).getAttribute("value");
			String macAddress = getDriver().findElement(By.id("macAddress")).getAttribute("value");
			String deviceId = getDriver().findElement(By.id("deviceId")).getAttribute("value");
			String email = getDriver().findElement(By.id("emailAddress")).getAttribute("value");
			String requestDate = getDriver().findElement(By.id("requestDate")).getAttribute("value");
			String approvedDate = getDriver().findElement(By.id("approvalDate")).getAttribute("value");
			
			String[] toList = {"Kit Tag:"+kitTag, "Mac Address:"+macAddress,"Device Id:"+deviceId, 
					"Email:"+email, "Request Date:"+requestDate, "Approved Date:"+approvedDate, "Approved by:"+approvedBy, "Agent Name:"+agentName};
			for (String field : toList) {
	            String name = "";
	            String val = NA;
	            if(field.endsWith(":")) {
	            	field=field + val;
           }
	            try {
	                String[] fields = field.split(":");
	                name = fields[0];
	                val = fields[1];
	                Assert.assertNotEquals(val, NA);
	                testInfo.get().log(Status.INFO, name + " : " + val);
	            } catch (Error e) {
	                testInfo.get().error(name + " : " + val);
	            }
	        }
	}
	
	public static void assertRecordDetails() throws Exception {
	    
		String NA = "N/A";
    	
		String deviceTag = getDriver().findElement(By.xpath("//div[6]/div/div/div/p")).getText();
		String ticketID = getDriver().findElement(By.xpath("//p[2]")).getText();
		String timeOfCapture = getDriver().findElement(By.xpath("//p[4]")).getText();
		String vendorName = getDriver().findElement(By.xpath("//p[6]")).getText();
		String appName = getDriver().findElement(By.xpath("//p[8]")).getText();
		
		String[] toList = {deviceTag, ticketID,timeOfCapture,vendorName,appName};
		for (String field : toList) {
			String name = "";
			String val = NA;
			if(field.endsWith(":")) {
				field=field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				val.contains(NA);
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, "<b>"+name+ "</b> :  " +val);
			    } catch (Error e) {
			    testInfo.get().error( "<b>"+name+ "</b> :  " + val);
			    }
		}
	}
	
	public static void captureDetails() throws InterruptedException {
		String NA = "N/A";
		String latitude = getDriver().findElement(By.id("lat")).getText();
		String longitude = getDriver().findElement(By.id("long")).getText();
		String capturedBy = getDriver().findElement(By.id("agent")).getText();
		String phoneNumber = getDriver().findElement(By.id("phone")).getText();
		String email = getDriver().findElement(By.id("email")).getText();
		String bvn = getDriver().findElement(By.id("bvn")).getText();
		String captureDuration = getDriver().findElement(By.id("duration")).getText();
		String syncStatus = getDriver().findElement(By.id("status")).getText();
		String failureReason = getDriver().findElement(By.id("reasonDiv")).getText();
		
		String[] toList = {"latitude::"+latitude, "Longitude::"+longitude, "Captured By::"+capturedBy, "Phone Number::"+phoneNumber,
				"Email::"+email, "BVN::"+bvn, "Capture Duration::"+captureDuration, "Sync Status::"+syncStatus, failureReason+":" };
		for (String field : toList) {
			String name= "";
			String val = NA;
			if(field.endsWith("::")) {
				field=field + val;
			}
			try {
				String[] fields = field.split("::");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, "<b>"+name+ "</b> : " +val);
			    } catch (Error e) {
			    testInfo.get().error( "<b>"+name+ "</b> : " + val);
			    }
		}
	}
	
	public static void assertVendorPendingIssueLog() throws InterruptedException {
		String NA = "N/A";
		String issueID = getDriver().findElement(By.id("issue_id")).getText();
		String issueSummary = getDriver().findElement(By.id("issue_summary")).getText();
		String issueCategory = getDriver().findElement(By.id("issue_category")).getText();
		String deviceTag = getDriver().findElement(By.id("kit_tag")).getText();
		String resolutionMessage = getDriver().findElement(By.id("resolutionMessage")).getText();
		TestUtils.scrollToElement("ID", "closeModal");
		String resolved = getDriver().findElement(By.id("resolvedBy")).getText();
		String dateLogged = getDriver().findElement(By.id("submissionDate")).getText();
		String resolutionDate = getDriver().findElement(By.id("resolutionDate")).getText();
		
		String[] toList = {"issue Id:"+issueID, "Issue Summary:"+issueSummary,"Issue Category:"+issueCategory, 
				"Device Tag:"+deviceTag, "Resolution Message:"+resolutionMessage, 
				"Resolved:"+resolved, "Date Logged:"+dateLogged, "Resolution Date:"+resolutionDate };
		for (String field : toList) {
			String name= "";
			String val = NA;
			String Empty = "Empty";
			if (field.endsWith(":")) {
				field = field + Empty;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
	
	public static void assertVendorResolvedIssueLog() throws InterruptedException {
		String NA = "N/A";
		String issueID = getDriver().findElement(By.id("issue_id")).getText();
		String issueSummary = getDriver().findElement(By.id("issue_summary")).getText();
		String issueCategory = getDriver().findElement(By.id("issue_category")).getText();
		String deviceTag = getDriver().findElement(By.id("kit_tag")).getText();
		String resolutionMessage = getDriver().findElement(By.id("resolutionMessage")).getText();
		TestUtils.scrollToElement("ID", "closeModal");
		String resolved = getDriver().findElement(By.id("resolvedBy")).getText();
		String dateLogged = getDriver().findElement(By.id("submissionDate")).getText();
		String resolutionDate = getDriver().findElement(By.id("resolutionDate")).getText();
		
		String[] toList = {"issue Id:"+issueID, "Issue Summary:"+issueSummary,"Issue Category:"+issueCategory, 
				"Device Tag:"+deviceTag, "Resolution Message:"+resolutionMessage, 
				"Resolved:"+resolved, "Date Logged:"+dateLogged, "Resolution Date:"+resolutionDate };
		for (String field : toList) {
			String name= "";
			String val = NA;
			if (field.endsWith(":")) {
				field = field + NA;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
	
    public static void assertMobileInfo() throws Exception {
        
    	String NA = "N/A";
    	
    	String Tag = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div/table/tbody/tr/td[2]")).getText();
    	String dealer = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div/table/tbody/tr[2]/td[2]")).getText();
    	String code = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div/table/tbody/tr[3]/td[2]")).getText();
    	String dealerType = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div/table/tbody/tr[4]/td[2]")).getText();
    	String division = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr/td[2]")).getText();
    	String deviceStatus = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
    	String todayRegCount = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr[3]/td[2]")).getText();
    	String lastHeartBeatTime = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr[4]/td[2]")).getText();
    	String installer = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr[5]/td[2]")).getText();
    	String mac = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[2]/table/tbody/tr[6]/td[2]")).getText();
    	String networkStrength = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr/td[2]")).getText();
    	String isDeviceRooted = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[2]/td[2]")).getText();
    	String OS_Name = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[3]/td[2]")).getText();
    	String OS_Version = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[4]/td[2]")).getText();
    	String processorSpeed = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[5]/td[2]")).getText();
    	String appVersion = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[6]/td[2]")).getText();
    	String deviceType = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[7]/td[2]")).getText();
    	String deviceID = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[3]/table/tbody/tr[8]/td[2]")).getText();
    	String storageUsed = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr/td[2]")).getText();
    	String storageAvailable = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[2]/td[2]")).getText();
    	String totalStorage = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[3]/td[2]")).getText();
    	String RAM_Size = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[4]/td[2]")).getText();
    	String lastLoggedInUser = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[5]/td[2]")).getText();
    	String lastSyncTime = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[6]/td[2]")).getText();
    	String kitModel = getDriver().findElement(By.xpath("//div[@id='collapseTwo']/div/div[4]/table/tbody/tr[7]/td[2]")).getText();
    	
    	String[] toList = {"Tag:"+Tag, "Dealer:"+dealer, "Code:"+code, "DealerType:"+dealerType, "Division:"+division, "deviceStatus:"+deviceStatus, "todayRegCount:"+todayRegCount, "lastHeartBeatTime:"+lastHeartBeatTime, "installer:"+installer, "mac:"+mac, 
    			"networkStrength:"+networkStrength, "isDeviceRooted:"+isDeviceRooted, "OS_Name:"+OS_Name, "OS_Version:"+OS_Version, "ProcessorSpeed:"+processorSpeed, "appVersion:"+appVersion, "deviceType:"+deviceType, "deviceID:"+deviceID, "storageUsed:"+storageUsed, 
    			"storageAvailable:"+storageAvailable, "totalStorage:"+totalStorage, "RAM_Size:"+RAM_Size, "lastLoggedInUser:"+lastLoggedInUser, "lastSyncTime:"+lastSyncTime, "kitModel:"+kitModel};
		for (String field : toList) {
			String name= "";
			String val = NA;
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
    }
    
    public static void assertLocationInfo() throws Exception {
    	
    	String NA = "N/A";
    	
    	String defaultLocation = getDriver().findElement(By.id("defaultLocation")).getText();
    	String currentLocation = getDriver().findElement(By.id("currentLocation")).getText();
    	String lastLocationUpdate = getDriver().findElement(By.id("lastLocationUpdate")).getText();
    	String locationAccuracy = getDriver().findElement(By.id("locationAccuracy")).getText();
    	String outletName = getDriver().findElement(By.id("outletName")).getText();
    	
    	String[] toList = {"defaultLocation:"+defaultLocation, "currentLocation:"+currentLocation, "lastLocationUpdate:"+lastLocationUpdate, "locationAccuracy:"+locationAccuracy, "outletName:"+outletName};
		for (String field : toList) {
			String name= "";
			String val = NA;
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
    }
    
    public static void viewTaggingApprovalDetails() throws InterruptedException {
    	String NA = "N/A";
		String deviceId = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr/td[2]")).getText();
		String deviceTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[2]/td[2]")).getText();
		String previousTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[3]/td[2]")).getText();
		String requestedBy = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[4]/td[2]")).getText();
		String appVersion = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[5]/td[2]")).getText();
		String dateRequested = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[6]/td[2]")).getText();
		String dealer = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[7]/td[2]")).getText();
		String dealerCode = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[8]/td[2]")).getText();
		String dealerRegion = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[9]/td[2]")).getText();
		String dealerSubRegion = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[10]/td[2]")).getText();
		String dealerState = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[11]/td[2]")).getText();
		
		String[] toList = {"Device Id:"+deviceId, "Device Tag:"+deviceTag, "Previous Tag:"+previousTag,"Requested By:"+requestedBy, 
				"App Version:"+appVersion, "Date Requested:"+dateRequested, "Dealer:"+dealer, "Dealer Code:"+dealerCode
				, "Dealer Region:"+dealerRegion, "Dealer SubRegion:"+dealerSubRegion, "Dealer State:"+dealerState};
		for (String field : toList) {
			String name= "";
			String val = NA;
			if(field.endsWith(":")) {
            	field=field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
    
	public static void viewTaggingApprovalDetailsDown() throws InterruptedException {
    	String NA = "N/A";
		String stateOfDeploy = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[12]/td[2]")).getText();
		String lgaOfDeploy = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[13]/td[2]")).getText();
		String status = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[14]/td[2]")).getText();
		
		String[] toList = {"State Of Deploy:"+stateOfDeploy, "Device Id:"+lgaOfDeploy, "Status:"+status };
		for (String field : toList) {
			String name= "";
			String val = NA;
			if(field.endsWith(":")) {
            	field=field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
	
	public static void assertDeviceDealerInformation() throws InterruptedException {

		String NA = "EMPTY";

		String kitTag = getDriver().findElement(By.xpath("//span/span/span")).getText();
		String macAddress = getDriver().findElement(By.id("mac")).getText();
		String deviceType = getDriver().findElement(By.xpath("//div[5]/div/span/span/span")).getText();
		String deviceOwner = getDriver().findElement(By.xpath("//div[6]/div/span/span/span")).getText();
		String deviceID = getDriver().findElement(By.id("deviceId")).getText();

		String dealer = getDriver().findElement(By.xpath("//div[2]/div/input")).getText();
		String dealerCode = getDriver().findElement(By.xpath("//div[3]/form/div/div[3]/div/input")).getText();
		String dealerType = getDriver().findElement(By.xpath("//div[3]/form/div/div[4]/div/input")).getText();
		String region = getDriver().findElement(By.xpath("//div[3]/form/div/div[5]/div/span/span/span")).getText();
		String subRegion = getDriver().findElement(By.xpath("//div[3]/form/div/div[6]/div/span/span/span")).getText();
		String state = getDriver().findElement(By.xpath("//div[7]/div/span/span/span")).getText();
		String lga = getDriver().findElement(By.xpath("//div[9]/div/span/span/span")).getText();
		String territory = getDriver().findElement(By.xpath("//div[8]/div/span/span/span")).getText();
		String area = getDriver().findElement(By.xpath("//div[10]/div/span/span/span")).getText();

		String[] toList = { "Kit Tag:" + kitTag, "MacAddress:" + macAddress, "Device Type:" + deviceType,
				"Device Owner:" + deviceOwner, "Device ID:" + deviceID, "Dealer:" + dealer, "Dealer Code:" + dealerCode,
				"Dealer Type:" + dealerType, "Region:" + region, "Sub-Region:" + subRegion, "State:" + state,
				"LGA:" + lga, "Territory:" + territory, "Area:" + area };
		for (String field : toList) {
			String name = "";
			String val = NA;
			if (field.endsWith(":")) {
				field = field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name + " :  " + val);
			} catch (Error e) {
				testInfo.get().error(name + " :  " + val);
			}
		}
	}
	
	
	public static void assertAirtimeTransInfoCAC() throws InterruptedException {
	    
    	String NA = "N/A";
    	
		String transactionID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr/td[2]")).getText();
		String transactionDate = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[2]/td[2]")).getText();
		String status = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[3]/td[2]")).getText();
		String agentUsername = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[4]/td[2]")).getText();
		String agentVTUNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[5]/td[2]")).getText();
		String airtimeAmount = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[6]/td[2]")).getText();
		String dealerName = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[7]/td[2]")).getText();
		String deviceTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[8]/td[2]")).getText();
		String deviceID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[9]/td[2]")).getText();
		String subPhoneNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[10]/td[2]")).getText();
		
		String[] toList = {"transactionID:"+transactionID, "transactionDate:"+transactionDate, "status:"+status, "agentUsername:"+agentUsername, 
				"agentVTUNumber:"+agentVTUNumber, "dealer name:"+dealerName, "subPhoneNumber:"+subPhoneNumber, "deviceTag:"+deviceTag, "deviceID:"+deviceID,  "airtimeAmount:"+airtimeAmount};
		for (String field : toList) {
			String name= "";
			String val = NA;
			if (field.endsWith(":")) {
				field = field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
	
	public static void assertDataTransInfoCAC() throws InterruptedException {
	    
    	String NA = "N/A";
		String transactionID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr/td[2]")).getText();
		String transactionDate = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[2]/td[2]")).getText();
		String status = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[3]/td[2]")).getText();
		String agentUsername = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[4]/td[2]")).getText();
		String agentVTUNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[5]/td[2]")).getText();
		String airtimeAmount = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[6]/td[2]")).getText();
		String dealerName = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[7]/td[2]")).getText();
		String deviceTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[8]/td[2]")).getText();
		String deviceID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[9]/td[2]")).getText();
		String subPhoneNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[10]/td[2]")).getText();
		String dataSize = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[11]/td[2]")).getText();
		
		String[] toList = {"transactionID:"+transactionID, "transactionDate:"+transactionDate, "status:"+status, "agentUsername:"+agentUsername, 
				"agentVTUNumber:"+agentVTUNumber, "dealer name:"+dealerName, "subPhoneNumber:"+subPhoneNumber, "deviceTag:"+deviceTag, 
				"deviceID:"+deviceID, "airtimeAmount:"+airtimeAmount, "Data Size:"+dataSize};
		for (String field : toList) {
			String name= "";
			String val = NA;
			if (field.endsWith(":")) {
				field = field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
	
		public static void assertB2BDetail() throws InterruptedException {
    	String NA = "Empty";
    	
		String dealer = getDriver().findElement(By.id("dealer")).getText();
		String kitTag = getDriver().findElement(By.id("kit_tag")).getText();
		String macAddress = getDriver().findElement(By.id("mac_address")).getText();
		String b2bCode = getDriver().findElement(By.id("b2b_code")).getText(); 
		String b2bLocationDescription = getDriver().findElement(By.id("b2b_location_description")).getText();
		String address = getDriver().findElement(By.id("b2b_location")).getText();
		String reqDescription = getDriver().findElement(By.id("b2b_description")).getText();
		String dateReturned = getDriver().findElement(By.id("dateReturned")).getText();
		String approvalStatus = getDriver().findElement(By.id("status")).getText();
		String resolutionMessage = getDriver().findElement(By.id("resolutionMessage")).getText();
		String resolutionDate = getDriver().findElement(By.id("resolutionDate")).getText();
		
		String[] toList = {"Dealer: "+dealer, "KitTag: "+kitTag, "MacAddress: "+macAddress, "b2bCode: "+b2bCode, 
				"B2B Location/Description: "+b2bLocationDescription, "Address: "+address, "Request Description: "+reqDescription, "Date Returned: "+dateReturned, 
				"Approval Status: "+approvalStatus, "ResolutionMessage:"+resolutionMessage,
				"ResolutionDate: "+resolutionDate};
		for (String field : toList) {
			String name= "";
			String val = NA;
			if (field.endsWith(":")) {
				field = field + val;
			}
			try {
				String[] fields = field.split(":");
				name = fields[0];
				val = fields[1];
				Assert.assertNotEquals(val, NA);
				testInfo.get().log(Status.INFO, name+ " : " +val);
			    } catch (Error e) {
			    testInfo.get().error( name+ " : " + val);
			    }
		}
	}
		
		public static void assertB2BTableValue() throws InterruptedException {
	    	String NA = "Empty";
			String serialNo = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td")).getText();
			String dealer = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[2]")).getText();
			String kitTag = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[3]")).getText();
			String status = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[4]")).getText();
			String resolvedBy = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[5]")).getText();
			String dateReturned = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[6]")).getText();
			String resolutionDate = getDriver().findElement(By.xpath("//table[@id='b2bRequestTable']/tbody/tr/td[7]")).getText();
			
			String[] toList = {"Serial No:"+serialNo, "Dealer:"+dealer, "KitTag:"+kitTag,"Status:"+status, 
					"ResolvedBy:"+resolvedBy, "Date Returned:"+dateReturned, "Resolution Date:"+resolutionDate };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertKitRetrievalDetail() throws InterruptedException {
	    	String NA = "N/A";
	    	
			String kitTag = getDriver().findElement(By.id("kit_tag")).getText();
			String deviceID = getDriver().findElement(By.id("device_id")).getText();
			String assignedAgent = getDriver().findElement(By.id("assigned_agent")).getText();
			String retrievalReason = getDriver().findElement(By.id("retrieval_reason")).getText();
			String retrievedBy = getDriver().findElement(By.id("dealer_email")).getText();
			String dealerComment = getDriver().findElement(By.id("feedback")).getText();
			String dateRetrieved = getDriver().findElement(By.id("date_retrieved")).getText();
			
			String[] toList = {"Kit Tag:"+kitTag, "Device ID :"+deviceID,"Assigned agent: "+assignedAgent, 
					"Kit Retrieval reason:"+retrievalReason,"Kit Retrieved By:"+retrievedBy, "Dealer's Comments:"+dealerComment,
					"Date Retrieved:"+dateRetrieved};
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertKitRetieval() throws Exception {

			String NA = "EMPTY";

			String kitTag = getDriver().findElement(By.id("retrieveMappingId1")).getAttribute("value");
			String deviceID = getDriver().findElement(By.id("deviceId")).getAttribute("value");
			String assignedAgent = getDriver().findElement(By.id("assignedAgent")).getAttribute("value");

			String[] toList = { "Kit Tag:" + kitTag, "Device Id:" + deviceID, "Agent Name:" + assignedAgent };
			for (String field : toList) {
				String name = "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name + " : " + val);
				} catch (Error e) {
					testInfo.get().error(name + " : " + val);
				}
			}
		}
		
		public static void assertNewKitAssignment() throws Exception {

			String NA = "EMPTY";

			String mac = getDriver().findElement(By.id("mac")).getAttribute("value");
			String deviceType = getDriver().findElement(By.xpath("//div[3]/div/span/span/span")).getAttribute("value");
			String deviceOwner= getDriver().findElement(By.xpath("//div[4]/div/span/span/span")).getAttribute("value");

			String[] toList = { "Mac Address:" + mac, "Device Type:" + deviceType, "Device Ownner:" + deviceOwner };
			for (String field : toList) {
				String name = "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name + " : " + val);
				} catch (Error e) {
					testInfo.get().error(name + " : " + val);
				}
			}
		}
		
		public static void dealerAutopopulatedDetails() throws Exception {

			String NA = "EMPTY";

			String dealer = getDriver().findElement(By.xpath("//div[@id='dealer']/div/div/div/input")).getAttribute("value");
			String deviceCode = getDriver().findElement(By.xpath("//div[@id='dealer']/div/div[2]/div/input")).getAttribute("value");
			String deviceType = getDriver().findElement(By.xpath("//div[@id='dealer']/div/div[3]/div/input")).getAttribute("value");

			String[] toList = { "Dealer:" + dealer, "Device Code:" + deviceCode, "Device Type:" + deviceType };
			for (String field : toList) {
				String name = "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name + " : " + val);
				} catch (Error e) {
					testInfo.get().error(name + " : " + val);
				}
			}
		}
		
		public static void assertExistingAgentInformation() throws Exception {

			String NA = "EMPTY";

			String firstName = getDriver().findElement(By.id("firstName")).getAttribute("value");
			String surName = getDriver().findElement(By.id("surname")).getAttribute("value");
			String phoneNumber = getDriver().findElement(By.id("phoneNumber")).getAttribute("value");
			String nubanNumber = getDriver().findElement(By.id("agentNubanNumber")).getAttribute("value");
			String vtuNumber = getDriver().findElement(By.id("agentVtuNumber")).getAttribute("value");

			String[] toList = { "First Name:" + firstName, "Surname:" + surName, "Phone Number:" + phoneNumber,
					"Nuban Number:" + nubanNumber, "VTU Number:" + vtuNumber};
			for (String field : toList) {
				String name = "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name + " :  " + val);
				} catch (Error e) {
					testInfo.get().error(name + " :  " + val);
				}
			}
		}
		
		public static void assertRequisitionDetail() throws InterruptedException {
	    	String NA = "N/A";
			String dealer = getDriver().findElement(By.id("dealerName")).getText();
			String dealerCode = getDriver().findElement(By.id("dealerCode")).getText();
			String dealerStates = getDriver().findElement(By.id("dealerStates")).getText();
			String stateOfDeploy = getDriver().findElement(By.id("sod")).getText();
			String lgaOfDeploy = getDriver().findElement(By.id("lod")).getText();
			String areaOfDeploy = getDriver().findElement(By.id("aod")).getText();
			String deviceReq = getDriver().findElement(By.id("deviceRequested")).getText();
			String status = getDriver().findElement(By.id("reason")).getText();
			
			String[] toList = {"Dealer:"+dealer, "Dealer Code:"+dealerCode, "Dealer States:"+dealerStates,
					"State Of Deployment:"+stateOfDeploy, "Lga Of Deployment:"+lgaOfDeploy, "Area Of Deployment:"+areaOfDeploy, "Device Req:"+deviceReq,
					"Status:"+status };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertKitIssueViewDetailCAC() throws InterruptedException {
	    	String NA = "N/A";
			String issueID = getDriver().findElement(By.id("issue_id")).getText();
			String deviceId = getDriver().findElement(By.xpath("//div[2]/div/table/tbody/tr[2]/td[2]")).getText();
			String issueSummary = getDriver().findElement(By.id("issue_summary")).getText();
			String issueCategory = getDriver().findElement(By.id("issue_category")).getText();
			String kitTag = getDriver().findElement(By.id("kit_tag")).getText();
			String appVersion = getDriver().findElement(By.id("app_version")).getText();
			String description = getDriver().findElement(By.id("description")).getText();
			String resolutionMessage = getDriver().findElement(By.id("resolutionMessage")).getText();
			TestUtils.scrollToElement("ID", "closeModal");
			String resolved = getDriver().findElement(By.id("resolvedBy")).getText();
			String dateLogged = getDriver().findElement(By.id("submissionDate")).getText();
			String resolutionDate = getDriver().findElement(By.id("resolutionDate")).getText();
			
			String[] toList = {"issue Id:"+issueID, "Device ID: "+deviceId, "Issue Summary:"+issueSummary,"Issue Category:"+issueCategory, 
					"Kit Tag:"+kitTag, "Application Version: "+appVersion, "Description:"+description, "Resolution Message:"+resolutionMessage, 
					"Resolved:"+resolved, "Date Logged:"+dateLogged, "Resolution Date:"+resolutionDate };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}

		public static void assertAirtimeTransInfoDealer() throws Exception {
		    
	    	String NA = "N/A";
	    	
			String transactionID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr/td[2]")).getText();
			String transactionDate = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[2]/td[2]")).getText();
			String status = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[3]/td[2]")).getText();
			String agentUsername = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[4]/td[2]")).getText();
			String agentVTUNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[5]/td[2]")).getText();
			String subPhoneNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[6]/td[2]")).getText();
			String deviceTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[7]/td[2]")).getText();
			String deviceID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[8]/td[2]")).getText();
			String airtimeAmount = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[9]/td[2]")).getText();
			
			String[] toList = {"transactionID:"+transactionID, "transactionDate:"+transactionDate, "status:"+status, "agentUsername:"+agentUsername, 
					"agentVTUNumber:"+agentVTUNumber, "subPhoneNumber:"+subPhoneNumber, "deviceTag:"+deviceTag, "deviceID:"+deviceID,  "airtimeAmount:"+airtimeAmount};
			for (String field : toList) {
				String name= "";
				String val = NA;
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertDataTransInfoDealer() throws Exception {
		    
	    	String NA = "N/A";
	    	
			String transactionID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr/td[2]")).getText();
			String transactionDate = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[2]/td[2]")).getText();
			String status = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[3]/td[2]")).getText();
			String agentUsername = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[4]/td[2]")).getText();
			String agentVTUNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[5]/td[2]")).getText();
			String subPhoneNumber = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[6]/td[2]")).getText();
			String deviceTag = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[7]/td[2]")).getText();
			String deviceID = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[8]/td[2]")).getText();
			String dataSize = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[9]/td[2]")).getText();
			String dataAmonut = getDriver().findElement(By.xpath("//div[@id='rowContent']/div/table/tbody/tr[10]/td[2]")).getText();
			
			String[] toList = {"transactionID:"+transactionID, "transactionDate:"+transactionDate, "status:"+status, "agentUsername:"+agentUsername, 
					"agentVTUNumber:"+agentVTUNumber, "subPhoneNumber:"+subPhoneNumber, "deviceTag:"+deviceTag, "deviceID:"+deviceID, "dataSize:"+dataSize, "dataAmonut:"+dataAmonut};
			for (String field : toList) {
				String name= "";
				String val = NA;
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertDeviceRequisitionDetailsDealer() throws InterruptedException {
	    	String NA = "N/A";
			String deviceCount = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]")).getText();
			String dateReq = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[2]/td")).getText();
			String stateOfDeploy = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[3]/td[2]")).getText();
			String lgaOfDeploy = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[4]/td[2]")).getText();
			String areaOfDeploy = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[5]/td[2]")).getText();
			String reqReason = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[6]/td[2]")).getText();
			String status = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[7]/td")).getText();
			
			String[] toList = {"Device Count:"+deviceCount, "Date request:"+dateReq, "State Of Deployment:"+stateOfDeploy, "Lga Of Deployment:"+lgaOfDeploy, "Area Of Deployment:"+areaOfDeploy, "Request Reason:"+reqReason,
					"Status:"+status };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertWorkflowDetail() throws InterruptedException {
		    
	    	String NA = "N/A";
	    	
			String pk = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]")).getText();
			String activity = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[2]/td[2]")).getText();
			String order = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[3]/td[2]")).getText();
			String workflowName = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[4]/td[2]")).getText();
			String description = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[5]/td[2]")).getText();
			String date = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[6]/td[2]")).getText();
			String status = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[7]/td[2]")).getText();
			String deleted = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[8]/td[2]")).getText();
			String roles = getDriver().findElement(By.xpath("//div[2]/div/div/table/tbody/tr[9]/td[2]")).getText();
			
			String[] toList = {"PK: "+pk, "Activity: "+activity, "Order: "+order, "Workflow: "+workflowName, 
					"Description: "+description, "Status: "+status, "Deleted: "+deleted, "Roles: "+roles,  "Date: "+date};
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertOnboardingRequestDetailsDealer() throws InterruptedException {
	    	String NA = "N/A";
			String agentName = getDriver().findElement(By.id("agentName")).getText();
			String agentEmail = getDriver().findElement(By.id("agentEmail")).getText();
			String agentVtuNum = getDriver().findElement(By.id("vtuNumber")).getText();
			String agentPhoNum = getDriver().findElement(By.id("agentPhoneNumber")).getText();
			String dateReq = getDriver().findElement(By.id("dateRequested")).getText();
			String dateApproved = getDriver().findElement(By.id("dateApproved")).getText();
			String approvedBy = getDriver().findElement(By.id("approvedBy")).getText();
			String activationStatus = getDriver().findElement(By.id("activationStatus")).getText();
			String status = getDriver().findElement(By.id("vStatus")).getText();
			
			String[] toList = {"Agent Name:"+agentName, "Agent Email:"+agentEmail, "Agent VTU Number:"+agentVtuNum, "Agent Phone Number:"+agentPhoNum, "Date Requested:"+dateReq, "Date Approved:"+dateApproved,
					"Approved By:"+approvedBy, "Activation Status:"+activationStatus, "Status:"+status };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if (field.endsWith(":")) {
					field = field + val;
				}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
		
		public static void assertVtuOnboardAgentDetailsDealer() throws InterruptedException {
	    	String NA = "N/A";
			String agentName = getDriver().findElement(By.id("agentname")).getAttribute("value");;
			String agentPhoNum = getDriver().findElement(By.id("agentphonenumber")).getAttribute("value");
			
			String[] toList = {"Agent Name:"+agentName, "Agent Phone Number:"+agentPhoNum };
			for (String field : toList) {
				String name= "";
				String val = NA;
				if(field.endsWith(":")) {
	            	field=field + val;
					}
				try {
					String[] fields = field.split(":");
					name = fields[0];
					val = fields[1];
					Assert.assertNotEquals(val, NA);
					testInfo.get().log(Status.INFO, name+ " : " +val);
				    } catch (Error e) {
				    testInfo.get().error( name+ " : " + val);
				    }
			}
		}
}
