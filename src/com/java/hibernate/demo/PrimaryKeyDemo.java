package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		// add mulpile studnts
		try
		{
			//create 3 student object 
			System.out.println("Creating new Student Object :");
			Student student1=new Student("sachin", "gowda", "sachin19927@gmail.com");
			Student student2=new Student("soumya", "indi", "sachin19927@gmail.com");
			Student student3=new Student("darshan", "gowda", "sachin19927@gmail.com");
			
			session.beginTransaction();
			
			session.save(student1);
			session.save(student2);
			session.save(student3);
		
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
