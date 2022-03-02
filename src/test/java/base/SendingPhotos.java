package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

public class SendingPhotos {
	public AndroidDriver driver;
	
	private static By allowBtn=By.id("com.android.packageinstaller:id/permission_allow_button");
	private static By doneBtn= By.id("done_button");
	private static By okBtn= By.id("Photo taken at 21 Jan 2022 3:39:53 p.m..");
	private static By photo= By.xpath("(//android.view.View[ccontains(@content-desc='Photo taken')]");
	
	
	
	File classPath, imageDir, img;
	
	
	

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "4TE0216714003365");
        capabilities.setCapability("appPackage", "com.google.android.apps.photos");
        capabilities.setCapability("appActivity", ".home.HomeActivity");
        
        

        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Test
    public void send_Photo() throws IOException {

    	classPath= new File(System.getProperty("user.dir"));
    	imageDir= new File(classPath, "/resources/images");
    	img= new File(imageDir.getCanonicalFile(),"Screenshot.png");
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);          
        wait.until(ExpectedConditions.presenceOfElementLocated(allowBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(doneBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(okBtn)).click();
        
        String Android_Photo_Path = "mnt/sdcard/Pictures";
        driver.pushFile(Android_Photo_Path + "/" + img.getName(), img);
        wait.until(ExpectedConditions.numberOfElementsToBe(photo, 1));
    	
       
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}


