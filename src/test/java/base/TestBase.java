package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static AppiumDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		// Letting which application to run
		// File f =new File("src");
		// File fs = new File(f,"selendroid-test-app-0.17.0.apk");

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("deviceName", "4TE0216714003365");
		// caps.setCapability("app", System.getProperty("user.dir") +
		// "/apps/ApiDemos.apk");
		//caps.setCapability("autoGrantPermissions", true);
		// caps.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		caps.setCapability("appPackage	", "com.example.android.notepad");
		caps.setCapability("appActivity	", "com.example.android.notepad.NoteFoldActivity");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
