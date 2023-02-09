package com.cognyte.firststarter;

import com.cognyte.firststarter.services.StartService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
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
