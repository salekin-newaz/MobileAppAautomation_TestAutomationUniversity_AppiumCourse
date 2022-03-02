package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TasksListPage extends PageBase{

	public TasksListPage(AppiumDriver appiumDriver) {
		super(appiumDriver);
		
	}
	
	@AndroidFindBy(id="com.example.android.notepad:id/menu_create_note")
	MobileElement addTaskBtn;
	
	public void clickAddTaaskBttn() {
		click(addTaskBtn);
	}
	
	
	
	

}
