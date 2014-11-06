package com.github.marcelocure.searchengine.index;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.marcelocure.searchengine.domain.Person;
import com.github.marcelocure.searchengine.file.FileManager;
import com.github.marcelocure.searchengine.parser.JsonReader;

public class Indexer {
	
	private IndexWriter indexWriter;
	
	public void index() throws InvalidFormatException, IOException, GeneralSecurityException, URISyntaxException {
		createIndex();
		System.out.println("index created");
		List<File> files = new FileManager().getJsonFiles(new File("c:/Temp"));
		System.out.println(files.size() + "files collected");
		
		JsonReader jsonReader = new JsonReader();
		List<Person> people = new ArrayList<Person>();
		for (File file : files) {
			Person person = jsonReader.readJsonfromFS(file);
			people.add(person);
		}
		
		List<Document> documents = getDocuments(people);
		System.out.println(documents.size() + "documents created");
		indexWriter.addDocuments(documents);
		indexWriter.close();
		System.out.println("index closed");
	}
	
	private List<Document> getDocuments(List<Person> people) {
		List<Document> documents = new ArrayList<Document>();
		for (Person person : people) {
			Document doc = new Document();
			doc.add(new TextField("id", ""+person.getId(), Store.YES));
			doc.add(new TextField("nome", person.getNome(), Store.YES));
			doc.add(new TextField("cpf", person.getCpf(), Store.YES));
			doc.add(new TextField("logradouro", person.getLogradouro(), Store.YES));
			doc.add(new TextField("numero", ""+person.getNumero(), Store.YES));
			doc.add(new TextField("complemento", person.getComplemento(), Store.YES));
			doc.add(new TextField("telefoneResidencial", person.getTelefoneResidencial(), Store.YES));
			doc.add(new TextField("telefoneCelular", person.getTelefoneCelular(), Store.YES));
			documents.add(doc);
		}
		return documents;
	}

	private void createIndex() throws IOException {
		indexWriter = new IndexWriter(FSDirectory.open(getPath()),getIndexWriterConfig());
	}
	
	private IndexWriterConfig getIndexWriterConfig() {
		return new IndexWriterConfig(Version.LUCENE_45, new StandardAnalyzer(Version.LUCENE_45));
	}

	private File getPath() {
		return new File("c:/luceneindexes");
	}
}