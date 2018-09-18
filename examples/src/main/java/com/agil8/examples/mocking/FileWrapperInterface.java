package com.agil8.examples.mocking;

public interface FileWrapperInterface
{
    String ReadAllText(String filename);
    void WriteAllText(String fileToWriteTo, String textToWrite);
}
