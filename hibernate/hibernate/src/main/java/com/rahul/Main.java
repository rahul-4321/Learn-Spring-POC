package com.rahul;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {

        // Student s1= new Student();
        // s1.setsid(104);
        // s1.setmarks(2050);
        // s1.setsName("Prashant");

        Laptop l1=new Laptop();
        l1.setLid(1);
        l1.setBrand("Acer");
        l1.setModel("Predator");
        l1.setRAM(16);

        Laptop l2=new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("Alienware");
        l2.setRAM(32);

        Laptop l3=new Laptop();
        l3.setLid(3);
        l3.setBrand("Dell");
        l3.setModel("XPS");
        l3.setRAM(8);


        Alien a1=new Alien();
        a1.setId(1);
        a1.setName("Bimal");
        a1.setDomain("Development");
        a1.setLaptop(Arrays.asList(l1,l2));

        Alien a2=new Alien();
        a2.setId(2);
        a2.setName("Rohit");
        a2.setDomain("Doctor");
        a2.setLaptop(Arrays.asList(l3));

        Alien a3=new Alien();
        a3.setId(3);
        a3.setName("Anurag");
        a3.setDomain("Analytics");
        a3.setLaptop(Arrays.asList(l1,l3));
        
        l1.setAliens(Arrays.asList(a1,a3));
        l2.setAliens(Arrays.asList(a1));
        l3.setAliens(Arrays.asList(a2,a3));

        Configuration cfg= new Configuration();
        //cfg.addAnnotatedClass(com.rahul.Student.class);
        cfg.addAnnotatedClass(com.rahul.Alien.class);//we can also create a table in the DB using the code itself, annotations formate the column names, keys 
        cfg.addAnnotatedClass(com.rahul.Laptop.class);
        cfg.configure();

        //To create a session we need a "SessionFactory"
        SessionFactory sf=cfg.buildSessionFactory();

        Session session=sf.openSession();// null;//BEcause session is an interface and we can't create obj of it using new keyword
       

        /*-----------------------------------Create------------------------------------------------------------------------------- */
        /*
        Transaction transaction = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        
        transaction.commit();
        */

        // Alien a4=session.get(Alien.class,1);
        // System.out.println(a4);
        session.close();

        /*

        //HQL example
        Session s2=sf.openSession();
        // Query query=s2.createQuery("from Laptop where RAM=32",Laptop.class);
        // List<Laptop>laptops=query.getResultList();
        // System.out.println(laptops);

        String brand="Acer";
        Query query=s2.createQuery("select model from Laptop where Brand like ?1", String.class);
        
        // TypedQuery<String> query=s2.createQuery("select model from Laptop where Brand like ?1", String.class);
        query.setParameter(1, brand);
        
        List<String>laptops=query.getResultList();
        System.out.println("Laptops:  "+laptops);
        */
        

        /*-----------------------------------Read------------------------------------------------------------------------------- */
        // Student s2=null;
        // s2=session.get(Student.class,12);
        // System.out.println(s2);

        Session s3=sf.openSession();
        Laptop laptops=s3.get(Laptop.class,1);
        System.out.println(laptops);

        Session s4=sf.openSession();
        Laptop laptops1=s4.get(Laptop.class,1);
        System.out.println(laptops1);



        /*-----------------------------------Update------------------------------------------------------------------------------- */
        /*
         * if there is no data with the ID provided then it will simply insert the data
         */
        // Transaction transaction=session.beginTransaction();
        // session.merge(s1);
        // transaction.commit();


        /*-----------------------------------Delete------------------------------------------------------------------------------- */
        // Transaction transaction = session.beginTransaction();
        // Student s3=session.get(Student.class,103);
        // session.remove(s3);        
        // transaction.commit();

        sf.close();
    }
}