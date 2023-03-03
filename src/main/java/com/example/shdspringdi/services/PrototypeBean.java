package com.example.shdspringdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("\n<<<<< Creating a Prototype Bean.... >>>>>");
    }

    public String getScope() {
        return "##### I am a Prototype !";
    }
}
