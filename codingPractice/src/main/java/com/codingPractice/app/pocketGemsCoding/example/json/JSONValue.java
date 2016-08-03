package com.codingPractice.app.pocketGemsCoding.example.json;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.codingPractice.app.pocketGemsCoding.example.json.type.JSONDate;
import com.codingPractice.app.pocketGemsCoding.example.json.type.JSONList;
import com.codingPractice.app.pocketGemsCoding.example.json.type.JSONLong;
import com.codingPractice.app.pocketGemsCoding.example.json.type.JSONMap;
import com.codingPractice.app.pocketGemsCoding.example.json.type.JSONString;

public class JSONValue {

	// Properties.
	private String value;

	// Constructor.
	public JSONValue(String value) {
		this.value = value;
	}

	// Methods.

	// Get string value.
	public String getValue() {
		return this.value;
	}

	// String of a type.
	public String stringOf(String type) {
		switch(type) {
		case "date":
			return getAsDate().toString();
		case "list":
			return getAsList().toString();
		case "long":
			return getAsLong().toString();
		case "map":
			return getAsMap().toString();
		case "string":
			return getAsString();
		}
		return "null";
	}

    // Read as Date.
    public Date getAsDate() {
    		return new JSONDate(this).getDate();
    }

    // Read as List.
    public List<JSONValue> getAsList() {
    		return new JSONList(this).getList();
    }

    // Read as Long.
    public Long getAsLong() {
    		return new JSONLong(this).getLong();
    }

    // Read as Map.
    public Map<String, JSONValue> getAsMap() {
    		return new JSONMap(this).getMap();
    }

	// Read as String.
    public String getAsString() {
    		return new JSONString(this).getString();
    }
}
