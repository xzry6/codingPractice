package com.codingPractice.app.pocketGemsCoding.example.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParseJsonToDatabase {

	// Properties.
	private Config config;

	// Methods.

	/**
	 * This method parse a Json list.
	 * @param {List<JSONValue>} events - A list of Json value.
	 * @param {Config} config - Config file.
	 * @return {List<Row>} - A list of Row.
	 */
	List<Row> parseToDB(List<JSONValue> events, Config config) {
		this.config = config;

		List<Row> list = new ArrayList<Row>();
		for(JSONValue event:events) {
			list.add(parseRow(event));
		}

		return list;
	}


	/**
	 * This method read a row.
	 * @param {JSONValue} event - a Json event.
	 * @return {Row} - A row.
	 */
	private Row parseRow(JSONValue event) {
		Map<String, JSONValue> row = event.getAsMap();
		Map<String, JSONValue> data = row.get("data").getAsMap();
		Map<String, String> parsedMap = new HashMap<String, String>();

		Iterator<String> iterator = data.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = data.get(key).stringOf(config.get(key));
			parsedMap.put(key, value);
		}

		return new Row(data.get("type").toString(), parsedMap);
	}
}
