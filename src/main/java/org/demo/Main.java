package org.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        // select * from laptop where ram=16; -> SQL
        // from laptop where ram=16; -> HQL

        String brand = "Apple";
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

        //Laptop l5 = session.find(Laptop.class,4);

        for (Object[] data : laptops) {
            System.out.println(data[0] + " " + data[1]);
        }

        session.close();
        sf.close();
//        System.out.println(laptops);
    }
}