package com.StrongerMe.generics;

import java.util.Date;

public class JavaUtility {
	/**
	 * This class contains java specific generic libraries.
	 * @author Shivaprasad
	 */
	/**
	 * Generate current system date.
	 * @return
	 */
	public static String getCurrentSystemDate()
	{
		Date date = new Date();
		String currentDate=date.toString();
		return currentDate.replace(" ", "_").replace(":", "_");	
	}
}
