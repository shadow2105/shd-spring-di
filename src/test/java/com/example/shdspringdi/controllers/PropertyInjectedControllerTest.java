package com.example.shdspringdi.controllers;

import com.example.shdspringdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    //The setUp method is a hook provided by JUnit that executes prior to each and every test method you define
    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();  //mimicking Spring framework by manually creating the objects
        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}