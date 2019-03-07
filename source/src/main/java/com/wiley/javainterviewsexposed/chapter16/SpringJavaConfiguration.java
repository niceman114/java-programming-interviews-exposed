package com.wiley.javainterviewsexposed.chapter16;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SpringJavaConfiguration {

    @Bean
    public Dictionary dictionary() throws IOException {
        return new FileDictionary("/usr/share/dict/words");
    }

    @Bean
    public SpellCheckApplication spellCheckApplication() throws IOException {
        return new SpellCheckApplication(dictionary());
    }
}
