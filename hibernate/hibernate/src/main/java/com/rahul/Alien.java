package com.rahul;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;

import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="alien_table")
public class Alien {

    @Id
    @Column(name="alien_id")
    private int id;
    private String name;
    private String domain;

    // @OneToOne
    // private Laptop laptop;
    /*
     * One person can have many laptops so we now move to one-to-many mapping, this will create a composite table that will point to the ids of 
     * laptop that one person is having
     */
    // @OneToMany
    // private List<Laptop> laptops;
    /*
     * one-to-many mapping needs an extra table, but what if we do not need a new table.
     * In this case we will need to create a many-to-one mapping i.e. many laptops will belong to one person
     * For this we will have many-to-one mapping from laptop perspective.
     * from alien perspective one-to-many still exits which can still lead to creation of new composite table
     * To counter this we need to say to alien table that "you do not create the mapping work, it will be done by laptop table itself"
     * To achieve this we will provide a parameter to the annotation of @onetomany(mapped by="alien") ,"alien" is a variable in Laptop.java
     */
    // @OneToMany(mappedBy = "alien")
    // private List<Laptop> laptops;

    /*
     * now we go with many-to-many mapping
     */
    @ManyToMany
    private List<Laptop> laptops;


    @Transient
    private int index;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Laptop> getLaptop() {
        return laptops;
    }
    public void setLaptop(List<Laptop> laptops) {
        this.laptops = laptops;
    }
    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + ", domain=" + domain + ", laptop=" + laptops + "]";
    }
}
