package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class LongPress {

	AppiumDriver<MobileElement> driver;
	public void setup() throws MalformedURLException{
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("BROWSER_NAME", "");
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "56f871e7"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("noReset", true);
		caps.setCapability("appPackage", "com.android.mms");
		caps.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver= new AndroidDriver<MobileElement>(url, caps);
	}
	
	public void longPressToDelete() throws InterruptedException{
		
		TouchAction ta = new TouchAction(driver);
		MobileElement element = driver.findElementById("com.android.mms:id/subject");
//		ta.longPress(element).perform().release();
		Thread.sleep(2000);
		boolean displayed = driver.findElementByAccessibilityId("Cancel").isDisplayed();
		if(displayed){
			
			System.out.println("Pass");
		}
		
		else{
			
			System.out.println("Fail");
		}
	}
	
	public void tearDown(){
		
		driver.quit();
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		LongPress obj = new LongPress();
		obj.setup();
		obj.longPressToDelete();
		obj.tearDown();

	}
}
