package com.codingPractice.app.pocketGemsCoding.example.json.type;

import java.util.Date;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public class JSONDate extends JSONType {

	private Date dateValue;

	public JSONDate(JSONValue value) {
		super(value);
		this.dateValue = new Date(value.getValue());
	}

	public Date getDate() {
		return this.dateValue;
	}
}
