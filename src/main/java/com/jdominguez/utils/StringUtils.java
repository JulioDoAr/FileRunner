package com.jdominguez.utils;

import java.text.MessageFormat;

public class StringUtils {
	
	/** 
	 * Format the chain with format "text {0} text {1}..." 
	 */
	public static String format (String string, Object ... params) {       
	    return new MessageFormat(string).format(params);
	}
	
	/**
	 * Check if the string is in the list
	 */
	public static boolean in(String input, String[] list) {
		for (String word : list) {
			if (word.equals(input)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if the string is contained in any element of the list
	 */
	public static boolean inContained(String input, String[] list) {
		for (String word : list) {
			if (input.contains(word)) {
				return true;
			}
		}
		return false;
	}
}
