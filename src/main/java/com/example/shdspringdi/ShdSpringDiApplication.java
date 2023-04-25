package com.example.shdspringdi;

import com.example.shdspringdi.config.ComConfig;
import com.example.shdspringdi.controllers.*;
import com.example.shdspringdi.datasource.FakeDataSource;
import com.example.shdspringdi.services.PrototypeBean;
import com.example.shdspringdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {"com.example.shdspringdi", "com.example.pets"})
@SpringBootApplication
public class ShdSpringDiApplication {

	public static void main(String[] args) {

		//public static ConfigurableApplicationContext run(Class<?> primarySource, String... args)
		//run method returns an ApplicationContext
		//SpringApplication.run(ShdSpringDiApplication.class, args);

		//storing ApplicationContext returned by run
		//https://www.baeldung.com/spring-application-context
		ApplicationContext aCtx = SpringApplication.run(ShdSpringDiApplication.class, args);

		/* https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
		Instead of having to call the dependency class or library and create its object manually
		to be used in the dependent class in our code, Frameworks utilizing Inversion of Control (a software engineering principle)
		are responsible for creating, providing and managing the objects of dependency classes or libraries to the dependent class.

		Dependency injection (a software design pattern) utilizes the control being inverted to set
		a dependent class object's dependencies (objects of other classes or libraries) at runtime (provided by Framework,
		like Spring ApplicationContext) rather than creating and providing them manually while writing our code.
		 */
		//asking returned ApplicationContext for an instance of the controller
		//no need to create the object manually as it's construction/instantiation is managed by the Spring ApplicationContext
		MyController myController = (MyController) aCtx.getBean("myController");
		//getBean() returns an object of type java.lang.Object and hence needs to be type-casted to an object controller class
		//getBean() takes a string argument to specify the controller object name (stored as controller class name in camelcase)

		//--------------------- Spring DI - using Constructor & specifying a Primary Bean --------------------------
		System.out.println("--------- DI Using Primary Bean ---------");
		//calling controller class object (returned by ApplicationContext) method(s)
		System.out.println(myController.sayHello());

		//--------------------- Spring DI - using Property/Field --------------------------
		System.out.println("\n--------- DI Using Property ---------");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) aCtx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		//--------------------- Spring DI - using Setter --------------------------
		System.out.println("\n--------- DI Using Setter ---------");

		SetterInjectedController setterInjectedController = (SetterInjectedController) aCtx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		//--------------------- Spring DI - using Constructor --------------------------
		System.out.println("\n--------- DI Using Constructor ---------");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) aCtx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());

		//--------------------- Spring DI - using Constructor & using Profiles --------------------------
		System.out.println("\n--------- Using Profiles ---------");

		I18nController i18nController = (I18nController) aCtx.getBean("i18nController");

		System.out.println(i18nController.sayHello());

		//--------------------- Spring DI - Assignment --------------------------
		PetController petController = aCtx.getBean("petController", PetController.class);

		System.out.println("\n-------- The Best Pet is --------");
		System.out.println(petController.whichPetIsTheBest());

		//--------------------- Spring Bean Scope (Default) - Singleton --------------------------
		System.out.println("\n-------- Singleton Bean Scope --------");
		SingletonBean singletonBean1 = aCtx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getScope());

		SingletonBean singletonBean2 = aCtx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getScope());

		//--------------------- Spring Bean Scope - Prototype --------------------------
		System.out.println("\n-------- Prototype Bean Scope --------");
		PrototypeBean prototypeBean1 = aCtx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());

		PrototypeBean prototypeBean2 = aCtx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());

		//--------------------- Spring External Properties --------------------------
		System.out.println("\n-------- Spring External Properties --------");
		FakeDataSource fakeDataSource = aCtx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

        //--------------------- Spring External Properties --------------------------
        System.out.println("\n-------- Configuration Properties Binding --------");
        ComConfig comConfig = aCtx.getBean(ComConfig.class);

        System.out.println(comConfig.getUsername());
        System.out.println(comConfig.getPassword());
        System.out.println(comConfig.getJdbcurl());

	}

}
