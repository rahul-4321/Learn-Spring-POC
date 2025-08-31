package com.rahul.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.springframework.model.Laptop;
import com.rahul.springframework.repository.LaptopRepository;

@Service
public class LaptopService {

    LaptopService(){
        System.out.println("Laptop Service Class");
    }

    @Autowired
    private LaptopRepository LaptopRepo;

    public void addLaptop(Laptop lap){
        LaptopRepo.save(lap);
        System.out.println("Service called");
    }

    boolean isGoodForProgramming(Laptop lap){
        return false;
    }
}
