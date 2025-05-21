package com.rahul.springframework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Autowired
    Laptop laptop;
    public void code(){
        laptop.show();
        System.out.println("Alien Class");
    }
}
