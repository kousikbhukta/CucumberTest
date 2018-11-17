package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrientationTest {

	AppiumDriver<MobileElement> driver;
	public void setup() throws MalformedURLException{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("BROWSER_NAME", "");
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "56f871e7"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
//		caps.setCapability("appPackage", "in.swiggy.android");
//		caps.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity");
		
		caps.setCapability("appPackage", "com.mxtech.videoplayer.ad");
		caps.setCapability("appActivity", "com.mxtech.videoplayer.ActivityAbout");
		
		//Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public void testRotate() throws InterruptedException{
		
		if(driver.getOrientation().equals("LANDSCAPE")){
			switchOrientation("PORTRAIT");
		}
		
		else{
			
			switchOrientation("LANDSCAPE");
		}
	}
	
	public void switchOrientation(String modeType) throws InterruptedException{
		
		ScreenOrientation currentOrientation = driver.getOrientation();
		System.out.println("Present orientation is "+currentOrientation);
		if(modeType.equalsIgnoreCase("LANDSCAPE")){
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		
		else if(modeType.equalsIgnoreCase("PORTRAIT")){
			
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		ScreenOrientation afterOrientation = driver.getOrientation();
		System.out.println("After rotate the screen "+afterOrientation);
		Thread.sleep(2000);
	}
	
	public void tearDown(){
		
		driver.quit();
		System.out.println("Closing the apps");
	}
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		OrientationTest obj = new OrientationTest();
		obj.setup();
		obj.testRotate();
		obj.tearDown();
	}

}
