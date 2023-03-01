package com.example.shdspringdi.services;

import org.springframework.stereotype.Service;

public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World!! - Constructor";       //Greeting in English
    }
}
