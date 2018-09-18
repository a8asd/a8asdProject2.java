package com.agil8.examples.mocking;

public class FileWrapperTestDouble implements FileWrapperInterface
{
    public String FileWrittenTo;
    public String TextWrittenToFile;

    public String ReadAllText(String filename)
    {
        return "";
    }

    public void WriteAllText(String fileToWriteTo, String textToWrite)
    {
        FileWrittenTo = fileToWriteTo;
        TextWrittenToFile = textToWrite;
    }
}
