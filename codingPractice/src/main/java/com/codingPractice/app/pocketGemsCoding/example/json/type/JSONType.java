package com.codingPractice.app.pocketGemsCoding.example.json.type;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public abstract class JSONType {

	// Properties.
	protected JSONValue value;

	/*
	 * Constructor.
	 * @param {JSONValue} value - Json value passed into type.
	 */
	public JSONType(JSONValue value) {
		this.value = value;
	}
}
