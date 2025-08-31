package com.rahul;

public class Desktop implements Computer{
    
    public Desktop(){
        System.out.println("Desktop class");
    }
    
    @Override
    public void compile(){
        System.out.println("Compiling through Desktop");
    }
}
