package com.agil8.examples.mocking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StarterLogger {
	private String status;

	public StarterLogger() {
	}

	public void save(String logMessage) {
		String textToWrite = "log: "+logMessage;
		try {
			Files.write(Paths.get("logfile.log"), textToWrite.getBytes());
		} catch (IOException exception) {
			setStatus("Error: exception thrown");
		}
	}

	public void setStatus(String string) {
		status = string;
	}

	public String getStatus() {
		return status;
	}
}
