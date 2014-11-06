package com.github.marcelocure.searchengine.parser.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.github.marcelocure.searchengine.domain.Person;
import com.github.marcelocure.searchengine.parser.DataParser;

public class DataParserTest {
	@Test
	public void testBuildPersonList(){
		List<String> data = Arrays.asList("1;Amelia Dias;947.211.679-13;Tais Pereira;3762;;8642-4692;3259-4909",
										  "2;Gabriela Neves;508.537.331-73;Eng. Claudia Andrade;1836;cj. 1101;7380-1486;3929-9466",
										  "3;Marcos Silva;992.684.637-61;Cel. Bernardo Wilbur;5322;;8836-9009;6169-2904",
										  "4;Ana Parreira;665.869.796-91;Eng. Beatriz Pereira;9676;;9161-9951;5710-8531");
		DataParser dataParser= new DataParser();
		List<Person> people = dataParser.buildPersonList(data);
		assertEquals(people.size(), 4);
		assertEquals(people.get(0).getNome(), "Amelia Dias");
		assertEquals(people.get(3).getNome(), "Ana Parreira");
	}
	
	@Test
	public void testBuildPersonListEmptyDataList(){
		DataParser dataParser= new DataParser();
		List<Person> people = dataParser.buildPersonList(new ArrayList<String>());
		assertNotNull(people);
		assertEquals(people.size(), 0);
	}
}
