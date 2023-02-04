package com.example.shdspringdi;

import com.example.shdspringdi.controllers.ConstructorInjectedController;
import com.example.shdspringdi.controllers.MyController;
import com.example.shdspringdi.controllers.PropertyInjectedController;
import com.example.shdspringdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

		Dependency injection (a software design pattern based on IoC) utilizes the control being inverted to set
		a dependent class object's dependencies (objects of other classes or libraries) at runtime (provided by Framework,
		like Spring ApplicationContext) rather than creating and providing them manually while writing our code.
		 */
		//asking returned ApplicationContext for an instance of the controller
		//no need to create the object manually as it's construction/instantiation is managed by the Spring ApplicationContext
		MyController myController = (MyController) aCtx.getBean("myController");
		//getBean() returns an object of type java.lang.Object and hence needs to be type-casted to an object controller class
		//getBean() takes a string argument to specify the controller object name (stored as controller class name in camelcase)


		//calling controller class object (returned by ApplicationContext) method(s)
		String greeting = myController.sayHello();
		System.out.println(greeting);

		//--------------------- Spring DI - using Property/Field --------------------------
		System.out.println("--------- DI Using Property ---------");

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
	}

}
