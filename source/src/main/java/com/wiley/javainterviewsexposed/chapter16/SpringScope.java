package com.wiley.javainterviewsexposed.chapter16;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.assertNotSame;

public class SpringScope {

    @Test
    public void differentInstanceScope() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("com/wiley/javainterviewsexposed/chapter16/applicationContext.xml");
        final Date date1 = context.getBean(Date.class);
        final Date date2 = context.getBean(Date.class);

        assertNotSame(date1, date2);
    }
}
