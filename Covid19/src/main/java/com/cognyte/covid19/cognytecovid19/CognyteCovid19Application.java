package com.cognyte.covid19.cognytecovid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cognyte.covid19.cognytecovid19.service",
                "com.cognyte.covid19.cognytecovid19.model"})
public class CognyteCovid19Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(CognyteCovid19Application.class, args);
        System.out.println(ctx);
    }

}
