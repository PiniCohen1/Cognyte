package com.cognyte.uranium;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Init Spring using XML
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        // Init Spring using Java annotations
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Init Spring Application
        //ConfigurableApplicationContext context = SpringApplication.run(MainConfig.class);

        // Wrong ! always use Interface when asking for bean from context !
        // The impl can be changed If bean had been proxy
        //UraniumEnrichmentatorImpl bean = context.getBean(UraniumEnrichmentatorImpl.class);
        UraniumEnrichmentatorImpl bean = context.getBean(UraniumEnrichmentatorImpl.class);
        bean.enrich();
    }
}
