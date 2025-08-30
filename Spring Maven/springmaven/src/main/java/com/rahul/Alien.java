package com.rahul;

public class Alien {

    private Laptop laptop;
    private int val;
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        System.out.println("Setter called");
        this.val = val;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    Alien(){
        System.out.println("Alien class Constructor");
    }

    public void alien(){
        val--;
        System.out.println("Alien class :"+ val);
        laptop.compile();
    }

 
}
