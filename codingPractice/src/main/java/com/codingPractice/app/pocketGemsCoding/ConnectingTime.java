package com.codingPractice.app.pocketGemsCoding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnectingTime {
	public double connectingTime(List<String> list) throws ParseException {
		// Initialize a date list
		List<Date> dateList = new ArrayList<Date>();
		// Initialize a status list
		List<String> statusList = new ArrayList<String>();
		// Return if nothing is in the list
		if(list == null || list.size() == 0) return 0;
		
		for(String line: list) {
			String[] strArr = line.split(" :: ");
			SimpleDateFormat sdf = new SimpleDateFormat("(MM/dd/yyyy-HH:mm:ss)");
			dateList.add(sdf.parse(strArr[0]));
			statusList.add(strArr[1]);
		}

		int totalTime = 0;
		int connectingTime = 0;
		int index = 0;
		while(index<list.size() && !statusList.get(index).equals("START")) {
			index ++;
		}
		int connectingIndex = -1;
		for(int i=index; i<list.size(); ++i) {
			String status = statusList.get(i);
			if(connectingIndex == -1 && status.equals("CONNECTED")) {
				connectingIndex = i;
				continue;
			}
			if(connectingIndex != -1 && status.equals("DISCONNECTED")) {
				connectingTime += dateList.get(i).getTime()
							    - dateList.get(connectingIndex).getTime();
				connectingIndex = -1;
				continue;
			}
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
		System.out.println("connecting time is: " + connectingTime);
		System.out.println("total time is: " + totalTime);
		return (double)connectingTime/totalTime;
	}

	public static void main(String[] args) {
		ConnectingTime ct = new ConnectingTime();
		List<String> list = new ArrayList<String>();
		list.add("(02/03/2002-14:00:00) :: START");
		list.add("(02/03/2002-14:00:00) :: CONNECTED");
		list.add("(02/03/2002-14:08:00) :: DISCONNECTED");
		list.add("(02/03/2002-14:10:00) :: CONNECTED");
		list.add("(02/03/2002-14:15:00) :: SHUTDOWN");
		try {
			System.out.println(ct.connectingTime(list));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
