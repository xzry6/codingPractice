package com.codingPractice.app.pocketGemsCoding.example.json.type;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public class JSONString extends JSONType {

	private String stringValue;

	public JSONString(JSONValue value) {
		super(value);
		this.stringValue = value.getValue();
	}

	public String getString() {
		return this.stringValue;
	}
}
