package org.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Apple");
        l1.setModel("Air M2");
        l1.setRam(8);

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Abhishek");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Alien.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(a1);

        Alien a2 = session.find(Alien.class, 101);
        transaction.commit();


        session.close();
        sf.close();
        System.out.println(a2);

    }
}