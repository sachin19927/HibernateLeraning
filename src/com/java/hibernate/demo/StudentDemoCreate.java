package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class StudentDemoCreate {

	public static void main(String[] args) {

		// create Session factory 
		// will be creatred once and  "hibernate.cfg.xml" is not reuired if cfg is in src root 
		// bcz it will automatically search for this config file name in src
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// create session
		// can get session from session factory
		Session session=factory.getCurrentSession();
		
		try {
			// use session object to save / retive
			
			//create student object 
			System.out.println("Creating new Student Object :");
			Student student=new Student("sachin", "hs", "sachin19927@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			// save transation
			System.out.println("saving Student Object");
			session.save(student);
			
			// commit tranaction
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
