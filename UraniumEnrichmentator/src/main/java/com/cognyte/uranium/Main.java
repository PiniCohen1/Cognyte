package com.cognyte.uranium;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        UraniumEnrichmentatorImpl bean = context.getBean(UraniumEnrichmentatorImpl.class);
        bean.enrich();
    }
}
