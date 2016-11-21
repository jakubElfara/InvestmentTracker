package com.savingstream.tracker.core.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext
{
    private final static org.springframework.context.ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static org.springframework.context.ApplicationContext getApplicationContext()
    {
        return context;
    }

    public static Object getBean(final String beanName)
    {
        return getApplicationContext().getBean(beanName);
    }

    public static <T> T getBean(final String beanName, Class<T> tClass)
    {
        return (T) getApplicationContext().getBean(beanName);
    }
}