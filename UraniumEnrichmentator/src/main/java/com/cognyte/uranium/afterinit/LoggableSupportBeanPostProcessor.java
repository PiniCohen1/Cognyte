package com.cognyte.uranium.afterinit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggableSupportBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        Class<?> beanClass = bean.getClass();

        if (beanClass.isAnnotationPresent(Loggable.class)) {

            // When can not create proxy from Interface (bean has not implemented any)
            // Try use another Proxy alternative
            if(beanClass.getInterfaces().length == 0) {
                // Create Proxy from Class using Cglib
                return Enhancer.create(beanClass, (InvocationHandler)
                        (proxy, method, args) -> invoke(bean, method, args));
//                return Enhancer.create(beanClass, new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        //return invoke(bean,method,args);
//                        System.out.println("**** Starting Logging for method:"+ method.getName()+" ****");
//                        long start = System.nanoTime();
//
//                        // Invoke the original method and save it returned value
//                        Object  retValue = method.invoke(bean, args);
//
//                        long end = System.nanoTime();
//                        System.out.println(end-start);
//                        System.out.println("**** Ending Logging for method:"+ method.getName()+" ****");
//
//                        // Return the value from the original method
//                        return retValue;
//                    }
//                });
            }

            // Or .. Create Proxy using Dynamic Proxy of java.lang.reflect
            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    beanClass.getInterfaces(),
                    (proxy, method, args) -> invoke(bean, method, args));
        }
        return bean;
    }

    private static Object invoke(Object bean, Method method, Object[] args)
            throws IllegalAccessException, InvocationTargetException {
            System.out.println("**** Starting Logging for method:"+ method.getName()+" ****");
        long start = System.nanoTime();

        // Invoke the original method and save it returned value
        Object  retValue = method.invoke(bean, args);

        long end = System.nanoTime();
        System.out.printf(
                "Method %s execution time:%.2f seconds%n",
                method.getName(), (float) (end - start) /1000000);
        System.out.println("**** Ending Logging for method:"+ method.getName()+" ****");

        // Return the value from the original method
        return retValue;
    }
}
