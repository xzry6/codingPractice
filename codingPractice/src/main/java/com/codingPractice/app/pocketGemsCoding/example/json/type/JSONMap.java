package com.codingPractice.app.pocketGemsCoding.example.json.type;

import java.util.HashMap;
import java.util.Map;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public class JSONMap extends JSONType {

	private Map<String, JSONValue> mapValue;

	public JSONMap(JSONValue value) {
		super(value);
		this.mapValue = new HashMap<String, JSONValue>();
		// TODO: Implementation.
	}

	public Map<String, JSONValue> getMap() {
		return this.mapValue;
	}
}
