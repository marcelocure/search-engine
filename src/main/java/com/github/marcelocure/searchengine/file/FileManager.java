package com.github.marcelocure.searchengine.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	public List<File> getJsonFiles(File path) {
		List<File> files = new ArrayList<File>();
		File items[] = path.listFiles();
		System.out.println(items.length + " files found");

		for (File f : items)
			if (f.getName().endsWith(".json")) files.add(f);

		return files;
	}
}