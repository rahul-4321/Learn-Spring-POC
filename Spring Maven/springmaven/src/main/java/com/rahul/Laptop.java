package com.rahul;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{
    
    public Laptop(){
        System.out.println("Laptop class");
    }

    @Override
    public void compile(){
        System.out.println("Compiling through laptop");
    }
}
