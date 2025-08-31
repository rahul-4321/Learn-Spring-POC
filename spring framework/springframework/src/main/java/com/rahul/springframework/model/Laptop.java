package com.rahul.springframework.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    Laptop(){
        System.out.println("Laptop Class");
    }

    public void show(){
        System.out.println("Laptop class");
    }
    public void compile(){
        System.out.println("Compiling code through Laptop");
    }
}
