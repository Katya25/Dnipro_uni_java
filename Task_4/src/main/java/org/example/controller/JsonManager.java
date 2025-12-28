package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.University;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonManager {

	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public String toJson(University university) {
		return gson.toJson(university);
	}

	public University fromJson(String json) {
		return gson.fromJson(json, University.class);
	}

	public void writeToFile(Path path, University university) throws IOException {
		String json = toJson(university);
		Files.writeString(path, json);
	}

	public University readFromFile(Path path) throws IOException {
		String json = Files.readString(path);
		return fromJson(json);
	}
}