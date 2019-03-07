package com.wiley.javainterviewsexposed.chapter16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static com.wiley.javainterviewsexposed.chapter16.SpellCheckRunner.getWordsFromFile;

public class SpringJavaInjectedSpellChecker {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Usage java SpellCheckRunner <file_to_check>");
            System.exit(-1);
        }

//        final ApplicationContext context = new ClassPathXmlApplicationContext("com/wiley/javainterviewsexposed/chapter16/applicationContextForJava.xml");
        final ApplicationContext context = new AnnotationConfigApplicationContext(SpringJavaConfiguration.class);
        final SpellCheckApplication checker = context.getBean(SpellCheckApplication.class);

        final List<String> wordsFromFile = getWordsFromFile(args[0]);

        final List<Integer> misspelledWordIndices = checker.checkDocument(wordsFromFile);

        if (misspelledWordIndices.isEmpty()) {
            System.out.println("No spelling errors!");
        } else {
            System.out.println("The following words were spelled wrong:");
            for (final Integer index : misspelledWordIndices) {
                System.out.println(wordsFromFile.get(index));
            }
        }
    }
}
