package com.example.shdspringdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World!! - EN";
    }
}
