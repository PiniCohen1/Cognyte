package com.cognyte.uranium;

import com.cognyte.uranium.afterinit.Loggable;
import com.cognyte.uranium.beforeinit.InjectRandom;
import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Loggable
@Component
public class UraniumEnrichmentatorImpl /*implements UraniumEnrichmentator*/ {
    @Setter
    @InjectRandom(min=10,max=15)
    private int number = 100; // If will we set a value here ?
    public UraniumEnrichmentatorImpl() {
        System.out.println("Phase 1 enrichmentator constructor is invoked");
        init();
    }

    private void init() {

        System.out.println("init is working..."+number);
    }

    @PostConstruct // The right way to invoke method after constructor with Spring support
    private void initWithSpring() {

        System.out.println("Post Constructor init is working..."+number);
    }

    //@Override
    @Scheduled(fixedDelay = 500)
    public void enrich() {
        System.out.println("Enriching generator "+ number);
    }
}
