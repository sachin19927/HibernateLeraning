package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class StudentDemoDelete {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
													.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.err.println("getting student with id :2");
			Student mystStudent=session.get(Student.class,2);
			System.err.println("updating student :"+mystStudent );
			mystStudent.setFirstName("sachin");
			mystStudent.setLastName("hs gowda");  
			// till now it is updated in memory
			session.getTransaction().commit();
			// once we commit it will update in DB no need to save explictly save or update by simply commit it will update
			// since it is a persist object 
			
			//bulk update with condition 
			session=factory.getCurrentSession();
			session.beginTransaction();
			// update email for all students
			
			session.createQuery("update Student set email='sachin.hs@bcits.in'").executeUpdate();
			session.getTransaction().commit();
			System.err.println("done") ;
			
			
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			factory.close();
		}
	}

}
