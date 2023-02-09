package com.example.shdspringdi.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("\n## Bean Factory has been set: " + beanFactory.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("\n## Application context has been set: " + applicationContext.toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle bean has been terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");

    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("\n## The Predestroy annotated method has been called");
    }

    public void beforeInit(){
        System.out.println("\n## - Before Init - Called by Bean Post Processor");
    }

    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor\n");
    }
}
