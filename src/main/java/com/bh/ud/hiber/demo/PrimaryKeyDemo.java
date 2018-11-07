package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Chris", "Rock", "mail1");
            Student student2 = new Student("Ignat", "Smalnyi", "mail1ddd");
            Student student3 = new Student("Egor", "Petrov", "mail1asd");

            session.beginTransaction();

            session.save(student);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

            System.out.println("Success!");

        } finally {
            factory.close();
        }
    }
}
