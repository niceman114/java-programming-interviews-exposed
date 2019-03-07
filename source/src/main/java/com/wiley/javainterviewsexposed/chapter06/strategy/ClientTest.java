package com.wiley.javainterviewsexposed.chapter06.strategy;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ClientTest {

    @Test
    public void useConsoleLogging() {
        final Client c = new Client(new ConsoleLogging());
        c.doWork(32);
    }

    @Test
    public void useFileLogging() throws IOException {
        final File tempFile = File.createTempFile("test", "log");
        final Client c = new Client(new FileLogging(tempFile));
        c.doWork(41);
        c.doWork(42);
        c.doWork(43);

        final BufferedReader reader
                = new BufferedReader(new FileReader(tempFile));
        assertEquals("Even number: 42", reader.readLine());
        assertEquals(-1, reader.read());
    }

    @Test
    public void useMockLogging() {
        final Logging mockLogging = mock(Logging.class);
        final Client c = new Client(mockLogging);
        c.doWork(1);
        c.doWork(2);
        verify(mockLogging).write("Even number: 2");
    }
}
