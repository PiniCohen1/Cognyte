package com.cognyte.firststarter;

import com.cognyte.firststarter.aop.CustomPointCut;
import com.cognyte.firststarter.aop.EmailExceptionDistributor;
import com.cognyte.firststarter.aop.ExceptionDistributor;
import com.cognyte.firststarter.aop.ExceptionHandlerAspect;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
//@Profile("AOP")
public class AOPConfig {

    @Bean
    @ConditionalOnMissingBean
    public ExceptionDistributor emailExceptionDistributor() {
        return new EmailExceptionDistributor();
    }
    @Bean
    public CustomPointCut customPointCut() {
        return new CustomPointCut();
    }

    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        return new DefaultPointcutAdvisor(customPointCut(),exceptionHandlerAspect());

    }
}
