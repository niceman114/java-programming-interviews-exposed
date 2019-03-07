package com.wiley.javainterviewsexposed.chapter16;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileDictionary implements Dictionary {

    private final Set<String> words;

    @SuppressWarnings("unchecked") // readLines returns List, not List<String>
    public FileDictionary(final String dictionaryFilename) throws IOException {
        final List list = IOUtils.readLines(new FileInputStream(dictionaryFilename));
        words = new HashSet<>();
        words.addAll(list);
    }

    @Override
    public boolean validWord(String word) {
        return words.contains(word);
    }
}
