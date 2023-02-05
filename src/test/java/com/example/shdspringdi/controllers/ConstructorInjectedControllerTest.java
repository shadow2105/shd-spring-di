package com.example.shdspringdi.controllers;

import com.example.shdspringdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
        //mimicking Spring framework by manually creating the objects
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}