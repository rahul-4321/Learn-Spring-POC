package com.rahul.springframework.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Desktop implements Computer{

    Desktop(){
        System.out.println("Desktop Class");
    }
    public void compile(){
        System.out.println("Compiling code through Desktop");
    }

}
