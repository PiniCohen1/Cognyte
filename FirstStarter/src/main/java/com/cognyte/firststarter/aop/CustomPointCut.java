package com.cognyte.firststarter.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Method;

public class CustomPointCut extends DynamicMethodMatcherPointcut {
    @Value("${exception.packages}")
    private String packageToHandle;
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        /***
         *  We Can filter on which specific methods we interest to modify
         *  Help Spring InvocationHandler to optimized and avoid using proxy if unnecessary
         *  Or return true, for effect all method in the matching class
        ***/
        // return method.isAnnotationPresent(MyCustomAnnotation.class);

        return true;
    }

    @Override
    public ClassFilter getClassFilter() {

        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                return clazz.getPackage().getName().contains(packageToHandle);
            }
        };
    }
}
