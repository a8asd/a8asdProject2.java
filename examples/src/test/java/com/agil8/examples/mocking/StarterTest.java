package com.agil8.examples.mocking;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class StarterTest {
	@Test
	public void classUnderTestPrependsBeforeSaving() throws Exception {
		StarterLogger logger = new StarterLogger();
		logger.save("the message");
		String contents = new String(Files.readAllBytes(Paths.get("logfile.log")));
		assertEquals("log: the message",new String(contents));
	}
}
