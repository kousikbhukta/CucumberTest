package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestInChrome {

	
	AppiumDriver<MobileElement> driver;
	@Test
	
	public void setup() throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("udid", "7baac4c1");
		cap.setCapability("platformName", "Android");
		cap.setCapability("plaformVersion", "8.1.0");
		cap.setCapability("deviceName", "Redmi Note 5 Pro");
		cap.setCapability("appPackage", "com.act.mobile.apps");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.1.1:4723/wb/hub"), cap);
		System.out.println("Apps is launched");
		
	}
	
	
}
