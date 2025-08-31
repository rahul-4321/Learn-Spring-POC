package com.rahul.springframework.repository;

import org.springframework.stereotype.Repository;

import com.rahul.springframework.model.Laptop;

@Repository
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println("Saved ");
    }

}
