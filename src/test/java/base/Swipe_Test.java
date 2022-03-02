package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Swipe_Test {

	
	AppiumDriver driver;
	public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
    	//Letting which application to run
    			File f =new File("src");
    			File fs = new File(f,"ApiDemos-debug.apk");
    			
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "4TE0216714003365");
        //caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        caps.setCapability("appPackage	", "io.appium.android.apis");
        caps.setCapability("appActivity	", "io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
    
    private void scrollDown() {
    	Dimension dimension= driver.manage().window().getSize();
    	int scrollStart= (int) (dimension.getHeight() *0.8);  
    	int scrollEnd= (int) (dimension.getHeight() * 0.1);
    	
    	actions= new AndroidTouchAction(driver)
    			.press(PointOption.point(0, scrollStart))
    			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
    			.moveTo(PointOption.point(0, scrollEnd))
    			.release()
    			.perform();
    	}

    @Test
    public void SwipeTest() throws InterruptedException {
        // code
    	
    	scrollDown();
    	//Thread.sleep(3000);
        AndroidElement views= 
        		(AndroidElement) driver.findElementByAccessibilityId("Views");
        
        //Tap
        actions= new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();
        Thread.sleep(3000);
        
        
        AndroidElement gallery= (AndroidElement) driver.findElementByAccessibilityId("Gallery");
        actions.tap(ElementOption.element(gallery)).perform();
        Thread.sleep(3000);
        
        AndroidElement PhoneOne= (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        actions.tap(ElementOption.element(PhoneOne)).perform();
        Thread.sleep(3000);
        
        AndroidElement pic1= 
        		(AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        actions.press(ElementOption.element(pic1))
        .waitAction()
        .moveTo(PointOption.point(-20,210)).release().perform();
        
        
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}



