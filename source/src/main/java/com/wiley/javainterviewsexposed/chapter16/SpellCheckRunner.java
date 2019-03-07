package com.wiley.javainterviewsexposed.chapter16;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SpellCheckRunner {

    public static void main(String[] args) throws IOException {
        if(args.length < 1) {
            System.err.println("Usage java SpellCheckRunner <file_to_check>");
            System.exit(-1);
        }

        final Dictionary dictionary =
                new FileDictionary("/usr/share/dict/words");
        final SpellCheckApplication checker =
                new SpellCheckApplication(dictionary);
        final List<String> wordsFromFile = getWordsFromFile(args[0]);

        final List<Integer> indices = checker.checkDocument(wordsFromFile);

        if (indices.isEmpty()) {
            System.out.println("No spelling errors!");
        } else {
            System.out.println("The following words were spelled incorrectly:");
            for (final Integer index : indices) {
                System.out.println(wordsFromFile.get(index));
            }
        }
    }

    static List<String> getWordsFromFile(final String filename) {
        final List<String> wordsList = new LinkedList<>();
        try {
            final List lines = IOUtils.readLines(new FileInputStream(filename));
            for (Object fileLine : lines) {
                String line = (String) fileLine;
                final String[] words = line.split(" ");
                Collections.addAll(wordsList, words);
            }
        } catch (IOException e) {
            System.err.printf("Error trying to read from file: %s%n. Exception: %s", filename, e.getMessage());
        }
        return wordsList;
    }
}
