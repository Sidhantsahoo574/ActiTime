package com.actitime.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generics.ListnersImplementation.class)
public class CustomerModule extends BaseClass {
	
	@Test
	public void testCreateCustomer() throws IOException, InterruptedException
	{
		Reporter.log("testCreateCustomer",true);
		FileLib f=new FileLib();
		String CustomerName = f.getExcelData("Sheet1", 1, 1);
		String CustomerDesc = f.getExcelData("Sheet1", 1, 2);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerBtn().click();
		t.getCustomerNameTbx().sendKeys(CustomerName);
		t.getCustomerDescriptionTbx().sendKeys(CustomerDesc);
		t.getSelectCustomerDD().click();
		t.getOurCompany().click();
		t.getCreateCustomerBtn().click();
		Thread.sleep(0);
		String actualText = t.getActualCustomer().getText();
		Assert.assertEquals(actualText,CustomerName );
		
		
		
	}

}
