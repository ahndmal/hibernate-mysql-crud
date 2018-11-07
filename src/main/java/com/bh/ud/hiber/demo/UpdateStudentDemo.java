package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 1;

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Getting student with id " + studentId);

            // NEW

            Student myStudent = session.get(Student.class, studentId);

            myStudent.setFirstName("Scooby");

            System.out.println("Success reading!");

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
