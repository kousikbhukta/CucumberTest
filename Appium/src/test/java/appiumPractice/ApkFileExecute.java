package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ApkFileExecute {
	
	public void verticalSwipe(){
		
		
	}

	public static void main(String[] args) {
		
		String path=System.getProperty("user.dir");
        //Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("BROWSER_NAME", "");
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "56f871e7"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("noReset", true);
		caps.setCapability("app", path+"\\File\\TheTestingWorld.apk");
		
		//Instantiate Appium Driver
		
		AppiumDriver<MobileElement> driver;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			System.out.println("Apps is installed successfully");
			
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
