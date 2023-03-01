package com.example.shdspringdi.config;

import com.example.shdspringdi.services.ConstructorGreetingService;
import com.example.shdspringdi.services.PropertyGreetingService;
import com.example.shdspringdi.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {
    //Bean generated in the Spring Context has the same as the method

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }
}
