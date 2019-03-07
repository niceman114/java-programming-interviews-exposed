package com.wiley.javainterviewsexposed.chapter09;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class ExpectingExceptions {

    @Test(expected = NoSuchFileException.class)
    public void expectException() throws IOException {
        Files.size(Paths.get("/tmp/non-existent-file.txt"));
    }
}
