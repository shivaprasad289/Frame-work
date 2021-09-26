package com.StrongerMe.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * @author Shivaprasad
 */
public class FileUtility {	
	
	public String propertyFilePath;
/**
 *  This method used to read data from properties and return the value based on key specified.
 * @param propertyFilepath
 * @param key
 * @return
 * @throws IOException
 */
	
	public FileUtility(String propertyFilePath) {
		this.propertyFilePath = propertyFilePath;
	}
	public String getPropertyStringValue(String key) throws IOException
	{
		FileInputStream file = new FileInputStream(propertyFilePath);
		Properties p = new Properties();
		p.load(file);
		file.close();
		return p.getProperty(key);
	}
}
