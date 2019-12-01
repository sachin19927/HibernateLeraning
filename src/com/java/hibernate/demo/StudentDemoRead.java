package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class StudentDemoRead {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
													.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object :");
			Student student=new Student("sachin", "hs", "sachin19927@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			//fin out studnt ID : priamry key id is auto increment id cloum will be update once we save it 
			System.err.println("Save student generate ID :"+student.getId());
			// now get new seesion and start trnaction
			 session = factory.getCurrentSession();
			session.beginTransaction();
			// retives studnt based on : primary key
			System.err.println("getting student with id :"+ student.getId());
			Student mystStudent=session.get(Student.class,student.getId());
			// if primary key invalid result is null bcz not found
			System.err.println("Get complete :"+mystStudent);
			// commit transaction
			session.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			factory.close();
		}
	}

}
