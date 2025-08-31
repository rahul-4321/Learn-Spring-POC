package com.rahul;

import java.beans.ConstructorProperties;

public class Alien {

    // private Laptop laptop;

    private Computer comp;
    private int val;
    private int age;
    
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        System.out.println("Setter called");
        this.val = val;
    }

    // public Laptop getLaptop() {
    //     return laptop;
    // }

    // public void setLaptop(Laptop laptop) {
    //     this.laptop = laptop;
    // }

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Alien(){
        System.out.println("Alien class Constructor");
    }

    Alien(int a){
        this.val=a;
        System.out.println("Parameterized constructor called");
    }

    // Alien(int val, Laptop laptop){
    //     System.out.println("primitive+ object type constructor called");
    //     this.laptop=laptop;
    //     this.val=val;
    // }
    // @ConstructorProperties({"val","laptop","age"})
    // Alien(int val, Laptop laptop, int age){
    //     System.out.println("three assignments- 2ints, 1 obj");
    //     this.laptop=laptop;
    //     this.val=val;
    //     this.age=age;
    // }

    public void alien(){
        val--;
        System.out.println("Alien class: "+ val);
        comp.compile();
    }

 
}
