package pageObjects;

import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateTaskPage extends PageBase{
	public CreateTaskPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		
	}
	
	@FindBy(id="note_content_container_scrollview")
	MobileElement taskNametxt;
	
	@FindBy(id="android:id/icon2")
	MobileElement saveBtn;

	
	public void enterTaskName(String taskName) {
		clear(taskNametxt);
		sendText(taskNametxt,taskName);
	}
	
	public void clickSaveBtnt() {
		click(saveBtn);
	}
}
