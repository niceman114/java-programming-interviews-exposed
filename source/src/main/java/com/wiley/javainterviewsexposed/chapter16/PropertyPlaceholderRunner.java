package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/wiley/javainterviewsexposed/chapter16/propertyPlaceholderApplicationContext.xml")
public class PropertyPlaceholderRunner {

    @Test
    public void createContext() {
        assertTrue(true);
    }
}
