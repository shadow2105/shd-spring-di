package com.example.shdspringdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("\n< Creating a Singleton Bean.... >\n");
    }

    public String getScope() {
        return "# I am a Singleton !";
    }
}
