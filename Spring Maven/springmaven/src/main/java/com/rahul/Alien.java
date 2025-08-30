package com.rahul;

public class Alien {
    private int val;
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        System.out.println("Setter called");
        this.val = val;
    }

    Alien(){
        System.out.println("Alien class Constructor");
    }

    public void alien(){
        val--;
        System.out.println("Alien class :"+ val);
    }
}
