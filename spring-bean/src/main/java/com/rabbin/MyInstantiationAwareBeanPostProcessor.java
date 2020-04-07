package com.rabbin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.Objects;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (Objects.equals(beanClass, BeanLife.class)) {
            System.out.println("\n--MyInstantiationAwareBeanPostProcessor : postProcessBeforeInitialization: " + beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanLife) {
            System.out.println("\n--MyInstantiationAwareBeanPostProcessor : postProcessAfterInitialization: " + beanName);
        }
        return true;
    }
}