package com.rahul;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");

        // Alien obj= new Alien();
        Alien obj1=  context.getBean("alien",Alien.class);
        // Laptop laptop= context.getBean("laptop",Laptop.class);
        obj1.alien();
        //obj1.val=30;
        
    }
}
