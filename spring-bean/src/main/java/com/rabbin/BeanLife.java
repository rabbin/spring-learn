package com.rabbin;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanLife implements InitializingBean, DisposableBean {
    private BeanProperty beanProperty;
    private BeanPropertySet beanPropertySet;

    public BeanLife(BeanProperty beanProperty) {
        System.out.println("\n--constructor");
        this.beanProperty = beanProperty;
        System.out.println(beanProperty);
        System.out.println(beanPropertySet);
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
}
