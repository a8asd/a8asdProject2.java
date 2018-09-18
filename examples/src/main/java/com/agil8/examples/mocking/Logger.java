package com.agil8.examples.mocking;

public class Logger {
	private FileWrapperInterface file;
	private String status;

	public Logger(FileWrapperInterface fileWrapper) {
		file = fileWrapper;
	}

	public void save(String textToSave) {
		try {
			file.WriteAllText("logfile.log", "log: " + textToSave);
		} catch (Exception exception) {
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
