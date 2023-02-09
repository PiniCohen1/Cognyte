package com.cognyte.examservice.examinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ExaminatorApplication {

	@Bean
	public RestTemplate examRestTemplate(RestTemplateBuilder builder) {
		RestTemplate examRestTemplate =  builder.build();
		// I can customize my rest template with any interceptor
		//examRestTemplate.setInterceptors(List.of(new BasicAuthenticationInterceptor()));
		return examRestTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ExaminatorApplication.class, args);
	}

}
