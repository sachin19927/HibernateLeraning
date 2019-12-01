package com.java.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;

public class StudentDemoQuery {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			// query studnet
			List<Student> myStudents=session.createQuery("from Student").list();
			
			/*
			 * //display studnet for (Student student : myStudents) {
			 * System.err.println(student); }
			 */ // same extracketrd into method-> displayStudents
			
			//display studnet
			System.out.println("student whose last name is hs");
			displayStudents(myStudents);

			
			// query studnt with last name 'hs'
			
			myStudents=session.createQuery("from Student s where s.lastName='hs'").getResultList();
			
			displayStudents(myStudents);
			
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

	private static void displayStudents(List<Student> myStudents) {
		for (Student student : myStudents) {
			System.err.println(student);
		}
	}

}
