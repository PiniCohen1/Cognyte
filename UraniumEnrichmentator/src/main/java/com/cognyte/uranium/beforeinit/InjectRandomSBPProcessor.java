package com.cognyte.uranium.beforeinit;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomSBPProcessor implements BeanPostProcessor {

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        // 1. Getting all bean field for The specific bean which actually processing now
        Field[] fields = bean.getClass().getDeclaredFields();

        // 2. Iterating all fields, seek for our mark (specific annotation)
        for(Field field: fields) {
            InjectRandom annotation = field.getAnnotation(InjectRandom.class);

            // 3. If annotation found, do our logic
            if(annotation != null) {

                // 4. getting value from annotation parameters
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();
                int value = random.nextInt(max-min) + min;

                // 5. Now the Injection , Set the field with our calculating value
                field.setAccessible(true); // To allow setting private fields
                field.set(bean,value);
            }
        }

        // 6. Return the modified / result bean
        return bean;
    }
}
