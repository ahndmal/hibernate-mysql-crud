package com.bh.ud.hiber.demo;

import com.bh.ud.hiber.entity.Course;
import com.bh.ud.hiber.entity.Instructor;
import com.bh.ud.hiber.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i" + "JOIN FETCH i.courses", Instructor.class);

			Instructor tempInstructor = session.get(Instructor.class, theId);		
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
		
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("The session is now closed!\n");

			// option 1: call getter method while session is open
			
			// get courses for the instructor
			System.out.println(" Courses: " + tempInstructor.getCourses());
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}
}