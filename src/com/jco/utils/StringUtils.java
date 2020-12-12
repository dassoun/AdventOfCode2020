package com.jco.utils;

public class StringUtils {

	public static String padLeft(char charPad, String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append(charPad);
	    }
	    sb.append(inputString);

	    return sb.toString();
	}
	
	public static String replaceCharAt(String s, int pos, char c) {
		StringBuilder myString = new StringBuilder(s);
		myString.setCharAt(pos, c);
		
		return myString.toString();
	}
}
