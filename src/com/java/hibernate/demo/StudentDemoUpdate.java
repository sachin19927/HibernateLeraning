package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class StudentDemoUpdate {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
													.buildSessionFactory();
		try {
			Session session=factory.getCurrentSession();
			session.beginTransaction();
			System.err.println("getting student with id :2");
			Student mystStudent=session.get(Student.class,2);
			System.err.println("deleting student :"+mystStudent );
			// deleting student
			session.delete(mystStudent);
			session.getTransaction().commit();
			// delete the object
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where firstName='darshan'").executeUpdate();
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
