package com.wiley.javainterviewsexposed.chapter16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import static com.wiley.javainterviewsexposed.chapter16.SpellCheckRunner.getWordsFromFile;

public class SpringXmlInjectedSpellChecker {

    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Usage java SpellCheckRunner <file_to_check>");
            System.exit(-1);
        }

        final ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "com/wiley/javainterviewsexposed/" +
                                "chapter16/applicationContext.xml");

        final SpellCheckApplication checker =
                context.getBean(SpellCheckApplication.class);

        final List<String> wordsFromFile = getWordsFromFile(args[0]);

        final List<Integer> indices = checker.checkDocument(wordsFromFile);

        if (indices.isEmpty()) {
            System.out.println("No spelling errors!");
        } else {
            System.out.println("The following words were spelled wrong:");
            for (final Integer index : indices) {
                System.out.println(wordsFromFile.get(index));
            }
        }
    }
}
