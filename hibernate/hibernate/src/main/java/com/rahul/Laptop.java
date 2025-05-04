package com.rahul;

import java.util.List;

import jakarta.persistence.Cacheable;
//import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

//This class is used as an example for embedables
//Embeddable
@Entity
@Cacheable
public class Laptop {

    @Id
    private int Lid;
    private String Brand;
    private int RAM;
    private String model;

    // @ManyToOne
    // private Alien alien;
    @ManyToMany(mappedBy = "laptops")
    private List<Alien> aliens;

    public int getLid() {
        return Lid;
    }
    public void setLid(int lid) {
        Lid = lid;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String brand) {
        Brand = brand;
    }
    public int getRAM() {
        return RAM;
    }
    public void setRAM(int rAM) {
        RAM = rAM;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    // public Alien getAlien() {
    //     return alien;
    // }
    // public void setAlien(Alien alien) {
    //     this.alien = alien;
    // }

    public List<Alien> getAliens() {
        return aliens;
    }
    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }
    
    @Override
    public String toString() {
        return "Laptop [Brand=" + Brand + ", RAM=" + RAM + ", model=" + model + "]";
    }
    
}
