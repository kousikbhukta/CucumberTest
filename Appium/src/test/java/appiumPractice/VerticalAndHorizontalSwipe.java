package appiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class VerticalAndHorizontalSwipe {

	AppiumDriver<MobileElement> driver;
	public void setup() throws MalformedURLException{
		
		String path=System.getProperty("user.dir");
        //Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		//caps.setCapability("BROWSER_NAME", "");
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "56f871e7"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("noReset", true);
		caps.setCapability("app", path+"\\File\\API Demos.apk");
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		driver= new AndroidDriver<MobileElement>(url, caps);
	}
	
	public void swipeHorizontal(){
		
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x=width/2;
		int startY = (int)(height*0.8);
		int endY = (int)(height*0.2);
		
		TouchAction ta = new TouchAction(driver);
//		ta.press(x, startY).waitAction(Duration.ofMillis(2000)).moveTo(x, endY).release().perform();
	}
	
	public void tearDown(){
		
		driver.quit();
	}
	
	public static void main(String[] args) throws MalformedURLException {

		VerticalAndHorizontalSwipe obj = new VerticalAndHorizontalSwipe();
		obj.setup();
		obj.swipeHorizontal();
		
	}

}
