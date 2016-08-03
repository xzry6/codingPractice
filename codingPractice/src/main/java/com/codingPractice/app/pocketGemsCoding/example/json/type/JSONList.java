package com.codingPractice.app.pocketGemsCoding.example.json.type;

import java.util.ArrayList;
import java.util.List;

import com.codingPractice.app.pocketGemsCoding.example.json.JSONValue;

public class JSONList extends JSONType {

	private List<JSONValue> listValue;

	public JSONList(JSONValue value) {
		super(value);
		this.listValue = new ArrayList<JSONValue>();
		// TODO: Implementation.
	}

	public List<JSONValue> getList() {
		return this.listValue;
	}
}
