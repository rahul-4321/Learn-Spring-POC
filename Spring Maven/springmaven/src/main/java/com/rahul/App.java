package com.rahul;

import com.rahul.configuration.config;
import com.rahul.configuration.configComponent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context=new AnnotationConfigApplicationContext(configComponent.class);
        
        //configuration through config class
        //ApplicationContext context= new AnnotationConfigApplicationContext(config.class);

        Alien alienObj=context.getBean("alien",Alien.class);
        // alienObj.setVal(25);
        alienObj.alien();

        // Desktop dtObj=context.getBean("beast",Desktop.class);
        // dtObj.compile();

        // Desktop dtobj1=context.getBean("desk",Desktop.class);
        // dtobj1.compile();



        /*
        //configuration through xml file
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

        // Alien obj= new Alien();
        Alien obj1=  context.getBean("alien",Alien.class);
        // Laptop laptop= context.getBean("laptop",Laptop.class);
        obj1.alien();
        //obj1.val=30;
        // Computer comp=context.getBean("comp1",Desktop.class);

        */
        
    }
}
