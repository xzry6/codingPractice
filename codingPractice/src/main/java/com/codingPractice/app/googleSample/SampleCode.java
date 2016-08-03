package com.codingPractice.app.googleSample;

import java.util.Arrays;
import java.util.Stack;

public class SampleCode {
	private int[] duplicateNumber(int[] number) {
		if(number == null || number.length == 0) return number;
		int max = number[0];
		int position = 0;
		for(int i=1; i<number.length; ++i) {
			if(number[i] < number[i-1])
				break;
			max = number[i];
			position = i;
		}
		System.out.println("max is: "+max);
		System.out.println("position is: "+position);
		int[] newNumber = new int[number.length+1];
		for(int i=0; i<newNumber.length; ++i) {
			if(i == position) {
				newNumber[i] = max;
			} else if(i < position) {
				newNumber[i] = number[i];
			} else {
				newNumber[i] = number[i-1];
			}
		}
		return newNumber;
	}
	
	private int[] duplicateNumber2(int[] number) {
		if(number == null || number.length == 0) return new int[0];

		int[] newNumber = new int[number.length-1];
		int lastDup = -1;
		int lastDupPos = -1;
		boolean isDup = false;
		for(int i=1; i<number.length; ++i) {
			if(isDup && number[i] > number[i-1])
				break;
			if(number[i] == number[i-1]) {
				isDup = true;
				lastDup = number[i];
				lastDupPos = i;
			} else {
				isDup = false;
			}
		}
		if(lastDup == -1) return number;
		for(int i = 0; i<newNumber.length; ++i) {
			if(i < lastDupPos) newNumber[i] = number[i];
			else newNumber[i] = number[i+1];
		}
		return newNumber;
	}

	private static void testDuplicateNumber() throws AssertionError {
		SampleCode sampleCode = new SampleCode();
		int[] number = {1};
		int[] newNumber = {1,1,1,2,3,3,3,2,4,6,5,2};
		System.out.println(Arrays.toString(sampleCode.duplicateNumber(number)));
		assert sampleCode.duplicateNumber(number).equals(newNumber) :
			"duplicateNumber(number) should equals to newNumber";
	}

	private static void testDuplicateNumber2() throws AssertionError{
		SampleCode sampleCode = new SampleCode();
		int[] number = {1,2,3,4,4,3,2,1};
		int[] newNumber = sampleCode.duplicateNumber2(number);
		System.out.println(Arrays.toString(newNumber));
		assert newNumber != null : "duplicateNumber2 should not be null";
	}
	
	private int maxLengthOfDirectory(String directory) {
		if(directory == null || directory.length() == 0) return 0;
		String[] directoryArray = directory.split("\n");
		Stack<String> stack = new Stack<String>();
		int maxLength = 0;
		int curLength = 0;
		int curDepth = -1;
		for(int i=0; i< directoryArray.length; ++i) {
			String string = directoryArray[i];
			if(checkFormat(string)) {
				int depth = checkSpaces(string);
				if(depth == curDepth) {
					curLength += string.length() - stack.pop().length();
					stack.push(string);
				} else if (depth > curDepth) {
					curLength += string.length()-depth+1;
					stack.push(string);
					curDepth = depth;
				} else if(depth < curDepth) {
					curLength -= (stack.pop().length()+1); 
					curDepth = checkSpaces(stack.peek());
					i--;
				}
				maxLength = Math.max(maxLength, curLength);
				if(curLength==maxLength){
                    for(String ss: stack){
                        System.out.print("\\"+ss);
                    }
                    System.out.println();
                }
				System.out.println("current string is "+string);
				System.out.println("max length is "+maxLength);
			}
		}
		return maxLength == 0 ? maxLength : maxLength-1;
	}
	
	private static void testMaxLengthOfDirectory() {
		SampleCode sampleCode = new SampleCode();
		String directory = "dir\n"
						  +" ddir.jpeg\n"
						  +" ddir\n"
						  +"  ddir.png\n"
						  +"  ddir.jpeg\n"
						  +" ddir2\n"
						  +"  d.exe";
		System.out.println(sampleCode.maxLengthOfDirectory(directory));
	}
	private int checkSpaces(String string) {
		int number = 0;
		for(int i=0; i<string.length(); ++i) {
			if(string.charAt(i) != ' ') break;
			number++;
		}
		return number;
	}
	private boolean checkFormat(String string) {
		String[] splitString = string.split("\\.");
		if(splitString.length <= 1) return true;
		String format = splitString[splitString.length-1];
		if(format.equals("jpeg") || format.equals("png") || format.equals("gif"))
			return true;
		return false;
	}
	
	private int[] int2IntArray(int number) {
		int copyOfNumer = number;
		int count = 0;
		while(copyOfNumer != 0) {
			copyOfNumer /= 10;
			count ++;
		}
		int[] intArray = new int[count];
		count = intArray.length-1;
		while(number != 0) {
			intArray[count--] = number%10;
			number = number/10;
		}
		return intArray;
	}
	
	private int intArray2Int(int[] intArray) {
		int number = 0;
		for(int i=0; i<intArray.length; ++i) {
			number = number*10+intArray[i];
		}
		return number;
	}
	
	public static void main(String args[]) {
//		try {
//			SampleCode.testDuplicateNumber();
//			SampleCode.testDuplicateNumber2();
//			SampleCode.testMaxLengthOfDirectory();
//		} catch (AssertionError e) {
//			System.out.println(e.getMessage());
//		}
		String aa = "aa";
		String ab = "ab";
		
		System.out.println(aa.compareTo(ab));
	}
	
	
}
