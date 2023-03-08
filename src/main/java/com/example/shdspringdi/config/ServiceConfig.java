package com.example.shdspringdi.config;

import com.example.pets.CatPetService;
import com.example.pets.DogPetService;
import com.example.pets.PetService;
import com.example.pets.PetServiceFactory;
import com.example.shdspringdi.datasource.FakeDataSource;
import com.example.shdspringdi.repositories.EnglishGreetingRepository;
import com.example.shdspringdi.repositories.EnglishGreetingRepositoryImpl;
import com.example.shdspringdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:service-config.xml")     //or annotate the Application class (ShdSpringDiApplication)
@Configuration
public class ServiceConfig {
    //Bean generated in the Spring Context has the same as the method

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}")String username, @Value("${com.password}")String password, @Value("${com.jdbcurl}")String jdbcurl) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    //Beans with same name mapped to different profiles
    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean("i18nService")        //Specified Bean name is used in Spring Context
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }
}
