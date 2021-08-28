package com.vtiger.comcast.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	/**
	@author Anusha Rani
	 * @throws Throwable 
	**/
//	It is used to read the data from the commonData.properties based on the key that we pass
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("./data/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}

}
