package com.rahul.configuration;

import com.rahul.Desktop;
import com.rahul.Laptop;
import com.rahul.Alien;
import com.rahul.Computer;


import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Configuration
public class config {

    //we can give multiple names to single bean
    @Bean(name={"desk","desk1","beast"})
    // @Scope("prototype")
    public Desktop desktop1(){
        return new Desktop();
    }

    // @Bean
    // public Laptop comp(){
    //     return new Laptop();
    // }

    @Bean
    public Alien alien(@Autowired Computer comp){//not mandatory to use autowired
        Alien alien= new Alien();
        alien.setAge(22);
        alien.setVal(30);
        //alien.setComp(desktop1());//thightly coupled
        alien.setComp(comp);//loosely coupled
        return alien;
    }
}
