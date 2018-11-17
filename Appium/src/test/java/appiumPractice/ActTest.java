package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ActTest{
	
	public static void main(String[] args) throws InterruptedException {
		
		
            //Set the Desired Capabilities
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("BROWSER_NAME", "");
			caps.setCapability("deviceName", "My Phone");
			caps.setCapability("udid", "7baac4c1"); //Give Device ID of your mobile phone
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "8.1.0");
			caps.setCapability("appPackage", "com.act.mobile.apps");
			caps.setCapability("appActivity", "com.act.mobile.apps.SplashActivity");
			
			//Instantiate Appium Driver
			
			AppiumDriver<MobileElement> driver = null;
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//			TouchAction TA = new TouchAction(driver);

//			MobileElement getStarted = driver.findElementById("com.act.mobile.apps:id/btnGetStarted");
//			TA.tap(getStarted);
//			MobileElement element = driver.findElementById("com.act.mobile.apps:id/btn_newtoACT_rmnlogin");
//			Thread.sleep(5000);
//			//element.click();
//			TA.tap(element);
			//TA.longPress(element);
			
			
//			MobileElement link = driver.findElementById("com.act.mobile.apps:id/tv_forgot_mobile_rmnlogin");
//			String text = link.getText();
//			System.out.println("The link is given as >"+text);
			driver.quit();
			
			
			
		}
}