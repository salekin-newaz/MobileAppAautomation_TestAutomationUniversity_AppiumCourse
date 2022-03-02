package testCases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Android_Hybrid_App_Test;
import io.appium.java_client.AppiumDriver;
import utilities.JsonReader;

public class HybridApp_TestCase_001 extends Android_Hybrid_App_Test{

	@DataProvider(name = "tasks data")
    public Object[][] passData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        return JsonReader.getJSONdata
                (System.getProperty("user.dir") + "/data/data.json"
                        , "Data", 1);
    }

    @Test(dataProvider = "tasks data")
    public void HybridTest(String TaskName) throws InterruptedException {
		//public AppiumDriver driver;
		 WebDriverWait wait = new WebDriverWait(driver,10);
	        wait.until(ExpectedConditions.presenceOfElementLocated(chromeBtn)).click();
	        Thread.sleep(3000);
	        switchToWebView();
	        WebElement nameInput = driver.findElement(By.className("android.widget.EditText"));
	        nameInput.clear();
	        Thread.sleep(3000);
	        //String name = "Moataz Nabil";
	        nameInput.sendKeys(TaskName);
	        Thread.sleep(3000);
	        driver.context("NATIVE_APP");
	        driver.findElement(gotoHomeBtn).click();
	        Thread.sleep(3000);
		
		
		
    }
	
	
}
