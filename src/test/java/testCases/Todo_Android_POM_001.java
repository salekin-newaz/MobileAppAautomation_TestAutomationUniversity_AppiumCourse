package testCases;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.CreateTaskPage;
import pageObjects.TasksListPage;

public class Todo_Android_POM_001 extends TestBase{

	CreateTaskPage createTaskPage;
	TasksListPage tasksListPage;
	
	@Test
	public void test_aadd_task() throws MalformedURLException, InterruptedException {
		setUp();
		tasksListPage= new TasksListPage(driver);
		createTaskPage= new CreateTaskPage(driver);
		tasksListPage.clickAddTaaskBttn();
		Thread.sleep(3000);
		createTaskPage.enterTaskName("Hello, this is Md Salekin Newaz");
		Thread.sleep(3000);
		createTaskPage.clickSaveBtnt();
		Thread.sleep(3000);
		
		
	}
	
}
