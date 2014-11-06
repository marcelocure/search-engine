package com.github.marcelocure.searchengine.parser;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.marcelocure.searchengine.domain.Person;

public class JsonReader {
	public Person readJsonfromFS(File file) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(file, Person.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
