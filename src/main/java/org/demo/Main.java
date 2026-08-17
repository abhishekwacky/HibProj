package org.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setsName("Neha");
        s1.setRollNo(107);
        s1.setsAge(29);

//        Student s2 = null;

        // This actually loads the configuration
        // If you want hibernate to manage your class then you have to use Annotation (@Entity)
//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(Student.class);
//        cfg.configure();

//        SessionFactory sf = cfg.buildSessionFactory();
        SessionFactory sf = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();
        Session session = sf.openSession();
        s1 = session.find(Student.class, 1034);
        Transaction transaction = session.beginTransaction();
//        session.persist(s1);
//        session.merge(s1);
        session.remove(s1);
        transaction.commit();


//         s2 = session.find(Student.class, 102);

        session.close();
        sf.close();
        System.out.println(s1);
    }
}