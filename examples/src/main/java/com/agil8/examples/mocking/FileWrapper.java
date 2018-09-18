package com.agil8.examples.mocking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWrapper implements FileWrapperInterface {
	public String ReadAllText(String filename) {
		try {
			return new String(Files.readAllBytes(Paths.get(filename)));
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void WriteAllText(String fileToWriteTo, String textToWrite) {
		try {
			Files.write(Paths.get(fileToWriteTo), textToWrite.getBytes());
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
}
