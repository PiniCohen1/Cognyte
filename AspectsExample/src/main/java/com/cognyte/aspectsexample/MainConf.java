package com.cognyte.aspectsexample;

import com.cognyte.aspectsexample.services.StartService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@ImportResource("classpath:aop.xml")
@PropertySource("classpath:mails.properties")
@EnableAspectJAutoProxy
public class MainConf {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConf.class);

        StartService bean = context.getBean(StartService.class);
        try {
            bean.start();
        } catch (Exception e) {
            System.out.println("problem, we will try again later");
        }
    }
}
