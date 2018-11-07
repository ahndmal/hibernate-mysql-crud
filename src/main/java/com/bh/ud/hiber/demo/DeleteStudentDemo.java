package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

            Student myStudent = session.get(Student.class, studentId);

//            session.delete(myStudent);

            session.createQuery("delete from" + Student.class.getSimpleName() + "where id=2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Deleted!");

        } finally {
            factory.close();
        }
    }
}
