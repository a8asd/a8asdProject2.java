package com.agil8.examples.mocking;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsingFileWrapper {
	@Test
    public void classUnderTestPrependsBeforeSaving()
    {
        FileWrapperInterface fileWrapper = new FileWrapper();
        Logger classUnderTest = new Logger(fileWrapper);

        classUnderTest.save("1000 TSCO.L shares sold");

        assertEquals("log: 1000 TSCO.L shares sold", fileWrapper.ReadAllText("logfile.log"));
    }

}
