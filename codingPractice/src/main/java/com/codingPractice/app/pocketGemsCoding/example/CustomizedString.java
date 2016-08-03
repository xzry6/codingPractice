package com.codingPractice.app.pocketGemsCoding.example;

public class CustomizedString implements StringModel {

	char[] arr;

	CustomizedString(String s) {
		arr = s.toCharArray();
	}

	@Override
	public char charAt(int index) {
		return arr[index];
	}

	@Override
	public void setCharAt(int index, char c) {
		arr[index] = c;
	}

	@Override
	public String substr(int beginIndex, int endIndex) {
		return String.valueOf(arr, beginIndex, endIndex - beginIndex);
	}
	
}


//Implement the following methods in O(1) time complexity
interface StringModel {

	char charAt(int index);

	void setCharAt(int index, char c);

	String substr(int beginIndex, int endIndex);

}
