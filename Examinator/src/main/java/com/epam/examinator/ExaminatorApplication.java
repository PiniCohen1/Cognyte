package com.epam.examinator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExaminatorApplication {

    @SneakyThrows
    public static void main(String[] args) {

        // How Dispatcher Servlet convert Object to JSON
        //ObjectMapper mapper = new ObjectMapper();
        //String s = mapper.writeValueAsString(new Person());
        ConfigurableApplicationContext context =
                SpringApplication.run(ExaminatorApplication.class, args);
    }

}
