package com.vtiger.comcast.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
	public void onTestFailure(ITestResult result) {
		
	
	String res = result.getMethod().getMethodName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
	File srcFile=edriver.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(srcFile, new File("./screenShot/"+res+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
