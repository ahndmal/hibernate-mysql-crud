package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Student student = new Student("Paul", "Walker", "mail1");

            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();

            System.out.println("Success!");

            session = factory.getCurrentSession();

            session.beginTransaction();

            // NEW

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Success reading!");

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
