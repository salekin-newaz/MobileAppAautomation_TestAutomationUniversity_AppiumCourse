package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.clipboard.HasClipboard;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class ClipBoard_Test {

	//public AppiumDriver driver;
	private AndroidDriver<WebElement> driver;
	public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
    	//Letting which application to run
    			File f =new File("src");
    			File fs = new File(f,"selendroid-test-app-0.17.0.apk");
    			
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "6.0");
        caps.setCapability("deviceName", "4TE0216714003365");
        //caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
        caps.setCapability("appPackage	", "io.selendroid.testapp");
        caps.setCapability("appActivity	", "io.selendroid.testapp.HomeScreenActivity");
        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), caps);
    }
    
    
    
    @Test
    public void Scroll_Test() throws InterruptedException {
        // code
    	
    	 String text = "Hello TAU";
         driver.setClipboardText(text);
         MobileElement nameTxt = (MobileElement) driver.findElementByAccessibilityId("my_text_fieldCD");
         nameTxt.clear();
         nameTxt.sendKeys(driver.getClipboardText());
         Assert.assertEquals(text, nameTxt.getText());
        
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}


	
