package com.codingPractice.app.pocketGemsCoding.example.json;

import java.util.Map;

public class Row {
	// Properties.
    String tableName;
    Map<String, String> map;

    public Row(String tableName, Map<String, String> map) {
    		this.tableName = tableName;
    		this.map = map;
    }
}
