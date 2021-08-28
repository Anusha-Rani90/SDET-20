package com.vtiger.comcast.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNum=random.nextInt(1000);
		return randomNum;
	}
	
//	It is used to get system date
	
	public String getsystemDate() {
		Date date =new Date();
		String SystemDateAndTime = date.toString();
		return SystemDateAndTime;
	}
//	It is used to get syste date with yyyy_mm_dd format
	
	public String getSystemDateAndTimeYYYY_MM_DD() {
		Date date = new Date();
		String dateAndTime = date.toString();
		System.out.println(dateAndTime);
		String[] arr=dateAndTime.split("");
		
		String DD=arr[2];
		String YYYY=arr[5];
		int MM=date.getMonth()+1;
		
		String finalFormat = YYYY+"_"+MM+"_"+DD;
		return finalFormat;
		}
//	It is used to pass virtual key to operating system
	
	public void pressVirtualEnterKey() throws Throwable {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
