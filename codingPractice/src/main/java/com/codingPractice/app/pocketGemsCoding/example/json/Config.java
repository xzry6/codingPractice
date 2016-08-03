package com.codingPractice.app.pocketGemsCoding.example.json;

import java.util.Map;

public class Config {

	// Properties.
	private Map<String, String> map;

	// Methods.

	/**
	 * Constructor.
	 * @param {Map<String, String>} map - A matching map. ("session_id" : "long")
	 */
	public Config(Map<String, String> map) {
		this.map = map;
	}

	/**
	 * Read type.
	 * @param {String} key - Key in the map.
	 * @returns {String} type - Json type.
	 */
	public String get(String key) {
		return map.get(key);
	}
}
