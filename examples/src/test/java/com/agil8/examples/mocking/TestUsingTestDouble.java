package com.agil8.examples.mocking;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsingTestDouble
{
    @Test
    public void classUnderTestPrependsBeforeSaving()
    {
        FileWrapperTestDouble mockFileWrapper = new FileWrapperTestDouble();
        Logger classUnderTest = new Logger(mockFileWrapper);

        classUnderTest.save("1000 TSCO.L shares sold");

        assertEquals("log: 1000 TSCO.L shares sold", mockFileWrapper.TextWrittenToFile);
        assertEquals("logfile.log", mockFileWrapper.FileWrittenTo);
    }
}
