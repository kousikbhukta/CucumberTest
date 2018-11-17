package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class StartAppiumServerByJava {

	AppiumDriverLocalService service;
	AppiumDriver<MobileElement> driver;
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setup() throws MalformedURLException{
		
		service= AppiumDriverLocalService.buildDefaultService();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Redmi Note 3");
		cap.setCapability("appPackage", "com.act.mobile.apps");
		cap.setCapability("appActivity", "com.act.mobile.apps.SplashActivity");
		//driver=new AndroidDriver<MobileElement>(service.getUrl(), cap);
		
		driver= new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}
	
	public void tearDown(){
		
		driver.quit();
		service.stop();
	}
	
	
	public static void main(String[] args) throws MalformedURLException {

		StartAppiumServerByJava obj = new StartAppiumServerByJava();
		
		obj.setup();
		obj.tearDown();
	}

}
