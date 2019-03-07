package com.wiley.javainterviewsexposed.chapter16;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckApplication {

    private final Dictionary dictionary;

    public SpellCheckApplication(final Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<Integer> checkDocument(List<String> document) {
        final List<Integer> misspelledWords = new ArrayList<>();

        for (int i = 0; i < document.size(); i++) {
            final String word = document.get(i);
            if (!dictionary.validWord(word)) {
                misspelledWords.add(i);
            }
        }

        return misspelledWords;
    }
}
