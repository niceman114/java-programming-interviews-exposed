package com.wiley.javainterviewsexposed.chapter16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class SpellCheckApplicationAutowired {

    @Autowired
    @Qualifier("englishDictionary")
    private Dictionary dictionary;

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
