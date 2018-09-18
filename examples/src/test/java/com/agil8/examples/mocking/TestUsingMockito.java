package com.agil8.examples.mocking;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class TestUsingMockito
{
    @Test
    public void classUnderTestPrependsBeforeSaving()
    {
        FileWrapperInterface mockFileWrapper = mock(FileWrapperInterface.class);
        Logger classUnderTest = new Logger(mockFileWrapper);

        classUnderTest.save("1000 TSCO.L shares sold");

        verify(mockFileWrapper).WriteAllText("logfile.log","log: 1000 TSCO.L shares sold");
    }
    
    @Test
    public void exceptionIsHandledCorrectly(){
    	FileWrapperInterface mockFileWrapper = mock(FileWrapperInterface.class);
    	doThrow(new RuntimeException()).when(mockFileWrapper).WriteAllText(anyString(),anyString());

    	Logger classUnderTest = new Logger(mockFileWrapper);

    	classUnderTest.save("1000 TSCO.L shares sold");
		assertEquals("Error: exception thrown", classUnderTest.getStatus());
    }
}
