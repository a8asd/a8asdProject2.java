package com.agil8.examples.mocking;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsingSelfShunt implements FileWrapperInterface
{
    private String fileWrittenTo;
    private String textWrittenToFile;

    @Test
    public void classUnderTestPrependsBeforeSaving()
    {
        Logger classUnderTest = new Logger(this);

        classUnderTest.save("1000 TSCO.L shares sold");

        assertEquals("log: 1000 TSCO.L shares sold", textWrittenToFile);
        assertEquals("logfile.log", fileWrittenTo);
    }

    public String ReadAllText(String filename)
    {
        return "";
    }

    public void WriteAllText(String fileToWriteTo, String textToWrite)
    {
        fileWrittenTo = fileToWriteTo;
        textWrittenToFile = textToWrite;
    }
}