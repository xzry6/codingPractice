package com.codingPractice.app.pocketGemsCoding;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class RealTimeTest {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }

    static List<String> parseFile(String filename)
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

        return parseLines(allLines);
    }

    static List<String> parseLines(List<String> lines) {
        /*
         * 
         *  Your code goes here
         *  
         */
        List<String> paths = new ArrayList<String>();
        // Return if original list is empty
        if(lines == null || lines.size() == 0) {
            return paths;
        }
        // Get start and end of the graph
        char[] header = lines.remove(0).toCharArray();
        char start = header[0];
        System.out.println("start is "+ start);
        char end = header[header.length-1];
        System.out.println("end is "+ end);
        // Get a linked map of the graph
        Map<Character, List<Character>> map = parseToMap(lines);
        // Create a hash set for recording passed states
        Set<Character> set = new HashSet<Character>();
        set.add(start);
     // Backtrack and add path
        backtrack(start+"", end, set, map, paths);
        // Return results
        return paths;
    }

    // This method parse a list and returns a linked map
    private static Map<Character, List<Character>> parseToMap(List<String> list) {
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        for(String string: list) {
            String[] strArr = string.trim().split(" : ");
            List<Character> charList = new ArrayList<Character>();
            char[] charArr = strArr[1].toCharArray();
            for(char c: charArr) {
                if(c == ' ') { continue; }
                charList.add(c);
            }
            System.out.println("character is "+ strArr[0].charAt(0));
            System.out.println("char list is "+ charList);
            map.put(strArr[0].charAt(0), charList);
        }
        return map;
    }

    // This method backtrack and create the paths list
    private static void backtrack(String currentPath,
                                  char destination,
                                  Set<Character> set,
                                  Map<Character, List<Character>> map,
                                  List<String> paths) {
    		System.out.println("current path is "+ currentPath);
        // Get current state
        char currentState = currentPath.charAt(currentPath.length()-1);
        // Return if reach at destination
        if(currentState == destination) {
        		System.out.println("add one path");
            paths.add(currentPath);
            return;
        }
        // Get the neighbors from map
        List<Character> neighbors = map.get(currentState);
        if(neighbors == null) {
        		return;
        }
        for(char neighbor: neighbors) {
            // Continue if already been the state
            if(set.contains(neighbor)) { continue; }
            // Add to current path and recursive if never been the state
            currentPath += neighbor;
            set.add(neighbor);
            System.out.println("add "+ neighbor);
            backtrack(currentPath, destination, set, map, paths);
            // Remove status when finished
            currentPath = currentPath.substring(0, currentPath.length()-1);
            set.remove(neighbor);
            System.out.println("remove "+ neighbor);
        }
    }
}
                                                        
