package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(
  "classpath:com/wiley/javainterviewsexposed/chapter16/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringIntegrationTest {

    @Autowired
    private SpellCheckApplication application;


    @Test
    public void checkWiring() {
        assertNotNull(application);
    }

    @Test
    public void useSpringIntegrationTests() {

        final List<String> words = Arrays.asList(
                "correct",
                "valid",
                "dfgluharg",
                "acceptable");
        final List<Integer> expectedInvalidIndices = Arrays.asList(2);

        final List<Integer> actualInvalidIndices =
                                      application.checkDocument(words);

        assertEquals(expectedInvalidIndices, actualInvalidIndices);
    }
}
