package com.cognyte.infrastarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "cognyte.logging", havingValue = "true")
@EnableConfigurationProperties(InfraProperties.class)
public class CognyteInfraConfig {
    @Bean
    @ConditionalOnMissingBean
    public CognyteLogger cognyteLogger() {
        return new CognyteLogger();
    }
}