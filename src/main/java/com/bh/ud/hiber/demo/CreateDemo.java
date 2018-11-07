package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Instructor;
import com.bh.ud.hiber.entity.InstructorDetail;
import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor = new Instructor("Chad", "Garry", "mail_34");

            InstructorDetail instructorDetail = new InstructorDetail("channel_1", "sports");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();



            session.getTransaction().commit();

            System.out.println("Success!");

        } finally {
            factory.close();
        }
    }
}
