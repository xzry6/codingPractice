package com.codingPractice.app.pocketGemsCoding.example.json.type;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public class JSONLong extends JSONType {

	private Long longValue;

	public JSONLong(JSONValue value) {
		super(value);
		this.longValue = Long.parseLong(value.getValue());
	}

	public Long getLong() {
		return this.longValue;
	}
}
