package com.github.marcelocure.searchengine.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.github.marcelocure.searchengine.domain.Person;

public class DataParser {
	public List<Person> parseFile(String filePath) {
		List<String> dataList = readFile(filePath);
		return buildPersonList(dataList);
	}

	public List<String> readFile(String path) {
		List<String> data = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {
				data.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public List<Person> buildPersonList(List<String> dataList) {
		List<Person> people = new ArrayList<Person>();
		for (String data : dataList) people.add(buildPerson(data.split(";")));
		return people;
	}

	private Person buildPerson(String[] row) {
		return new Person(Integer.parseInt(row[0]), row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], row[7]);
	}
}