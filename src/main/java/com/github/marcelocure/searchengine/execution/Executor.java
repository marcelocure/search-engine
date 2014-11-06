package com.github.marcelocure.searchengine.execution;

import java.util.List;

import com.github.marcelocure.searchengine.domain.Person;
import com.github.marcelocure.searchengine.index.Indexer;
import com.github.marcelocure.searchengine.parser.DataParser;
import com.github.marcelocure.searchengine.parser.JsonGenerator;

public class Executor {
	public static void main(String[] args) {
		DataParser dataParser = new DataParser();
		List<Person> people = dataParser.parseFile("c:/Temp/data.txt");
		JsonGenerator jsonGenerator = new JsonGenerator();
		jsonGenerator.createJson(people);
		Indexer indexer = new Indexer();
		try {
			indexer.index();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}