package com.rabbin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLife implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
    private BeanProperty beanProperty;
    private BeanPropertySet beanPropertySet;

    public BeanLife(BeanProperty beanProperty) {
        System.out.println("\n--开始实例化");
        System.out.println("\n--constructor");
        this.beanProperty = beanProperty;
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
        System.out.println("\n--实例化之后");
    }

    public void setBeanPropertySet(BeanPropertySet beanPropertySet) {
        this.beanPropertySet = beanPropertySet;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\n--DisposableBean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("\n--InitializingBean");
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("\n--@PostConstruct");
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\n--销毁之前");
        System.out.println("\n--@PreDestroy");
    }

    public void init() {
        System.out.println("\n--init");
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
    }

    public void cleanUp() {
        System.out.println("\n--cleanUp");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("\n--BeanFactoryAware : BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("\n--BeanNameAware : setBeanName");
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("\n--ApplicationContextAware : ApplicationContextAware");
    }

    public BeanProperty getBeanProperty() {
        return beanProperty;
    }

    public void setBeanProperty(BeanProperty beanProperty) {
        this.beanProperty = beanProperty;
    }

    public BeanPropertySet getBeanPropertySet() {
        return beanPropertySet;
    }
}
