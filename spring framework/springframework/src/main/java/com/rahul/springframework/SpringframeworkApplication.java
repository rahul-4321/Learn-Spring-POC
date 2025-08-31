package com.rahul.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rahul.springframework.model.Alien;
import com.rahul.springframework.model.Laptop;
import com.rahul.springframework.service.LaptopService;

@SpringBootApplication
public class SpringframeworkApplication {

	public static void main(String[] args) {

		ApplicationContext context= SpringApplication.run(SpringframeworkApplication.class, args);


		Laptop lap=context.getBean(Laptop.class);

		LaptopService service=context.getBean(LaptopService.class);
		service.addLaptop(lap);


		// System.out.println("Hello World");/
		// Alien obj=context.getBean(Alien.class);
		// obj.code();
		// System.out.println(obj.getAge());
	}

}
