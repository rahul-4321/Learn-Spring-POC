package com.rahul;

public class Alien {
    int val;
    Alien(){
        this.val=10;
        System.out.println("Alien class Constructor");
    }

    public void alien(){
        val--;
        System.out.println("Alien class :"+ val);
    }
}
