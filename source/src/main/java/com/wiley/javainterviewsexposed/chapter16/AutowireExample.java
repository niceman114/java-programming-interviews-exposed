package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class AutowireExample {

    @Test
    public void getAutowiredBean() {
        final ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "com/wiley/javainterviewsexposed/" +
                                "chapter16/applicationContextAutowiring.xml");
        final SpellCheckApplication bean =
                context.getBean(SpellCheckApplication.class);
        assertNotNull(bean);
    }
}
