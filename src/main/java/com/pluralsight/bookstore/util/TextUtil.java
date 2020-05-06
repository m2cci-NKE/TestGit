package com.pluralsight.bookstore.util;

public class TextUtil {

	public String santize(String textToSantize) {
		
		return textToSantize.replaceAll("\\s+", " ");
		
	}
	
}
