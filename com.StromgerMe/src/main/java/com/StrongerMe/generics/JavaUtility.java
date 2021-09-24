package com.StrongerMe.generics;

import java.util.Date;
import java.util.Random;

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
	/**
	*   its used to generate the integer RanDom number with in the boundary of 0 to 10000
	* @return intData
	*/
	public int getRanDomNumber() {
		Random ranDom = new Random();
		int ranDomNum = ranDom.nextInt(10000);
		return ranDomNum;
	}
}
