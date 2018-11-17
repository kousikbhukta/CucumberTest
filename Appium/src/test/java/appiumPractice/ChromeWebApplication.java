package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeWebApplication {

	//private static final String MobileElement = null;
	AppiumDriver<MobileElement> driver;
	public void setup(){
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		cap.setCapability("deviceName", "Note 3");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");

	//	cap.setCapability("app", "chrome");
//		cap.setCapability("appPackage", "com.android.chrome");
//		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		try {
			driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void testcase(){
		driver.get("http://www.google.com");
		driver.findElementByXPath("//input[@type='search']").sendKeys("puma");
		driver.findElementByClassName("Tg7LZd").click();
	}
	
	public static void main(String[] args) {

		ChromeWebApplication obj = new ChromeWebApplication();
		obj.setup();
		obj.testcase();
		
	}

}
