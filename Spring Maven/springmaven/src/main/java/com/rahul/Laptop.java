package com.rahul;

public class Laptop implements Computer{
    
    public Laptop(){
        System.out.println("Laptop class");
    }

    @Override
    public void compile(){
        System.out.println("Compiling through laptop");
    }
}
