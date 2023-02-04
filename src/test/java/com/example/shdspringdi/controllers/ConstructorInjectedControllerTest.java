package com.example.shdspringdi.controllers;

import com.example.shdspringdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.SysexMessage;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImpl());
        //mimicking Spring framework by manually creating the objects
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}