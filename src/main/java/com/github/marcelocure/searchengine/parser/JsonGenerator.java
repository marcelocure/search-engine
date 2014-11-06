package com.github.marcelocure.searchengine.parser;

import java.io.File;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.github.marcelocure.searchengine.domain.Person;

public class JsonGenerator {
	public void createJson(List<Person> people){
		ObjectMapper mapper = new ObjectMapper();
		for (Person person : people) {
			try {
				mapper.writeValue(new File(buildFileName(person)), person);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private String buildFileName(Person person) {
		return "c:\\Temp\\"+person.getId()+".json";
	}
}