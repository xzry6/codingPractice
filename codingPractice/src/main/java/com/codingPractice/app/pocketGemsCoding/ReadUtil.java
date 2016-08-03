package com.codingPractice.app.pocketGemsCoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadUtil {
	// Read a file and turn it to arraylist
	public static List<String> readCSV(String fileName) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String word = null;
			while((word = reader.readLine()) != null) {
				list.add(word);
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
