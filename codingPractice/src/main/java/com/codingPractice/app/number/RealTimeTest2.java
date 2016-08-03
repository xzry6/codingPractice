package com.codingPractice.app.number;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RealTimeTest2 {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
         */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    static String parseLines(String[] lines) {
    		// Initialize a date list
    		List<Date> dateList = new ArrayList<Date>();
    		// Initialize a status list
    		List<String> statusList = new ArrayList<String>();
    		// Return if nothing is in the list
    		if(lines == null || lines.length == 0) return "";
   
    		// Format the date
    		try {
    			for(String line: lines) {
    				String[] strArr = line.split(" :: ");
    				SimpleDateFormat sdf = new SimpleDateFormat("(MM/dd/yyyy-HH:mm:ss)");
    				dateList.add(sdf.parse(strArr[0]));
    				statusList.add(strArr[1]);
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
   
    		// Calculate connecting time
    		double time = calculateConnectingTime(dateList, statusList);
    		// Format the value
        return (int)Math.floor(time*100)+"%";
    }

    private static double calculateConnectingTime(List<Date> dateList, List<String> statusList) {
    		// Total time
    		int totalTime = 0;
    		// Connecting time
		int connectingTime = 0;
		// Start index
		int index = 0;
		// Get the start index
		while(index < dateList.size() && 
			  !statusList.get(index).equals("START")) {
			index ++;
		}
		// Last connecting index
		int connectingIndex = -1;
		for(int i=index; i<dateList.size(); ++i) {
			String status = statusList.get(i);
			// If not connected yet and current status is `connected`
			if(connectingIndex == -1 && status.equals("CONNECTED")) {
				connectingIndex = i;
				continue;
			}
			// If already connected and current status is `disconnected`
			if(connectingIndex != -1 && status.equals("DISCONNECTED")) {
				connectingTime += dateList.get(i).getTime()
							   - dateList.get(connectingIndex).getTime();
				connectingIndex = -1;
				continue;
			}
			// If `shutdown`
			if(status.equals("SHUTDOWN")) {
				if(connectingIndex != -1) {
					connectingTime += dateList.get(i).getTime()
				    		           - dateList.get(connectingIndex).getTime();
				}
				totalTime += dateList.get(i).getTime()
						  - dateList.get(index).getTime();
				break;
			}
		}
		// Return a double value first
		return (double)connectingTime/totalTime;
    }
}
